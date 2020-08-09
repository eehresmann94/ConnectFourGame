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

    //limits the value of the X axis to a value of 1-6 to emulate a real game board.
    @Column
    @Min(value = 1, message = "Your value is too low for this movement")
    @Max(value = 6,message = "Your Value is too high for this movement")
    private Integer xAxisLocation;

    @Column
    private Integer yAxisLocation;

    @Column
    private String pieceColor;

}
