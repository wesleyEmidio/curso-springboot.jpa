package com.estudosweb.curso.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudosweb.curso.entidades.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{

}
