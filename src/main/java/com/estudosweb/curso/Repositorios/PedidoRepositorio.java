package com.estudosweb.curso.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudosweb.curso.entidades.Pedido;

public interface PedidoRepositorio extends JpaRepository<Pedido, Long>{

}
