package br.com.cotiinformatica.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//mapeamento para a classe assumir que tem Get e Set, construtor vazio e com argumentos, toString
//Isso devido o uso do Lombok
//se necessitar fazer validação em algum método, pode escrever o método pois este que vai valer
@Entity
@Table(name = "fornecedor")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Fornecedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "razaosocial", length = 100, nullable = false)
	private String razaoSocial;
	@Column(name = "cnpj", length = 20, nullable = false)
	private String cnpj;
	//atributo para representar muitos objetos
	@JsonIgnore //para nao mostrar este campo na consulta da API
	@OneToMany(mappedBy = "fornecedor")
	private List<Produto> produtos;
	
	
	
}
