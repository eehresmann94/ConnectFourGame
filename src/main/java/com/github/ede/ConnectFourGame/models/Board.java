package com.github.ede.ConnectFourGame.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Board {
    @Id
    @GeneratedValue
    private long gameBoardId;
    @OneToMany
    private List<Piece> gamePieces;

    public void appendPiece(Piece piece){
        gamePieces.add(piece);
    }
}
