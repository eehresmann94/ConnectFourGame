package com.github.ede.ConnectFourGame.controllers;

import com.github.ede.ConnectFourGame.models.Piece;
import com.github.ede.ConnectFourGame.repository.PieceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/pieces")
@CrossOrigin(origins = "http://localhost:3000")
public class PieceController {

    @Autowired
    PieceRepository pieceRepository;

    @PostMapping
    public ResponseEntity<Piece> addPiece(@Valid @RequestBody Piece piece){
        Piece connectFourPiece = pieceRepository.save(piece);
        return ResponseEntity.ok(piece);
    }

}
