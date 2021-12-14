package com.lucasladeira.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasladeira.dto.ProductNewDTO;
import com.lucasladeira.entities.Product;
import com.lucasladeira.entities.Supplier;
import com.lucasladeira.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	//GET
	public List<Product> getAll(){
		List<Product> list = productRepository.findAll();
		return list;
	}
	
	//GET
	public Product getById(Integer id) {
		Optional<Product> opt = productRepository.findById(id);
		
		if (opt.isEmpty()) {
			//tratar erro
		}
		
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
		
		if (opt.isEmpty()) {
			//tratar erro
		}
		produto.setId(id);
		productRepository.save(produto);
	}
	
	//utilitarios
	
	public Product fromDTO(ProductNewDTO productNewDTO) {
		Supplier supplier = new Supplier(productNewDTO.getSupplier(), null, null);
		Product product = new Product(null, productNewDTO.getName(), productNewDTO.getPrice(), supplier);
		
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
