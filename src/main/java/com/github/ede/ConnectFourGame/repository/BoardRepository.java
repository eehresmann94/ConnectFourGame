package com.github.ede.ConnectFourGame.repository;

import com.github.ede.ConnectFourGame.models.Board;
import com.github.ede.ConnectFourGame.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

}
