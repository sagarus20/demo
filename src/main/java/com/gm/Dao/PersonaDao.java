package com.gm.Dao;

import org.springframework.data.repository.CrudRepository;

import com.gm.domain.Persona;

public interface PersonaDao extends CrudRepository<Persona, Long> {
}