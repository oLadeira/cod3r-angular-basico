package com.lucasladeira.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.lucasladeira.dto.CategoryDTO;
import com.lucasladeira.dto.CategoryNewDTO;
import com.lucasladeira.entities.Category;
import com.lucasladeira.repositories.CategoryRepository;
import com.lucasladeira.services.exceptions.DataIntegrityException;
import com.lucasladeira.services.exceptions.EntityNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	//GET all
	public List<Category> getAll(){
		return categoryRepository.findAll();
	}
	
	//GET byId
	public Category getById(Integer id) {
		Optional<Category> opt = categoryRepository.findById(id);
		
		//tratar excecao
		
		return opt.get();
	}
	
	//POST
	public Category save(CategoryNewDTO categoryNewDTO) {
		Category category = fromDTO(categoryNewDTO);
		
		return categoryRepository.save(category);
	}
	
	//PUT
	public Category update(Integer id, CategoryDTO categoryDTO) {
		Category category = fromDTO(categoryDTO);
		
		Optional<Category> opt = categoryRepository.findById(id);
		
		opt.orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada! ID:" + id));
		
		category.setId(id);
		return categoryRepository.save(category);		
	}
	
	//DELETE
	public void delete(Integer id) {
		Optional<Category> opt = categoryRepository.findById(id);
		
		opt.orElseThrow(() -> new EntityNotFoundException("Categoria não encontrada! ID:" + id));
		
		try {
			categoryRepository.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível deletar o Fornecedor, há produtos relacionados a ele");
		}
		
	}
	
	
	//utilitarios
	public Category fromDTO(CategoryNewDTO categoryNewDTO) {
		Category category = new Category();
		category.setId(null);
		category.setName(categoryNewDTO.getName());
		return category;
	}
	
	public Category fromDTO(CategoryDTO categoryDTO) {
		Category category = new Category();
		category.setName(categoryDTO.getName());
		return category;
	}
}
