package com.github.ede.ConnectFourGame.services;

import com.github.ede.ConnectFourGame.models.Game;
import com.github.ede.ConnectFourGame.models.Player;
import com.github.ede.ConnectFourGame.repository.GameRepository;
import com.github.ede.ConnectFourGame.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GameService {
   @Autowired
    GameRepository gameRepository;
   @Autowired
    PlayerRepository playerRepository;

    public Long createGame(Player player){
        player = playerRepository.save(player);
        Game newGame = new Game();
        newGame.setPlayer1(player);
        newGame = gameRepository.save(newGame);
        return newGame.getGameId();
    }
}
