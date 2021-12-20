package com.lucasladeira.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductNewDTO implements Serializable{

	private static final long serialVersionUID = 1L;


	@NotBlank(message = "Campo não informado")
	@Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 120 caracteres!")
	private String name;
	
	@NotNull(message = "Campo não informado")
	private Double price;
	
	@NotNull(message = "Campo não informado")
	private Integer supplier;
		

}
