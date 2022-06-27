package com.api.bibliotecacontrol.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.bibliotecacontrol.entities.AutorEntity;
import com.api.bibliotecacontrol.repositories.AutorRepository;

@Service
public class CadastroAutor {
	//auto injeta a classe
	@Autowired
	private AutorRepository autorRepository;

	public AutorEntity buscaAutorPorId(Long id) {
		Optional<AutorEntity> encontrou = autorRepository.findById(id);
			return encontrou.get();
	}
}
