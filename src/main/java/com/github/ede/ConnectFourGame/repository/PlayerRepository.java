package com.github.ede.ConnectFourGame.repository;


import com.github.ede.ConnectFourGame.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Long> {

}
