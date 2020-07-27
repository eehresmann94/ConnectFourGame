package com.github.ede.ConnectFourGame.repository;

import com.github.ede.ConnectFourGame.models.Piece;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PieceRepository extends JpaRepository<Piece, Long> {

}
