package com.lucasladeira.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucasladeira.entities.Fornecedor;
import com.lucasladeira.services.FornecedorService;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

	@Autowired
	private FornecedorService fornecedorService;
	
	
	@GetMapping
	public ResponseEntity<List<Fornecedor>> getAll(){
		List<Fornecedor> list = fornecedorService.getAll();
		return ResponseEntity.ok().body(list);
	}
	
}
