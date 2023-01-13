package com.estudosweb.curso.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudosweb.curso.Repositorios.UsuarioRepositorio;
import com.estudosweb.curso.entidades.Usuario;

@Service
public class UsuarioServico {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	public List<Usuario> retornaUsuarios(){
		return usuarioRepositorio.findAll();
	}
	
	public Usuario retornaUsuarioPorId(Long id) {
		Optional<Usuario> usuario = usuarioRepositorio.findById(id);
		return usuario.get();
	}
}
