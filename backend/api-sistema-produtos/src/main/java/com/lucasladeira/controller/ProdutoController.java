package com.lucasladeira.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucasladeira.entities.Produto;
import com.lucasladeira.services.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	
	@GetMapping
	public ResponseEntity<List<Produto>> getAll(){
		List<Produto> list = produtoService.getAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> getById(@PathVariable Integer id){
		Produto produto = produtoService.getById(id);
		return ResponseEntity.ok().body(produto);
	}
	
}
