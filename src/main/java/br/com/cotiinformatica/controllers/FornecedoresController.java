package br.com.cotiinformatica.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cotiinformatica.entities.Fornecedor;
import br.com.cotiinformatica.repositories.FornecedorRepository;


//mapear classe para ser interpreatada como controladora de API REST
@RestController

//mapear o endpoint desse controlador na API
@RequestMapping("/api/fornecedores")
public class FornecedoresController {

	//inicializar a interface em tempo de exceução
	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	//cria um endpoint neste endereço de fornecedores
	@GetMapping
	public List<Fornecedor> get(){
		return fornecedorRepository.findAll();
	}
	
}
