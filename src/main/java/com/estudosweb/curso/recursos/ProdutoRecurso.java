package com.estudosweb.curso.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudosweb.curso.entidades.Produto;
import com.estudosweb.curso.servicos.ProdutoServico;

/*CONTROLADORES REST*/

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoRecurso {
	
	@Autowired
	private ProdutoServico servico;
	
	@GetMapping
	public ResponseEntity<List<Produto>> retornaProdutos(){
		List<Produto> list = servico.retornaProdutos();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> retornaProdutoPorId(@PathVariable Long id){
		Produto produto = servico.retornaProdutoPorId(id);
		return ResponseEntity.ok().body(produto);
	}

}
