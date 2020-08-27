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

    // Appends a second player to a current ConnectFourGame based on Id.
    public Game appendPlayer2(Player player2, Long gameId){
        Random random = new Random();
        //Gets a Game Object from DB with passed argument gameId
        Game connectFourGame = gameRepository.getOne(gameId);
        //Saves the player to so its Id can be referenced by the other functions
        player2 = playerRepository.save(player2);
        //appends player 2 to the connectFourGame
        connectFourGame.setPlayer2(player2);
        //creates the turn for the players and randomizes the turns
        boolean turn;
        turn = random.nextBoolean();
        connectFourGame.setPlayerTurnName(turn);
        connectFourGame = gameRepository.save(connectFourGame);
        return connectFourGame;
    }

    private boolean gameWinChecker(Game connectFourGame, Piece newPiece){
        if(
                verticalWinChecker(connectFourGame,newPiece) ||
                horizontalLeftWinChecker(connectFourGame,newPiece) ||
                horizontalRightWinChecker(connectFourGame,newPiece) ||
                diagonalUpRightWinChecker(connectFourGame,newPiece)||
                diagonalDownRightWinChecker(connectFourGame,newPiece) ||
                diagonalDownLeftWinChecker(connectFourGame, newPiece) ||
                diagonalUpLeftWinChecker(connectFourGame,newPiece)
        ){
            return true;
        }
        return false;
    }

    private boolean verticalWinChecker(Game connectFourGame, Piece newPiece){
        List<Piece> pieceList = connectFourGame.getGameBoard().getGamePieces();
        int counter = 1;
        for (int i = 1; i < 4 ; i++) {
            Piece comparePiece = new Piece();
            comparePiece.setPieceColor(newPiece.getPieceColor());
            comparePiece.setXAxisLocation(newPiece.getXAxisLocation());
            comparePiece.setYAxisLocation(newPiece.getYAxisLocation()-i);
            if (pieceList.contains(comparePiece)) {
                counter ++;
            }
        }
        if (counter ==4){
            return true;
        }
        return false;
    }



    private boolean horizontalLeftWinChecker(Game connectFourGame, Piece newPiece){
        List<Piece> pieceList = connectFourGame.getGameBoard().getGamePieces();
        int counter = 1;
        for (int i = 4; i > 1; i--) {
            Piece comparePiece = new Piece();
            comparePiece.setPieceColor(newPiece.getPieceColor());
            comparePiece.setYAxisLocation(newPiece.getYAxisLocation());
            comparePiece.setXAxisLocation(newPiece.getXAxisLocation() +i);
            if (pieceList.contains(comparePiece)) {
                counter ++;
            }
        }
        if (counter ==4){
            return true;
        }
        return false;
    }
    private boolean horizontalRightWinChecker(Game connectFourGame, Piece newPiece){
        List<Piece> pieceList = connectFourGame.getGameBoard().getGamePieces();
        int counter = 1;
        for (int i = 1; i < 4 ; i++) {
            Piece comparePiece = new Piece();
            comparePiece.setPieceColor(newPiece.getPieceColor());
            comparePiece.setYAxisLocation(newPiece.getYAxisLocation());
            comparePiece.setXAxisLocation(newPiece.getXAxisLocation() +i);
            if (pieceList.contains(comparePiece)) {
                counter ++;
            }
        }
        if (counter ==4){
            return true;
        }
        return false;
    }

    private boolean diagonalUpRightWinChecker(Game connectFourGame, Piece newPiece){
        List<Piece> pieceList = connectFourGame.getGameBoard().getGamePieces();
        int counter = 1;
        for (int i = 1; i < 4; i++) {
            Piece comparePiece = new Piece();
            comparePiece.setPieceColor(newPiece.getPieceColor());
            comparePiece.setYAxisLocation(newPiece.getYAxisLocation() +i);
            comparePiece.setXAxisLocation(newPiece.getXAxisLocation() +i);
            if (pieceList.contains(comparePiece)) {
                counter ++;
            }
        }
        if (counter ==4){
            return true;
        }
        return false;
    }

    private boolean diagonalDownLeftWinChecker(Game connectFourGame, Piece newPiece){
        List<Piece> pieceList = connectFourGame.getGameBoard().getGamePieces();
        int counter = 1;
        for (int i = 1; i < 4; i++) {
            Piece comparePiece = new Piece();
            comparePiece.setPieceColor(newPiece.getPieceColor());
            comparePiece.setYAxisLocation(newPiece.getYAxisLocation() -i);
            comparePiece.setXAxisLocation(newPiece.getXAxisLocation() -i);
            if (pieceList.contains(comparePiece)) {
                counter ++;
            }
        }
        if (counter ==4){
            return true;
        }
        return false;
    }

    private boolean diagonalDownRightWinChecker(Game connectFourGame, Piece newPiece){
        List<Piece> pieceList = connectFourGame.getGameBoard().getGamePieces();
        int counter = 1;
        for (int i = 1; i < 4; i++) {
            Piece comparePiece = new Piece();
            comparePiece.setPieceColor(newPiece.getPieceColor());
            comparePiece.setYAxisLocation(newPiece.getYAxisLocation() -i);
            comparePiece.setXAxisLocation(newPiece.getXAxisLocation() +i);
            if (pieceList.contains(comparePiece)) {
                counter ++;
            }
        }
        if (counter ==4){
            return true;
        }
        return false;
    }

    private boolean diagonalUpLeftWinChecker(Game connectFourGame, Piece newPiece){
        List<Piece> pieceList = connectFourGame.getGameBoard().getGamePieces();
        int counter = 1;
        for (int i = 1; i < 4; i++) {
            Piece comparePiece = new Piece();
            comparePiece.setPieceColor(newPiece.getPieceColor());
            comparePiece.setYAxisLocation(newPiece.getYAxisLocation() +i);
            comparePiece.setXAxisLocation(newPiece.getXAxisLocation() -i);
            if (pieceList.contains(comparePiece)) {
                counter ++;
            }
        }
        if (counter ==4){
            return true;
        }
        return false;
    }

    public Game turnService(Integer pieceXAxis, Long gameId){
        Game connectFourGame = gameRepository.getOne(gameId);
        List<Piece> pieceList = connectFourGame.getGameBoard().getGamePieces();
        int yAxisCounter = 1;
        for (int i = 0; i < pieceList.size(); i++) {
            if(pieceList.get(i).getXAxisLocation().equals(pieceXAxis)) {
                yAxisCounter++;
            }
        }
        if(yAxisCounter >6) {
            throw new RuntimeException("This Column is filled with peices! Please make a new selection");
        }
        Piece newPiece = new Piece();
        newPiece.setXAxisLocation(pieceXAxis);
        newPiece.setYAxisLocation(yAxisCounter);
        newPiece.setPieceId(connectFourGame.getGameBoard().getGameBoardId());

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
        boolean connectFourGameResult = gameWinChecker(connectFourGame, newPiece);
        if(connectFourGameResult){
            connectFourGame.setGameWon(true);
            connectFourGame = gameRepository.save(connectFourGame);
        }
        return connectFourGame;

    }
}
