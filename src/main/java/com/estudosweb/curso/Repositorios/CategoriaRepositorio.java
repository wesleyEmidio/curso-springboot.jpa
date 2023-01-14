package com.estudosweb.curso.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudosweb.curso.entidades.Categoria;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Long>{

}
