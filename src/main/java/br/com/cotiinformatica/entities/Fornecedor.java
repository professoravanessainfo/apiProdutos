package br.com.cotiinformatica.entities;

import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//mapeamento para a classe assumir que tem Get e Set, construtor vazio e com argumentos, toString
//Isso devido o uso do Lombok
//se necessitar fazer validação em algum métido, pode escrever o método pois será que vai valer
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Fornecedor {

	private UUID id;
	private String razaoSocial;
	private String cnpj;
	//atributo para representar muitos objetos
	private List<Produto> produtos;
	
	
	
}
