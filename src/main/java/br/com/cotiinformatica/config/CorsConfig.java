package br.com.cotiinformatica.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer{

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		
		//WebMvcConfigurer.super.addCorsMappings(registry);
		
		//POLITICA D EPERMISSSAO DO CORS
		registry.addMapping("/**") //todos os endpoints da api
			.allowedOrigins("http://localhost:4200")//SERVIDORES
			.allowedMethods("POST","PUT","DELETE","GET")//metodos
			.allowedHeaders("*");//parametros de cabecalo das requisicoes
	}
}
