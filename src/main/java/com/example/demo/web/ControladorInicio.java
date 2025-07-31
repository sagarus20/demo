package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.Dao.PersonaDao;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class ControladorInicio {
    @Autowired
    private PersonaDao personaDao;


    @GetMapping("/")
    public String inicio(Model model){
        System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>> MÉTODO INICIO()");
        var personas = personaDao.findAll();
        log.info("Persona insertada desde inicio()");
        model.addAttribute("personas", personas);
        
        return "index";
    }
    @PostConstruct
    public void init() {

        log.info("Persona insertada desde init()");
    }
    
}
