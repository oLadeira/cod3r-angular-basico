package com.lucasladeira.services;

import java.util.List;
import java.util.Optional;

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
		supplier.setId(null);
		supplierRepository.save(supplier);
		return supplier;
	}
	
	//PUT
	public Supplier update(Integer id, Supplier supplier) {
		Optional<Supplier> opt = supplierRepository.findById(id);
		
		if (opt.isEmpty()) {
			//tratar erro
		}
		supplier.setId(id);
		supplierRepository.save(supplier);
		return supplier;
	}
	
}
