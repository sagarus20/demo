package com.gm.web;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gm.domain.Persona;
import com.gm.service.PersonaService;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Slf4j
@Controller
public class ControladorInicio {
    @Autowired
    private PersonaService personaService;


    @GetMapping("/")
    public String inicio(Model model){
        
        var personas = personaService.listaPersonas();
        log.info("ejecutando lista de controlador spring MVC");
        model.addAttribute("personas", personas);
        
        return "index";
    }
    @GetMapping("/agregar")
    public String agregar(Persona persona){
        
        log.info("Persona insertada desde guardar()");

        
        return "modificar";
    }
    @GetMapping("/editar{id_persona}")
    public String editar(Persona persona,Model model){
       persona=personaService.encontrarPersona(persona);
       model.addAttribute("persona", persona);
        log.info("Persona insertada desde editar()");

        
        return "modificar";
    }
    @GetMapping("/eliminar")
    public String eliminar(Persona persona,Model model){
       personaService.eliminar(persona);     
        log.info("Persona eliminada desde editar()");

        
        return "redirect:/";
    }
    @PostMapping("/guardar")
    public String guardar(Persona persona) {
        personaService.guardar(persona);
        
        return "redirect:/";
    }
    
    @PostConstruct
    public void init() {

        log.info("Persona insertada desde init()");
    }
    
}
