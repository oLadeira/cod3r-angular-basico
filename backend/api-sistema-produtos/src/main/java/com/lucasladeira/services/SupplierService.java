package com.lucasladeira.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasladeira.entities.Supplier;
import com.lucasladeira.repositories.SupplierRepository;

@Service
public class SupplierService {

	@Autowired
	private SupplierRepository supplierRepository;
	
	//GET all
	public List<Supplier> getAll(){
		List<Supplier> list = supplierRepository.findAll();
		return list;
	}	
	
	//POST
	public Supplier save(Supplier supplier) {
		supplierRepository.save(supplier);
		return supplier;
	}
	
	
}
