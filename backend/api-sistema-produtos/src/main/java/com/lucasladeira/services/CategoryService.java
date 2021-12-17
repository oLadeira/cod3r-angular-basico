package com.lucasladeira.services;

import java.util.List;

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
	
}
