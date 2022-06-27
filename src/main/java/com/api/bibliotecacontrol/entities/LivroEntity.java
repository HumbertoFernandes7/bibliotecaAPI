package com.api.bibliotecacontrol.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "TB_LIVROS")
public class LivroEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private Long id;
	
	@Column(name= "titulo")
	@NotNull @Length(max = 200)
	private String titulo;
	
	@Column(name= "dataLancamento")
	@NotNull @Digits(integer = 4, fraction = 0)
	private Integer dataLancamento;

	@Column(name = "autores")
	@NotNull @NotEmpty//@ManyToMany
	private String autores;
	

	public String getAutores() {
		return autores;
	}

	public void setAutores(String autores) {
		this.autores = autores;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Integer dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

}