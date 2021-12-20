package com.lucasladeira.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasladeira.dto.ProductDTO;
import com.lucasladeira.dto.ProductNewDTO;
import com.lucasladeira.entities.Product;
import com.lucasladeira.entities.Supplier;
import com.lucasladeira.repositories.ProductRepository;
import com.lucasladeira.services.exceptions.EntityNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	//GET
	public List<Product> getAll(){
		List<Product> list = productRepository.findAll();
		return list;
	}
	
	//GET by id
	public Product getById(Integer id) {
		Optional<Product> opt = productRepository.findById(id);
		
		opt.orElseThrow(() -> new EntityNotFoundException("Produto não encontrado!, ID: " + id)); //tratando produto não encontrado
		
		return opt.get();
	}
	
	//POST
	public Product save (ProductNewDTO productNewDTO) {
		Product product = fromDTO(productNewDTO);
		productRepository.save(product);
		return product;
	}
	
	//PUT
	public void update (Integer id, Product produto) {
		Optional<Product> opt = productRepository.findById(id);
		
		opt.orElseThrow(() -> new EntityNotFoundException("Produto não encontrado!, ID: " + id));
		
		produto.setId(id);
		productRepository.save(produto);
	}
	
	//DELETE
	public void delete(Integer id) {
		Optional<Product> opt = productRepository.findById(id);
		
		opt.orElseThrow(() -> new EntityNotFoundException("Produto não encontrado!, ID: " + id));
		
		productRepository.deleteById(id);
	}
	
	//utilitarios
	
	public Product fromDTO(ProductNewDTO productNewDTO) {
		Supplier supplier = new Supplier(productNewDTO.getSupplier(), null, null);
		Product product = new Product(null, productNewDTO.getName(), productNewDTO.getPrice(), supplier);
		
		return product;
	}
	
	public Product fromDTO(ProductDTO productDTO) {
		Supplier supplier = new Supplier(productDTO.getSupplier(), null, null);
		Product product = new Product(null, productDTO.getName(), productDTO.getPrice(), supplier);
		return product;
	}
	
//	private Product updateData(Integer id,Product product) {
//		Optional<Product> opt = productRepository.findById(id);
//		
//		Product attProduct = new Product();
//		attProduct.setId(opt.get().getId());
//		attProduct.setName(null);
//	}
	
}
