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
import javax.validation.constraints.NotEmpty;
import java.awt.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Player {
    @Id
    @GeneratedValue
    private long playerId;

    @Column
    @NotEmpty(message = "Player Name cannot be blank, Please Enter a unique name consisting of Letters and Numbers. Ex: Player1")
    private String playerName;

    @Column
    @NotEmpty(message = "Passwords must have a min of 7 Characters and a max of 50 characters.")
    @Min(value = 7)
    @Max(value = 50)
    private String playerPassword;

    @Column
    private String playerEmail;
}
