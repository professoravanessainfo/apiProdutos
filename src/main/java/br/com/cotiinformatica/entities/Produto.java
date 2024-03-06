package br.com.cotiinformatica.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "produto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Produto {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id")
	private Integer id;
	@Column(name = "nome", length = 100, nullable = false )
	private String nome;
	@Column(name = "preco", nullable = false )
	private Double preco;
	@Column(name = "quantidade", nullable = false )
	private Integer quantidade;
	//atributo que vincula a um fornecedor
	//mapear relacionamento entre produto e fornecedor
	
	@ManyToOne //são muitos produtos para um fornecedor
	@JoinColumn(name = "id_fornecedor") //mapear chave estrangeira e acompanhar a annotation acima(manytoone)
	private Fornecedor fornecedor;
	
	
	
	
	
}
