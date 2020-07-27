package com.github.ede.ConnectFourGame.controllers;

import com.github.ede.ConnectFourGame.models.Board;
import com.github.ede.ConnectFourGame.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/board")
@CrossOrigin(origins = "http://localhost:3000")
public class BoardController {
    @Autowired
    BoardRepository boardRepository;

    @PostMapping
    public ResponseEntity<Board> addBoard (@Valid @RequestBody Board board){
        Board connectFourBoard = boardRepository.save(board);
        return ResponseEntity.ok(board);
    }

}
