package com.github.ede.ConnectFourGame.services;

import com.github.ede.ConnectFourGame.models.Board;
import com.github.ede.ConnectFourGame.models.Game;
import com.github.ede.ConnectFourGame.models.Piece;
import com.github.ede.ConnectFourGame.models.Player;
import com.github.ede.ConnectFourGame.repository.BoardRepository;
import com.github.ede.ConnectFourGame.repository.GameRepository;
import com.github.ede.ConnectFourGame.repository.PieceRepository;
import com.github.ede.ConnectFourGame.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;


@Service
public class GameService {
   @Autowired
    GameRepository gameRepository;
   @Autowired
    PlayerRepository playerRepository;
   @Autowired
    BoardRepository boardRepository;
   @Autowired
    PieceRepository pieceRepository;



    public Long createGame(Player player){
        //Saving the player to the Database
        player = playerRepository.save(player);
        Board board = new Board();
        board = boardRepository.save(board);
        Game newGame = new Game();
        newGame.setPlayer1(player);
        newGame.setGameBoard(board);
        newGame = gameRepository.save(newGame);
        return newGame.getGameId();
    }

    public Game appendPlayer2(Player player2, Long gameId){
        Random random = new Random();
        //Gets a Game Object from DB with passed argument gameId
        Game connectFourGame = gameRepository.getOne(gameId);
        //Saves the player to the db so it can be
        player2 = playerRepository.save(player2);
        connectFourGame.setPlayer2(player2);
        boolean turn = random.nextBoolean();
        connectFourGame.setPlayerTurnName(turn);
        connectFourGame = gameRepository.save(connectFourGame);
        return connectFourGame;
    }

    public Game turnService(Integer peiceXAxis, Long gameId){
        Game connectFourGame = gameRepository.getOne(gameId);
        List<Piece> pieceList = connectFourGame.getGameBoard().getGamePieces();
        int yAxisCounter = 1;
        for (int i = 0; i < pieceList.size(); i++) {
            if(pieceList.get(i).getXAxisLocation().equals(peiceXAxis)) {
                yAxisCounter++;
            }
        }
        if(yAxisCounter >6) {
            throw new RuntimeException("This Column is filled with peices! Please make a new selection");
        }
        Piece newPiece = new Piece();
        newPiece.setXAxisLocation(peiceXAxis);
        newPiece.setYAxisLocation(yAxisCounter);
        newPiece.setGameBoardId(connectFourGame.getGameBoard().getGameBoardId());

        if(connectFourGame.getPlayerTurnName()){
            newPiece.setPieceColor("Red");
        }
        else {
            newPiece.setPieceColor("Black");
        }
        connectFourGame.setPlayerTurnName(!connectFourGame.getPlayerTurnName());

        newPiece = pieceRepository.save(newPiece);
        connectFourGame.getGameBoard().appendPiece(newPiece);

        connectFourGame = gameRepository.save(connectFourGame);
        return connectFourGame;

    }
}
