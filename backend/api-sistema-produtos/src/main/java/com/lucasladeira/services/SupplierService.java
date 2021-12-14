package com.lucasladeira.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasladeira.entities.Supplier;
import com.lucasladeira.repositories.SupplierRepository;

@Service
public class SupplierService {

	@Autowired
	private SupplierRepository fornecedorRepository;
	
	//GET all
	public List<Supplier> getAll(){
		List<Supplier> list = fornecedorRepository.findAll();
		return list;
	}	
	
}
