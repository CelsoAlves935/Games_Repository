package com.exampleee.game_library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exampleee.game_library.model.Game;

public interface GameRepository extends JpaRepository<Game, Long> {
    
    public List<Game> findByZerado (boolean zerado) ;
}
