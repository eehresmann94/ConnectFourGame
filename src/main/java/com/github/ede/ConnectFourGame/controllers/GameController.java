package com.github.ede.ConnectFourGame.controllers;


import com.github.ede.ConnectFourGame.models.Game;
import com.github.ede.ConnectFourGame.models.Player;
import com.github.ede.ConnectFourGame.repository.GameRepository;
import com.github.ede.ConnectFourGame.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Provider;
import java.util.Optional;

@Controller
@RequestMapping(path = "/games")
@CrossOrigin(origins = "http://localhost:3000")
public class GameController {
    @Autowired
    GameService gameService;
    @Autowired
    GameRepository gameRepository;
    @PostMapping(value = "/creategame")
    public ResponseEntity<Long> addGame(@Valid @RequestBody Player player) {
        Long gameId = gameService.createGame(player);
        return ResponseEntity.ok(gameId);
    }

    @GetMapping("/game/{gameId}")
    public ResponseEntity<Game> getGame(@PathVariable("gameId") Long gameId) {
        Game connectFourGame = gameRepository.findById(gameId).orElse(null);
        assert connectFourGame != null;
        return ResponseEntity.ok(connectFourGame);
    }

    @DeleteMapping("/game/{gameId}")
    public ResponseEntity<String> deleteGame(@PathVariable("gameId") Long gameId) {
        //deletes game record based off of gameId passed
        gameRepository.deleteById(gameId);
        //If the delete was not completed returns a bad response
        if (gameRepository.findById(gameId).orElse(null) != null) {
            return (ResponseEntity<String>) ResponseEntity.badRequest();
        } else {
            return ResponseEntity.ok("Your Game was deleted");
        }

    }
}