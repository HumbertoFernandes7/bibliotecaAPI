package com.api.bibliotecacontrol.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.bibliotecacontrol.entities.AutorEntity;
import com.api.bibliotecacontrol.repositories.AutorRepository;
import com.api.bibliotecacontrol.services.CadastroAutor;

@RestController
@RequestMapping("/api/autores")
public class AutorController {
	
	@Autowired
	private CadastroAutor cadastroAutor;
	
	@Autowired
	private AutorRepository autorRepository;

	
	//adiciona autor
	@PostMapping("/adicionar")
	public AutorEntity AdicionaAutor(@RequestBody @Valid AutorEntity autorEntity) {
		return autorRepository.save(autorEntity);
	}
	
	
	//atualiza autor
	@PutMapping("/atualizar/{id}")
	public AutorEntity atualizarAutor(@PathVariable Long id, @RequestBody @Valid AutorEntity autorEntity ) {
		return autorRepository.save(autorEntity);
	}
	
	
	//lista todos os autores
	@GetMapping
	public List<AutorEntity> ListaTodosAutores(){
		return autorRepository.findAll();
	}
	
	
	//lista autores por id
	@GetMapping("/{id}")
	public ResponseEntity<AutorEntity> buscaAutorPorId(@PathVariable Long id) {
		AutorEntity obj = cadastroAutor.buscaAutorPorId(id);
		return ResponseEntity.ok().body(obj);
	}
}

