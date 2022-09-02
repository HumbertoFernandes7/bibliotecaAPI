package com.example.demo.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.tags.Tag;

@Configuration
public class OpenAPIConfig {

	@Bean
	public OpenAPI springShopOpenAPI() {
		OpenAPI openAPI = new OpenAPI();
		
		Info info = new Info();
		info.title("Biblioteca G&P");
		info.version("v0.0.1");
		info.description("<h2>Sistema de Biblioteca G&P</h2>");
		openAPI.info(info);
		openAPI.addTagsItem(new Tag().name("Autor").description("Gerencia os autores do sistema"));
		openAPI.addTagsItem(new Tag().name("Livro").description("Gerencia os Livros do sistema"));
		
		return openAPI;
	}
}
