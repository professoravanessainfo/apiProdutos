package br.com.cotiinformatica.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//mapear classe para ser interpreatada como controladora de API REST
@RestController

//mapear o endpoint desse controlador na API
@RequestMapping("/api/fornecedores")
public class FornecedoresController {

	@GetMapping
	public void get(){
		//TODO
	}
	
}
