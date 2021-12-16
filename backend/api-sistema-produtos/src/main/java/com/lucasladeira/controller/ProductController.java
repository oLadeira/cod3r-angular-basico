package com.lucasladeira.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lucasladeira.dto.ProductNewDTO;
import com.lucasladeira.entities.Product;
import com.lucasladeira.services.ProductService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*") //politica CORS, estudar sobre
@RequestMapping("/produtos")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	
	@GetMapping
	public ResponseEntity<List<Product>> getAll(){
		List<Product> list = productService.getAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getById(@PathVariable Integer id){
		Product produto = productService.getById(id);
		return ResponseEntity.ok().body(produto);
	}
	
	@PostMapping
	public ResponseEntity<Void> save (@RequestBody ProductNewDTO productNewDTO){
		Product product = productService.save(productNewDTO);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(product.getId()).toUri(); 
		
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update (@PathVariable Integer id, @RequestBody Product produto){
		productService.update(id, produto);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		productService.delete(id);
		return ResponseEntity.ok().build();
	}
	
}
