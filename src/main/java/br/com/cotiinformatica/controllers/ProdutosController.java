package br.com.cotiinformatica.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.dtos.ProdutosPostDto;
import br.com.cotiinformatica.dtos.ProdutosPutDto;
import br.com.cotiinformatica.entities.Fornecedor;
import br.com.cotiinformatica.entities.Produto;
import br.com.cotiinformatica.repositories.FornecedorRepository;
import br.com.cotiinformatica.repositories.ProdutoRepository;

@RestController
@RequestMapping("/api/produtos")
public class ProdutosController {
	
	@Autowired //o spring boot inicializa o repositorio
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	@PostMapping
	public ResponseEntity<String> post(@RequestBody ProdutosPostDto dto) {
		try {
			//capturar dados do produto
			Produto produto = new Produto();
			
			produto.setNome(dto.getNome());
			produto.setPreco(dto.getPreco());
			produto.setQuantidade(dto.getQuantidade());
			
			//consultar o fornecedor no bd pelo id
			Fornecedor fornecedor = fornecedorRepository.findById(dto.getId_Fornecedor()).get();
			
			produto.setFornecedor(fornecedor);
			
			//salvar o produto no bd
			produtoRepository.save(produto);
			
			return ResponseEntity.status(201).body("Produto cadastrado com sucesso!");
		}
		catch(Exception e){
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}
	
	@PutMapping
	public ResponseEntity<String> put(@RequestBody ProdutosPutDto dto) {
		
		try {
			
			Produto produto = produtoRepository.findById(dto.getIg()).get();
			
			produto.setNome(dto.getNome());
			produto.setPreco(dto.getPreco());
			produto.setQuantidade(dto.getQuantidade());
			
			Fornecedor fornecedor = fornecedorRepository.findById(dto.getId_fornecedor()).get();
			produto.setFornecedor(fornecedor);
			
			produtoRepository.save(produto);
			
			return ResponseEntity.status(201).body("Produto atualizado com sucesso!");
			
		}catch(Exception e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
		
		
	}

	@GetMapping
	public List<Produto> get() {
		return produtoRepository.findAll();
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
		try {
			
			//pesquisar o produto no banco de dados através do id
			Produto produto = produtoRepository.findById(id).get();
			
			//excluir o produto
			produtoRepository.delete(produto);
			
			//HTTP 200 (OK)
			return ResponseEntity.status(200).body("Produto excluído com sucesso.");
		}
		catch(Exception e) {
			//HTTP 500 (INTERNAL SERVER ERROR)
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}

}
