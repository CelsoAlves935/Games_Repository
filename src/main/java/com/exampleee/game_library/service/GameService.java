package com.exampleee.game_library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exampleee.game_library.model.Game;
import com.exampleee.game_library.repository.GameRepository;

@Service
public class GameService {

    @Autowired
    private GameRepository repository;


    public Game save (Game jogo) {
        return repository.save(jogo);
    }

    public List<Game> findAll() {
        return repository.findAll();
    }

   public List<Game> findZerado(boolean zerado) {
    return repository.findByZerado(zerado);
   }



    
    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            System.out.println("Este jogo não está registrado!");
        }
    }

    public void update (Game jogo) {
        repository.save(jogo);
    }

}
