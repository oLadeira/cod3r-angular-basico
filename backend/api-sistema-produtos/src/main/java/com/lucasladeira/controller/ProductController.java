package com.lucasladeira.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucasladeira.dto.ProductNewDTO;
import com.lucasladeira.entities.Product;
import com.lucasladeira.services.ProductService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*") //politica CORS, estudar sobre
@RequestMapping("/produtos")
public class ProductController {

	@Autowired
	private ProductService produtoService;
	
	
	@GetMapping
	public ResponseEntity<List<Product>> getAll(){
		List<Product> list = produtoService.getAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getById(@PathVariable Integer id){
		Product produto = produtoService.getById(id);
		return ResponseEntity.ok().body(produto);
	}
	
	@PostMapping
	public ResponseEntity<Void> save (@RequestBody ProductNewDTO productNewDTO){
		produtoService.save(productNewDTO);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update (@PathVariable Integer id, @RequestBody Product produto){
		produtoService.update(id, produto);
		return ResponseEntity.ok().build();
	}
	
}
