package com.lucasladeira.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.lucasladeira.entities.Supplier;
import com.lucasladeira.repositories.SupplierRepository;
import com.lucasladeira.services.exceptions.DataIntegrityException;
import com.lucasladeira.services.exceptions.EntityNotFoundException;

@Service
public class SupplierService {

	@Autowired
	private SupplierRepository supplierRepository;
	
	//GET all
	public List<Supplier> getAll(){
		List<Supplier> list = supplierRepository.findAll();
		return list;
	}
	
	//GET by id
	public Supplier getById(Integer id) {
		Optional<Supplier> opt = supplierRepository.findById(id);
		
		opt.orElseThrow(() -> new EntityNotFoundException("Fornecedor não encontrado!, ID: " + id));
		
		return opt.get();		
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
		
		opt.orElseThrow(() -> new EntityNotFoundException("Fornecedor não encontrado!, ID: " + id));		
		
		supplier.setId(id);
		supplierRepository.save(supplier);
		return supplier;
	}
	
	//DELETE
	public void delete(Integer id) {
		Optional<Supplier> opt = supplierRepository.findById(id);
		
		opt.orElseThrow(() -> new EntityNotFoundException("Fornecedor não encontrado!, ID: " + id));
		
		try {
			supplierRepository.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível deletar o Fornecedor, há produtos relacionados a ele");
		}		
	}
	
	
}
