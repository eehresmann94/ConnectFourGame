package com.github.ede.ConnectFourGame.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Piece {
    @Id
    @GeneratedValue
    private Long gameBoardId;
    @Column
    private Integer xAxisLocation;
    @Column
    private Integer yAxisLocation;
    @Column
    private String pieceColor;
}
