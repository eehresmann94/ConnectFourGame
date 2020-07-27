package com.github.ede.ConnectFourGame.controllers;

import com.github.ede.ConnectFourGame.models.Player;
import com.github.ede.ConnectFourGame.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/players")
@CrossOrigin(origins = "http://localhost:3000")
public class PlayerController {
    @Autowired
    PlayerRepository playerRepository;

    @PostMapping
    public ResponseEntity<Player> addPlayer(@Valid @RequestBody Player player){
       Player connectFourPlayer = playerRepository.save(player);
       return ResponseEntity.ok(connectFourPlayer);
    }

    @GetMapping("/players/{playerId}")
    public ResponseEntity<Player> getPlayer( @PathVariable("playerId") Long playerId){
        Player connectFourPlayer = playerRepository.findById(playerId).orElse(null);
        return  ResponseEntity.ok(connectFourPlayer);
    }

    @GetMapping("/players/name/{playerId}")
    public ResponseEntity<String>getPlayerName(@PathVariable("playerId") Long playerId){
        Player connectFourPlayer = playerRepository.findById(playerId).orElse(null);
        if( connectFourPlayer != null ) {
            ResponseEntity.ok(connectFourPlayer.getPlayerName());
        }
        else {
            ResponseEntity.notFound();
        }
        return null;
    }

    @DeleteMapping("/players/{playerId}")
    public ResponseEntity<String> deletePlayer(@PathVariable("playerId") Long playerId){
        playerRepository.deleteById(playerId);
        if( playerRepository.findById(playerId).orElse(null) != null){
            return (ResponseEntity<String>) ResponseEntity.badRequest();
        }
        return ResponseEntity.ok("Player was Deleted!");
    }
}
