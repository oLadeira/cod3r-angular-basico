package com.lucasladeira.crudspringangular.entities;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
public class Produto {
    private Integer id;
    private String nome;
    private Double preco;

    public Produto(){}

}
