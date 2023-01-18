package com.estudosweb.curso.recursos.excecoes;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.estudosweb.curso.servicos.excecoes.BaseDadosExcecao;
import com.estudosweb.curso.servicos.excecoes.RecursoNaoEncontradoExcecao;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class TratamentoRecursoExcesao {
	
	@ExceptionHandler(RecursoNaoEncontradoExcecao.class)
	public ResponseEntity<ErroPadrao> recursoNaoEncontrado(RecursoNaoEncontradoExcecao e, HttpServletRequest request) {
		String erro = "Recurso não encontrado.";
		HttpStatus status = HttpStatus.NOT_FOUND; /*404*/
		ErroPadrao erroPadrao = new ErroPadrao(Instant.now(), status.value(), erro, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(erroPadrao);
	}

	@ExceptionHandler(BaseDadosExcecao.class)
	public ResponseEntity<ErroPadrao> baseDados(BaseDadosExcecao e, HttpServletRequest request) {
		String erro = "Existe registros associados ao ID.";
		HttpStatus status = HttpStatus.BAD_REQUEST; /*400*/
		ErroPadrao erroPadrao = new ErroPadrao(Instant.now(), status.value(), erro, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(erroPadrao);
	}

}
