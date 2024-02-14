package com.acaclan.aceclan.controler;

import com.acaclan.aceclan.data.model.Clan;
import com.acaclan.aceclan.dto.request.LoginRequest;
import com.acaclan.aceclan.dto.request.RegisterClanRequest;
import com.acaclan.aceclan.dto.response.ApiResponse;
import com.acaclan.aceclan.service.ClanService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/aceclan")
public class ClanController {

    private ClanService clanService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<Clan>> addUser(@RequestBody RegisterClanRequest clanRequest){
        ApiResponse<Clan> response = clanService.addClan(clanRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<Clan> addUser(@RequestBody LoginRequest request){
        Clan response = clanService.login(request);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }


    @GetMapping("/getUser")
    public ResponseEntity<List<Clan>> getUsers(){
        List<Clan> response = clanService.getUsers();
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }

}
