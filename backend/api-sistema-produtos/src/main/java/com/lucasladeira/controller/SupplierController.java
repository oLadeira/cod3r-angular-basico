package com.lucasladeira.controller;

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

import com.lucasladeira.entities.Supplier;
import com.lucasladeira.services.SupplierService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*") //politica CORS, estudar sobre
@RequestMapping("/fornecedores")
public class SupplierController {

	@Autowired
	private SupplierService supplierService;
	
	
	@GetMapping
	public ResponseEntity<List<Supplier>> getAll(){
		List<Supplier> list = supplierService.getAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Supplier> getById(@PathVariable Integer id){
		Supplier supplier = supplierService.getById(id);
		
		return ResponseEntity.ok().body(supplier);
	}
	
	@PostMapping
	public ResponseEntity<Void> save(@RequestBody Supplier supplier){
		supplierService.save(supplier);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody Supplier supplier){
		supplierService.update(id, supplier);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		supplierService.delete(id);
		return ResponseEntity.ok().build();
	}
	
}
