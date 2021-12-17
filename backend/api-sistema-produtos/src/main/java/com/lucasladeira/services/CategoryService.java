package com.lucasladeira.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasladeira.entities.Category;
import com.lucasladeira.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	
	public List<Category> getAll(){
		return categoryRepository.findAll();
	}
	
	public Category getById(Integer id) {
		Optional<Category> opt = categoryRepository.findById(id);
		
		//tratar excecao
		
		return opt.get();
	}
	
}
