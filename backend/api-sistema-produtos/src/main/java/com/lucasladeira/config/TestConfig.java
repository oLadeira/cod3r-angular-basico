package com.lucasladeira.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.lucasladeira.entities.Produto;
import com.lucasladeira.repositories.ProdutoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Produto produto1 = new Produto(null, "Computador", 1200.00);
		
		produtoRepository.saveAll(Arrays.asList(produto1));
		
	}

}
