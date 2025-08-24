package com.gm.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gm.domain.Usuario;

public interface UsuarioDao  extends JpaRepository<Usuario,Long>{
    Usuario findByUsername(String name);
}
