package com.lucasladeira.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucasladeira.entities.Supplier;
import com.lucasladeira.services.SupplierService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*") //politica CORS, estudar sobre
@RequestMapping("/fornecedores")
public class SupplierController {

	@Autowired
	private SupplierService fornecedorService;
	
	
	@GetMapping
	public ResponseEntity<List<Supplier>> getAll(){
		List<Supplier> list = fornecedorService.getAll();
		return ResponseEntity.ok().body(list);
	}
	
}
