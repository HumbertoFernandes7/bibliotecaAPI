package com.api.bibliotecacontrol.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.api.bibliotecacontrol.entities.LivroEntity;
import com.api.bibliotecacontrol.repositories.LivroRepository;
import com.api.bibliotecacontrol.services.LivroService;

@RestController
@RequestMapping("/api/livros")
public class LivroController {
	
	@Autowired
	private LivroRepository livroRepository;
	
	@Autowired
	private LivroService cadastroLivro;
	
	
	// adicionar livro
	@PostMapping("/adicionar")
	public LivroEntity AdicionaLivro(@RequestBody @Valid LivroEntity livroEntity) {
		return livroRepository.save(livroEntity);
	}
	
	
	// atualizar livro
	@PutMapping("/atualizar/{id}")
	public LivroEntity atualizarLivro(@PathVariable Long id, @RequestBody @Valid LivroEntity livroEntity ) {
		return livroRepository.save(livroEntity);
	}
	
	
	// lista todos os livros
	@GetMapping
	public List<LivroEntity> ListaTodosLivros(){
		return livroRepository.findAll();
	}	
	
	
	//lista Livro por id
		@GetMapping("/{id}")
		public ResponseEntity<LivroEntity> buscaLivroPorId(@PathVariable Long id) {
			LivroEntity obj = cadastroLivro.buscaLivroPorId(id);
			return ResponseEntity.ok().body(obj);
		}
	
	
	// deletar um livro pelo id
	@DeleteMapping("/deletar/{id}")
	public LivroEntity DeletarLivroPeloId(@PathVariable(name= "id", required = true)Long id) {
		livroRepository.deleteById(id);
		return null;
	}
}
