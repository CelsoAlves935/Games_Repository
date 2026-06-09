package com.exampleee.game_library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.exampleee.game_library.model.Game;
import com.exampleee.game_library.service.GameService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/games")
public class GameController {

    @Autowired
    private GameService jogos;

    @GetMapping
    public List<Game> findAll() {
        return jogos.findAll();
    }

    @GetMapping("/filtrar")
    public List<Game> findZerados(@RequestParam boolean zerado) {
        return jogos.findZerado(zerado);
    }

    @PostMapping
    public Game create(@RequestBody Game jogo) {
        return jogos.save(jogo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        jogos.deleteById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Game jogo) {
        jogo.setId(id); // Garante que o ID da URL seja aplicado ao objeto
        jogos.update(jogo);
    }

}
