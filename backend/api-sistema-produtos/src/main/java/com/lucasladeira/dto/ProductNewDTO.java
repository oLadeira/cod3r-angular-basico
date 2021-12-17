package com.lucasladeira.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductNewDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	@NotBlank(message = "Campo não informado")
	private String name;
	
	
	private Double price;
	
	private Integer supplier;
	
}
