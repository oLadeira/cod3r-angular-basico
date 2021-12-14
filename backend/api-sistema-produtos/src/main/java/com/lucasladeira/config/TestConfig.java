package com.lucasladeira.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.lucasladeira.entities.Fornecedor;
import com.lucasladeira.entities.Produto;
import com.lucasladeira.repositories.FornecedorRepository;
import com.lucasladeira.repositories.ProdutoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Fornecedor fornecedor1 = new Fornecedor(null, "Megaware", "338.480.800-28");
		Fornecedor fornecedor2 = new Fornecedor(null, "Samsung", "950.450.110-90");
		fornecedorRepository.saveAll(Arrays.asList(fornecedor1, fornecedor2));
		
		Produto produto1 = new Produto(null, "Computador", 1200.00, fornecedor1);
		Produto produto2 = new Produto(null, "Televisão Smart 50 polegadas", 3200.00, fornecedor2);
		produtoRepository.saveAll(Arrays.asList(produto1, produto2));
						
	}

}
