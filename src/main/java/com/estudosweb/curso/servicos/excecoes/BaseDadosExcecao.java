package com.estudosweb.curso.servicos.excecoes;

public class BaseDadosExcecao extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public BaseDadosExcecao(String msg) {
		super(msg);
	}
}

