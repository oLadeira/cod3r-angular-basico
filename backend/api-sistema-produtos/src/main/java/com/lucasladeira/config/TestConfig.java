package com.lucasladeira.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.lucasladeira.entities.Supplier;
import com.lucasladeira.entities.Product;
import com.lucasladeira.repositories.SupplierRepository;
import com.lucasladeira.repositories.ProductRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private ProductRepository produtoRepository;
	
	@Autowired
	private SupplierRepository fornecedorRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Supplier fornecedor1 = new Supplier(null, "Megaware", "338.480.800-28");
		Supplier fornecedor2 = new Supplier(null, "Samsung", "950.450.110-90");
		fornecedorRepository.saveAll(Arrays.asList(fornecedor1, fornecedor2));
		
		Product produto1 = new Product(null, "Computador", 1200.00, fornecedor1);
		Product produto2 = new Product(null, "Televisão Smart 50 polegadas", 3200.00, fornecedor2);
		produtoRepository.saveAll(Arrays.asList(produto1, produto2));
						
	}

}
