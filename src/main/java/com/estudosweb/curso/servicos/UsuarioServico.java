package com.estudosweb.curso.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.estudosweb.curso.Repositorios.UsuarioRepositorio;
import com.estudosweb.curso.entidades.Usuario;
import com.estudosweb.curso.servicos.excecoes.BaseDadosExcecao;
import com.estudosweb.curso.servicos.excecoes.RecursoNaoEncontradoExcecao;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UsuarioServico {

	@Autowired
	private UsuarioRepositorio repositorio;

	public List<Usuario> retornaUsuarios() {
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
		try {
			repositorio.deleteById(id);

		} catch (EmptyResultDataAccessException e) {
			throw new RecursoNaoEncontradoExcecao(id);

		} catch (DataIntegrityViolationException e) {
			throw new BaseDadosExcecao(e.getMessage());
		}
	}

	public Usuario atualizar(Long id, Usuario usuarioNovo) {
		try {
			Usuario usuarioAtual = repositorio.getReferenceById(id);
			atualizarRegistro(usuarioAtual, usuarioNovo);
			return repositorio.save(usuarioAtual);
			
		} catch (EntityNotFoundException e) {
			throw new RecursoNaoEncontradoExcecao(id);
		}
	}

	private void atualizarRegistro(Usuario usuarioAtual, Usuario usuarioNovo) {
		usuarioAtual.setNome(usuarioNovo.getNome());
		usuarioAtual.setEmail(usuarioNovo.getEmail());
		usuarioAtual.setTelefone(usuarioNovo.getTelefone());
	}
}
