package com.estudosweb.curso.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudosweb.curso.entidades.Produto;

public interface ProdutoRepositorio extends JpaRepository<Produto, Long>{

}
