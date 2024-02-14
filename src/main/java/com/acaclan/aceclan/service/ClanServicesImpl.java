package com.acaclan.aceclan.service;

import com.acaclan.aceclan.data.dao.ClanDAO;
import com.acaclan.aceclan.data.model.Clan;
import com.acaclan.aceclan.dto.request.LoginRequest;
import com.acaclan.aceclan.dto.request.RegisterClanRequest;
import com.acaclan.aceclan.dto.response.ApiResponse;
import com.acaclan.aceclan.exception.IncorrectPasswordException;
import com.acaclan.aceclan.exception.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClanServicesImpl implements ClanService{

    private ClanDAO clanDAO;
    private ModelMapper modelMapper;

    @Override
    public ApiResponse<Clan> addClan(RegisterClanRequest clanRequest) {
        Clan clan = modelMapper.map(clanRequest, Clan.class);
        Clan savedClan = clanDAO.save(clan);
        return new ApiResponse<>(
                savedClan,
                HttpStatus.CREATED.toString(),
                "Account Created Successfully");
    }

    @Override
    public List<Clan> getUsers() {
        return clanDAO.findAll();
    }

    @Override
    public Clan login(LoginRequest request) {
        Clan clan = findClan(request.getUsername());
        if(!clan.getUsername().equals(request.getPassword())){
            throw new IncorrectPasswordException("Password is Incorrect");
        }
        return clan;
    }

    private Clan findClan(String username){
        Optional<Clan> clan = clanDAO.findClanByUsername(username);
        if(clan.isEmpty()){
            throw new UserNotFoundException("User not Found");
        }
        return clan.get();
    }

}
