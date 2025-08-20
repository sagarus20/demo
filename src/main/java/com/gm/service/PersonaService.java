package com.gm.service;

import java.util.List;

import com.gm.domain.Persona;

public interface PersonaService {
    public List<Persona>listaPersonas();
    public void guardar(Persona persona);
    public void eliminar(Persona persona);
    public Persona encontrarPersona(Persona persona);
}
