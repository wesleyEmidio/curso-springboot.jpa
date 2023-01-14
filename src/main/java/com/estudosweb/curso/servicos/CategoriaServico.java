package com.estudosweb.curso.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudosweb.curso.Repositorios.CategoriaRepositorio;
import com.estudosweb.curso.entidades.Categoria;

@Service
public class CategoriaServico {

	@Autowired
	private CategoriaRepositorio repositorio;
	
	public List<Categoria> retornaCategorias(){
		return repositorio.findAll();
	}
	
	public Categoria retornaCategoriaPorId(Long id) {
		Optional<Categoria> categoria = repositorio.findById(id);
		return categoria.get();
	}
}
