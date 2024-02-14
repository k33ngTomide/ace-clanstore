package com.acaclan.aceclan.data.dao;

import com.acaclan.aceclan.data.model.Clan;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ClanDAO extends MongoRepository<Clan, String> {
    Optional<Clan> findClanByUsername(String username);
}
