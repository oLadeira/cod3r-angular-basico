package com.lucasladeira.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucasladeira.entities.Category;
import com.lucasladeira.services.CategoryService;

@RestController
@RequestMapping("/categorias")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	
	@GetMapping
	public ResponseEntity<List<Category>> getAll(){
		List<Category> list = categoryService.getAll();
		return ResponseEntity.ok().body(list);
	}
	
}