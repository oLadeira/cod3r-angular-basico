package com.lucasladeira.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasladeira.entities.Produto;
import com.lucasladeira.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	//GET
	public List<Produto> getAll(){
		List<Produto> list = produtoRepository.findAll();
		return list;
	}
	
	//GET
	public Produto getById(Integer id) {
		Optional<Produto> opt = produtoRepository.findById(id);
		
		if (opt.isEmpty()) {
			//tratar erro
		}
		
		return opt.get();
	}
	
	//POST
	public Produto save (Produto produto) {
		produto.setId(null);
		produto = produtoRepository.save(produto);
		return produto;
	}
	
	//PUT
	public void update (Integer id, Produto produto) {
		Optional<Produto> opt = produtoRepository.findById(id);
		
		if (opt.isEmpty()) {
			//tratar erro
		}
		produto.setId(id);
		produtoRepository.save(produto);
	}
	
}
