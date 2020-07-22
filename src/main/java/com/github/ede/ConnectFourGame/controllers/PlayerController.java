package com.github.ede.ConnectFourGame.controllers;

import com.github.ede.ConnectFourGame.models.Player;
import com.github.ede.ConnectFourGame.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/players")
@CrossOrigin(origins = "http://localhost:3000")
public class PlayerController {
    @Autowired
    PlayerRepository playerRepository;

    @PostMapping
    public ResponseEntity<Player> addPlayer(@Valid @RequestBody Player player){
       connectFourPlayer = playerRepository.save(player);
       return ResponseEntity.ok(player);
    }
}
