package br.com.cotiinformatica.entities;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Produto {

	private UUID id;
	private String nome;
	private Double preco;
	private Integer quantidade;
	//atributo que vincula a um fornecedor
	private Fornecedor fornecedor;
	
	
	
	
	
}
