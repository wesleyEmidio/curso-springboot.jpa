package com.estudosweb.curso.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudosweb.curso.Repositorios.PedidoRepositorio;
import com.estudosweb.curso.entidades.Pedido;

@Service
public class PedidoServico {

	@Autowired
	private PedidoRepositorio repositorio;
	
	public List<Pedido> retornaPedidos(){
		return repositorio.findAll();
	}
	
	public Pedido retornaPedidoPorId(Long id) {
		Optional<Pedido> pedido = repositorio.findById(id);
		return pedido.get();
	}
}
