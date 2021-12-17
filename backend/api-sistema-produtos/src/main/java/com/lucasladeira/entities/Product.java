package com.lucasladeira.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NonNull
	private Integer id;
	
	@NonNull
	private String name;
	
	@NonNull
	private Double price;
	
	@ManyToOne
	@JoinColumn(name = "supplier")
	@NonNull
	private Supplier supplier;
	
	@ManyToMany
	@JoinTable(name="PRODUCT_CATEGORY",
	joinColumns = @JoinColumn(name = "product"),
	inverseJoinColumns = @JoinColumn(name = "category"))
	private List<Category> categories = new ArrayList<>();

	public Product(Integer id, String name, Double price, Supplier supplier) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.supplier = supplier;
	}
	
	
	
}
