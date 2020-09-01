package com.github.ede.ConnectFourGame.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Objects;


@Entity
public class Piece {

    @Id
    @GeneratedValue
    private Long pieceId;

    //limits the value of the X axis to a value of 1-6 to emulate a real game board.
    @Column
    @Min(value = 1, message = "{\"err\": \"Your value is too low for this movement\"}")
    @Max(value = 6,message = "{\"err\": \"Your value is too high for this movement\"}")
    private Integer xAxisLocation;

    @Column
    private Integer yAxisLocation;

    @Column
    private String pieceColor;

    public Long getPieceId() {
        return pieceId;
    }

    public void setPieceId(Long pieceId) {
        this.pieceId = pieceId;
    }

    public Integer getXAxisLocation() {
        return xAxisLocation;
    }

    public void setXAxisLocation(Integer xAxisLocation) {
        this.xAxisLocation = xAxisLocation;
    }

    public Integer getYAxisLocation() {
        return yAxisLocation;
    }

    public void setYAxisLocation(Integer yAxisLocation) {
        this.yAxisLocation = yAxisLocation;
    }

    public String getPieceColor() {
        return pieceColor;
    }

    public void setPieceColor(String pieceColor) {
        this.pieceColor = pieceColor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return Objects.equals(xAxisLocation, piece.xAxisLocation) &&
                Objects.equals(yAxisLocation, piece.yAxisLocation) &&
                Objects.equals(pieceColor, piece.pieceColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(xAxisLocation, yAxisLocation, pieceColor);
    }
}
