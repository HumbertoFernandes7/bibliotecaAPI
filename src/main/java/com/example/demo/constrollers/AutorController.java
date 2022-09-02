package com.example.demo.constrollers;

import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.converts.AutorConvert;
import com.example.demo.converts.LivroConvert;
import com.example.demo.dto.inputs.AutorInput;
import com.example.demo.dto.outputs.AutorOutput;
import com.example.demo.dto.outputs.LivroOutput;
import com.example.demo.entities.AutorEntity;
import com.example.demo.entities.LivroEntity;
import com.example.demo.services.AutorService;
import com.example.demo.services.LivroService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Autor")
@RestController
@RequestMapping("/api/autores")
@CrossOrigin(origins = "*")
public class AutorController {

	@Autowired
	private AutorService autorService;

	@Autowired
	private LivroService livroService;

	@Autowired
	private AutorConvert autorConvert;

	@Autowired
	private LivroConvert livroConvert;
	
	

	@Operation(summary = "Cadastra Autor", description = "Cadastra autor no banco de dados")
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public AutorOutput criaAutor(
			@Valid @Parameter(description = "Representação de um Autor") @RequestBody AutorInput autor)
			throws URISyntaxException {
		AutorEntity autorEntity = autorConvert.inputToEntity(autor);
		AutorEntity autorCriado = autorService.cria(autorEntity);
		return autorConvert.entityToOutput(autorCriado);
	}
	
	

	@Operation(summary = "Altera Autor", description = "Altera o autor que esta no banco de dados")
	@PutMapping("/{id}")
	public AutorOutput alteraAutor(@Valid @Parameter(description = "ID do Autor", example = "1") @PathVariable Long id,
			@Parameter(description = "Representação de um Autor") @RequestBody AutorInput autorInput) {
		AutorEntity autorEntity = autorConvert.inputToEntity(autorInput);
		autorEntity.setId(id);
		AutorEntity autorAlterado = autorService.alterar(autorEntity);
		return autorConvert.entityToOutput(autorAlterado);
	}
	
	

	@Operation(summary = "Busca Autor por ID", description = "Busca um autor no banco de dados pelos seu ID")
	@GetMapping("/{id}")
	public AutorOutput buscaAutorPorId(@Parameter(description = "ID do Autor", example = "1") @PathVariable Long id) {
		AutorEntity autorEntity = autorService.buscaPeloId(id);
		return autorConvert.entityToOutput(autorEntity);
	}
	
	

	@Operation(summary = "Lista todos Autores", description = "Busca todos os autores no banco de dados")
	@GetMapping
	public List<AutorOutput> listaAutores() {
		List<AutorEntity> listaTodos = autorService.listaTodos();
		return autorConvert.entityToOutput(listaTodos);
	}
	
	

	@Operation(summary = "Lista de livros pelo ID do Autor", description = "Busca os livros no banco de dados pelo ID do autor ")
	@GetMapping("/{idAutor}/livros")
	public List<LivroOutput> listaLivros(
			@Parameter(description = "ID do Autor", example = "1") @PathVariable Long idAutor) {
		List<LivroEntity> listaTodos = livroService.listaLivrosPeloAutor(idAutor);
		return livroConvert.entityToOutput(listaTodos);
	}

}
