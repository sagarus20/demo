package com.example.demo.Dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.domain.Persona;

public interface PersonaDao extends CrudRepository<Persona, Long> {
}