package com.lucasladeira.dto;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProductNewDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	@Min(3)
	@Max(70)
	@NotBlank(message = "Campo não informado")
	private String name;
	
	@NotBlank(message = "Campo não informado")
	private Double price;
	
	@NotBlank(message = "Campo não informado")
	private Integer supplier;
		

}
