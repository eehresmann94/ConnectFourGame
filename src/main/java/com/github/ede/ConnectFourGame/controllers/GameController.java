package com.github.ede.ConnectFourGame.controllers;


import com.github.ede.ConnectFourGame.models.Game;
import com.github.ede.ConnectFourGame.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/games")
@CrossOrigin(origins = "http://localhost:3000")
public class GameController {
    @Autowired
    GameRepository gameRepository;

    @PostMapping
    public ResponseEntity<Game> addGame(@Valid @RequestBody Game game){
        Game connectFourGame = gameRepository.save(game);
        return ResponseEntity.ok(game);
    }

}
