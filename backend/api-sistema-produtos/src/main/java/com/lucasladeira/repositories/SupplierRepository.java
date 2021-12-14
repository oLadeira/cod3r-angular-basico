package com.lucasladeira.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucasladeira.entities.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Integer>{

}
