package com.estudosweb.curso.recursos;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudosweb.curso.entidades.Usuario;

/*CONTROLADORES REST*/

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioRecurso {
	
	@GetMapping
	public ResponseEntity<Usuario> retornaUsuarios(){
		Usuario usuario = new Usuario(1L, "Wesley", "wesley_esc1987@hotmail.com", "11942466550", "123456");
		return ResponseEntity.ok().body(usuario);
	}

}
