package com.lucasladeira.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryNewDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotBlank(message = "Campo não informado")
	@Length(min = 4, max = 40, message = "O tamanho deve ser entre 5 e 40 caracteres!")
	private String name;
	
	
}
