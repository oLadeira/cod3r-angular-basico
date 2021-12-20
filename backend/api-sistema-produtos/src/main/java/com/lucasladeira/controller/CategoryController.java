package com.lucasladeira.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucasladeira.dto.CategoryDTO;
import com.lucasladeira.dto.CategoryNewDTO;
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
	
	@GetMapping("/{id}")
	public ResponseEntity<Category> getById(@PathVariable Integer id){
		Category category = categoryService.getById(id);
		return ResponseEntity.ok().body(category);
	}
	
	@PostMapping
	public ResponseEntity<Void> save(@RequestBody @Valid CategoryNewDTO categoryNewDTO){
		categoryService.save(categoryNewDTO);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody CategoryDTO categoryDTO){
		categoryService.update(id, categoryDTO);
		return ResponseEntity.ok().build();
	}
}
