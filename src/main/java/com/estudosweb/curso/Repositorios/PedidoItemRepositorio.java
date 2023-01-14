package com.estudosweb.curso.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudosweb.curso.entidades.PedidoItem;

public interface PedidoItemRepositorio extends JpaRepository<PedidoItem, Long>{

}
