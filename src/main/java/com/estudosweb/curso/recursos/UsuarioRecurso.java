package com.estudosweb.curso.recursos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudosweb.curso.entidades.Usuario;
import com.estudosweb.curso.servicos.UsuarioServico;

/*CONTROLADORES REST*/

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioRecurso {
	
	@Autowired
	private UsuarioServico servico;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> retornaUsuarios(){
		List<Usuario> list = servico.retornaUsuarios();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> retornaUsuarioPorId(@PathVariable Long id){
		Usuario usuario = servico.retornaUsuarioPorId(id);
		return ResponseEntity.ok().body(usuario);
	}

}
