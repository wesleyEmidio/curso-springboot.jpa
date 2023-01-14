package com.estudosweb.curso.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudosweb.curso.Repositorios.ProdutoRepositorio;
import com.estudosweb.curso.entidades.Produto;

@Service
public class ProdutoServico {

	@Autowired
	private ProdutoRepositorio repositorio;
	
	public List<Produto> retornaProdutos(){
		return repositorio.findAll();
	}
	
	public Produto retornaProdutoPorId(Long id) {
		Optional<Produto> produto = repositorio.findById(id);
		return produto.get();
	}
}
