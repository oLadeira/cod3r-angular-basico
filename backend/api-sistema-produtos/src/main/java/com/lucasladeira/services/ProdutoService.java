package com.lucasladeira.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasladeira.entities.Produto;
import com.lucasladeira.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	
	public List<Produto> getAll(){
		List<Produto> list = produtoRepository.findAll();
		return list;
	}
	
}
