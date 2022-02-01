package com.vinicius.store.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@AllArgsConstructor // responsável por gerar um construtor com 1 parametro
@NoArgsConstructor // responsavel por gerar um construtor sem parametros
@Builder // produz automaticamente o código para que sua classe seja instanciada
@Data // responsavel por criar o getter de cada campo ou de todos os atributos e a colocamos no nivel da classe
@Document  //  Identifica um objeto de domínio a ser persistido(fazer um mapeamento) no MongoDB.
public class Sunset {
    @Id
    private String id;
    @NotEmpty   // OLHAR validar tamanho minimo de string....
    private String name;
    @NotEmpty
    private String brand;
    private Double price;
}
