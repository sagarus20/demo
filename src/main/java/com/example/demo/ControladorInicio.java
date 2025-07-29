package com.example.demo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.domain.Persona;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ControladorInicio {
    @Value("${index.saludo}")
    private String saludo;
    @GetMapping("/")
    public String inicio(Model model){
        var persona =new Persona();
        persona.setNombre("juan");
        persona.setApellido("cardenas");
        persona.setEmail("juancardenas@test.com");
        persona.setTelefono("7777344645");

        var personas= new ArrayList<>();
        personas.add(persona);
        var mensaje="hola mundo thymeleaf";
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("saludo", saludo);
        // model.addAttribute("persona", persona);
        model.addAttribute("personas", personas);

        log.info("ejecutando");
        log.debug("mas detalle");
        return "index";
    }
    
}
