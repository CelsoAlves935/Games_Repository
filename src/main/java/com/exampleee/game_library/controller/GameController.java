package com.exampleee.game_library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exampleee.game_library.model.Game;
import com.exampleee.game_library.service.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameService jogos;


    @GetMapping("/Jogos")
    public List<Game> GameList () {
        return jogos.findAll();
    }

    @PostMapping("/Novo")
    public Game newGame (@RequestBody Game jogo) {
        return jogos.save(jogo);
    }
    
}
