package com.lucasladeira.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Produto implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	private String nome;
	private Double preco;
	
	public Produto() {}
	
}
