package com.acaclan.aceclan.service;

import com.acaclan.aceclan.data.model.Clan;
import com.acaclan.aceclan.dto.request.LoginRequest;
import com.acaclan.aceclan.dto.request.RegisterClanRequest;
import com.acaclan.aceclan.dto.response.ApiResponse;

import java.util.List;

public interface ClanService {
    ApiResponse<Clan> addClan(RegisterClanRequest clanRequest);

    List<Clan> getUsers();

    Clan login(LoginRequest request);
}
