package com.exampleee.game_library.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.exampleee.game_library.model.Game;
import com.exampleee.game_library.service.GameService;

import org.springframework.ui.Model;

@Controller
public class GameViewController {

    @Autowired
    private GameService service;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("jogos", service.findAll());
        List<Game> lista = service.findAll();
        System.out.println("Quantidade de jogos encontrados: " + lista.size());
        model.addAttribute("jogos", lista);
        return "index"; // Faz com que ele busque o .html
    }
}
