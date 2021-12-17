package com.lucasladeira.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasladeira.dto.CategoryNewDTO;
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
	
	public Category save(CategoryNewDTO categoryNewDTO) {
		Category category = fromDTO(categoryNewDTO);
		
		return categoryRepository.save(category);
	}
	
	
	//utilitarios
	public Category fromDTO(CategoryNewDTO categoryNewDTO) {
		Category category = new Category();
		category.setId(null);
		category.setName(categoryNewDTO.getName());
		return category;
	}
}
