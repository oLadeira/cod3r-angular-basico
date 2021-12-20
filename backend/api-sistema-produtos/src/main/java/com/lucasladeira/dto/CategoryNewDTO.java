package com.lucasladeira.dto;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryNewDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@Max(20)
	@NotBlank(message = "Campo não informado")
	private String name;
	
	
}
