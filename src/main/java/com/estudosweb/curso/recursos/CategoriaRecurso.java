package com.estudosweb.curso.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudosweb.curso.entidades.Categoria;
import com.estudosweb.curso.servicos.CategoriaServico;

/*CONTROLADORES REST*/

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaRecurso {
	
	@Autowired
	private CategoriaServico servico;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> retornaCategorias(){
		List<Categoria> list = servico.retornaCategorias();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> retornaCategoriaPorId(@PathVariable Long id){
		Categoria categoria = servico.retornaCategoriaPorId(id);
		return ResponseEntity.ok().body(categoria);
	}

}
