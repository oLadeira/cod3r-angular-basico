package com.lucasladeira.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucasladeira.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
