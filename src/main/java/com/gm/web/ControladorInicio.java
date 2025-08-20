package com.gm.web;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gm.service.PersonaService;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class ControladorInicio {
    @Autowired
    private PersonaService personaService;


    @GetMapping("/")
    public String inicio(Model model){
        
        var personas = personaService.listaPersonas();
        log.info("Persona insertada desde inicio()");
        model.addAttribute("personas", personas);
        
        return "index";
    }
    @PostConstruct
    public void init() {

        log.info("Persona insertada desde init()");
    }
    
}
