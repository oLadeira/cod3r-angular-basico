package com.lucasladeira.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucasladeira.entities.Produto;
import com.lucasladeira.services.ProdutoService;

@RestController
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	
	@GetMapping
	public ResponseEntity<List<Produto>> getAll(){
		List<Produto> list = produtoService.getAll();
		return ResponseEntity.ok().body(list);
	}
	
}
