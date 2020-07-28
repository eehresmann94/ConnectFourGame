package com.github.ede.ConnectFourGame.controllers;


import com.github.ede.ConnectFourGame.models.Game;
import com.github.ede.ConnectFourGame.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping(path = "/games")
@CrossOrigin(origins = "http://localhost:3000")
public class GameController {
    @Autowired
    GameRepository gameRepository;

    @PostMapping
    public ResponseEntity<Game> addGame(@Valid @RequestBody Game game) {
        Game connectFourGame = gameRepository.save(game);
        return ResponseEntity.ok(game);
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