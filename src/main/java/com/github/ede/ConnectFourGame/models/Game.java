package com.github.ede.ConnectFourGame.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Game {
    @Id
    @GeneratedValue
    private Long gameId;

    @OneToOne
    private Player Player1;
    @OneToOne
    private Player Player2;
    @Column
    private boolean gameWon;
    @Column
    private Boolean playerTurnName;

    @OneToOne
    private Board gameBoard;


}
