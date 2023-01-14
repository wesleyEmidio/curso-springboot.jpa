package com.estudosweb.curso.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudosweb.curso.entidades.Pedido;
import com.estudosweb.curso.servicos.PedidoServico;

/*CONTROLADORES REST*/

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoRecurso {
	
	@Autowired
	private PedidoServico servico;
	
	@GetMapping
	public ResponseEntity<List<Pedido>> retornaPedidos(){
		List<Pedido> list = servico.retornaPedidos();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Pedido> retornaPedidoPorId(@PathVariable Long id){
		Pedido pedido = servico.retornaPedidoPorId(id);
		return ResponseEntity.ok().body(pedido);
	}

}
