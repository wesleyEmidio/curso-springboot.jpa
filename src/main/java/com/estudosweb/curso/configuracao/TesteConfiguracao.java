package com.estudosweb.curso.configuracao;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.estudosweb.curso.Repositorios.UsuarioRepositorio;
import com.estudosweb.curso.entidades.Usuario;

@Configuration
@Profile("test")
public class TesteConfiguracao implements CommandLineRunner{
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;

	@Override
	public void run(String... args) throws Exception {
		
		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456"); 
		
		
		usuarioRepositorio.saveAll(Arrays.asList(u1, u2));
	}

}
