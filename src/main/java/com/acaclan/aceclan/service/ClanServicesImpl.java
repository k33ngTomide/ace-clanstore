package com.acaclan.aceclan.service;

import com.acaclan.aceclan.data.dao.ClanDAO;
import com.acaclan.aceclan.data.model.Clan;
import com.acaclan.aceclan.dto.request.AddPictureRequest;
import com.acaclan.aceclan.dto.request.LoginRequest;
import com.acaclan.aceclan.dto.request.RegisterClanRequest;
import com.acaclan.aceclan.dto.response.ApiResponse;
import com.acaclan.aceclan.exception.IncorrectPasswordException;
import com.acaclan.aceclan.exception.UserAlreadyExistsException;
import com.acaclan.aceclan.exception.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClanServicesImpl implements ClanService{

    private ClanDAO clanDAO;
    private ModelMapper modelMapper;
    private CloudinaryService cloudinaryService;

    @Override
    public ApiResponse<Clan> addClan(RegisterClanRequest clanRequest) {
        validateUserDoesNotExist(clanRequest.getUsername(), clanRequest.getEmail());
        Clan clan = modelMapper.map(clanRequest, Clan.class);
        clan.setDateCreated(LocalDate.now());

        Clan savedClan = clanDAO.save(clan);
        return new ApiResponse<>(
                savedClan,
                HttpStatus.CREATED.toString(),
                "Account Created Successfully");
    }

    private void validateUserDoesNotExist(String username, String email) {

        Optional<Clan> clan = clanDAO.findClanByUsernameOrEmail(username, email);
        if(clan.isPresent())
            throw new UserAlreadyExistsException("Username or email already Used");
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


    @Override
    public Clan addPicture(AddPictureRequest<MultipartFile> addPictureRequest) {
        Clan foundClan = findClan(addPictureRequest.getUsername());
        String imageUrl = cloudinaryService.upload(addPictureRequest.getPicture());

        foundClan.setPictureLink(imageUrl);
        return clanDAO.save(foundClan);

    }
}
