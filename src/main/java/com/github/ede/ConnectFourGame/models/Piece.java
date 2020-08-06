package com.github.ede.ConnectFourGame.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Piece {

    @Id
    @GeneratedValue
    private Long gameBoardId;
    @Column

    //limits the value of the X axis to a value of 1-6 to emulate a real game board.
    @Min(1)
    @Max(6)
    private Integer xAxisLocation;
    @Column

    private Integer yAxisLocation;
    @Column
    private String pieceColor;
}
