package com.lucasladeira.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasladeira.entities.Fornecedor;
import com.lucasladeira.repositories.FornecedorRepository;

@Service
public class FornecedorService {

	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	
	public List<Fornecedor> getAll(){
		List<Fornecedor> list = fornecedorRepository.findAll();
		return list;
	}	
	
}
