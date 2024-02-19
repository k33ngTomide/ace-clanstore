package com.acaclan.aceclan.controler;

import com.acaclan.aceclan.data.model.Clan;
import com.acaclan.aceclan.dto.request.AddPictureRequest;
import com.acaclan.aceclan.dto.request.LoginRequest;
import com.acaclan.aceclan.dto.request.RegisterClanRequest;
import com.acaclan.aceclan.dto.response.ApiResponse;
import com.acaclan.aceclan.service.ClanService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/aceclan")
public class ClanController {

    private ClanService clanService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<Clan>> addUser(@RequestBody RegisterClanRequest clanRequest){
        try{
            ApiResponse<Clan> response = clanService.addClan(clanRequest);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch(Exception e){
            return new ResponseEntity<>(new ApiResponse<>(
                    null,
                    "Failed",
                    e.getMessage()), HttpStatus.EXPECTATION_FAILED);
        }
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

    @PostMapping("/addpicture/{username}")
    public ResponseEntity<ApiResponse<Clan>> addPicture(@RequestBody MultipartFile file, @PathVariable String username){
        try {
            AddPictureRequest<MultipartFile> request = new AddPictureRequest<>();
            request.setPicture(file);
            request.setUsername(username);
            return new ResponseEntity<>(new ApiResponse<>(
                    clanService.addPicture(request),
                    "200",
                    "Picture Added Successfully"), HttpStatus.CREATED);
        } catch (Exception error){
            return new ResponseEntity<> (new ApiResponse<>(
                    null,
                    "500",
                    error.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
}
