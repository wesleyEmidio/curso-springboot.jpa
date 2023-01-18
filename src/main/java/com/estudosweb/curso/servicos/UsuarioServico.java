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
	private UsuarioRepositorio repositorio;
	
	public List<Usuario> retornaUsuarios(){
		return repositorio.findAll();
	}
	
	public Usuario retornaUsuarioPorId(Long id) {
		Optional<Usuario> usuario = repositorio.findById(id);
		return usuario.get();
	}
	
	public Usuario inserir(Usuario usuario) {
		return repositorio.save(usuario);
	}
}
