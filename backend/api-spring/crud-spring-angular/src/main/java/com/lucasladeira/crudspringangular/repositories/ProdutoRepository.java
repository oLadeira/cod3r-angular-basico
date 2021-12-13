package com.lucasladeira.crudspringangular.repositories;

import com.lucasladeira.crudspringangular.entities.Produto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
    
}
