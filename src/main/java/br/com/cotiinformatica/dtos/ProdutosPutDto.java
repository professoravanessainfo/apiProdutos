package br.com.cotiinformatica.dtos;

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
public class ProdutosPutDto {

	private Integer ig;
	private String nome;
	private Double preco;
	private Integer quantidade;
	private Integer id_fornecedor;
	
}
