package com.example.demo.constrollers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.converts.LivroConvert;
import com.example.demo.dto.inputs.LivroInput;
import com.example.demo.dto.outputs.LivroOutput;
import com.example.demo.entities.AutorEntity;
import com.example.demo.entities.LivroEntity;
import com.example.demo.services.AutorService;
import com.example.demo.services.LivroService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Livro")
@RestController
@RequestMapping("/api/livros")
@CrossOrigin(origins = "*")
public class LivroController {

	@Autowired
	private LivroService livroService;

	@Autowired
	private AutorService autorService;

	@Autowired
	private LivroConvert livroConvert;
	
	

	@Operation(summary = "Cadastra Livro", description = "Cadastra um Livro no banco de dados")
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public LivroOutput criaLivro(
			@Valid @Parameter(description = "Representação de um Livro") @RequestBody LivroInput livro) {
		LivroEntity livroEntity = livroConvert.inputToEntity(livro);

		convertAutores(livro, livroEntity);

		LivroEntity livroCriado = livroService.cria(livroEntity);
		return livroConvert.entityToOutput(livroCriado);
	}

	@Operation(summary = "Atualiza Livro", description = "Atualiza um Livro no banco de dados pelo seu ID")
	@PutMapping("/{id}")
	public LivroOutput alteraLivro(@Parameter(description = "ID do Livro", example = "1") @PathVariable Long id,
			@Valid @Parameter(description = "Representação de um Livro") @RequestBody LivroInput livroInput) {
		LivroEntity livroEntity = livroService.buscaPeloId(id);
		livroConvert.copyDataInputToEntity(livroInput, livroEntity);

		convertAutores(livroInput, livroEntity);

		LivroEntity livroAlterado = livroService.alterar(livroEntity);
		return livroConvert.entityToOutput(livroAlterado);
	}
	
	

	@Operation(summary = "Busca livro por ID", description = "Busca um Livro no banco de dados pelo seu ID")
	@GetMapping("/{id}")
	public LivroOutput buscaLivroPorId(@Parameter(description = "ID do Livro", example = "1") @PathVariable Long id) {
		LivroEntity livroEntity = livroService.buscaPeloId(id);
		return livroConvert.entityToOutput(livroEntity);
	}

	@Operation(summary = "Lista todos Livros", description = "Busca todos os Livros no banco de dados")
	@GetMapping
	public List<LivroOutput> listaLivros() {
		List<LivroEntity> listaTodos = livroService.listaTodos();
		return livroConvert.entityToOutput(listaTodos);
	}
	
	

	@Operation(summary = "Deleta Livro", description = "Deleta o livro no banco de dados pelo seu ID")
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void removeLivro(@Parameter(description = "ID do Livro", example = "1") @PathVariable Long id) {
		LivroEntity livroEntity = livroService.buscaPeloId(id);
		livroService.remover(livroEntity);
	}
	
	

	private void convertAutores(LivroInput livro, LivroEntity livroEntity) {
		List<AutorEntity> autores = new ArrayList<>();
		for (Long autorId : livro.getAutoresIds()) {
			autores.add(autorService.buscaPeloId(autorId));
		}
		livroEntity.setAutores(autores);
	}
}
