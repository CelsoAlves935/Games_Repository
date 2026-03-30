package com.exampleee.game_library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exampleee.game_library.model.Game;

public interface GameRepository extends JpaRepository<Game, Long> {
    
}
