package com.estudosweb.curso.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudosweb.curso.Repositorios.UsuarioRepositorio;
import com.estudosweb.curso.entidades.Usuario;
import com.estudosweb.curso.servicos.excecoes.RecursoNaoEncontradoExcecao;

@Service
public class UsuarioServico {

	@Autowired
	private UsuarioRepositorio repositorio;
	
	public List<Usuario> retornaUsuarios(){
		return repositorio.findAll();
	}
	
	public Usuario retornaUsuarioPorId(Long id) {
		Optional<Usuario> usuario = repositorio.findById(id);
		return usuario.orElseThrow(() -> new RecursoNaoEncontradoExcecao(id));
	}
	
	public Usuario inserir(Usuario usuario) {
		return repositorio.save(usuario);
	}
	
	public void excluir(Long id) {
		repositorio.deleteById(id);
	}
	
	public Usuario atualizar(Long id, Usuario usuarioNovo) {
		Usuario usuarioAtual = repositorio.getReferenceById(id);
		atualizarRegistro(usuarioAtual, usuarioNovo);
		return repositorio.save(usuarioAtual);
	}

	private void atualizarRegistro(Usuario usuarioAtual, Usuario usuarioNovo) {
		usuarioAtual.setNome(usuarioNovo.getNome());
		usuarioAtual.setEmail(usuarioNovo.getEmail());
		usuarioAtual.setTelefone(usuarioNovo.getTelefone());
	}
}
