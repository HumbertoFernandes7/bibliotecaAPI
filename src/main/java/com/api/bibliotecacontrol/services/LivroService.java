package com.api.bibliotecacontrol.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.bibliotecacontrol.entities.LivroEntity;
import com.api.bibliotecacontrol.repositories.LivroRepository;

@Service
public class LivroService {
	//auto injeta a classe
	@Autowired
	private LivroRepository livroRepository;
	
	public LivroEntity buscaLivroPorId(Long id) {
		Optional<LivroEntity> encontrou = livroRepository.findById(id);
			return encontrou.get();
	}
	
	//public List<LivroEntity> buscaLivroPeloIdAutor(Long id) {
	//	return livroRepository.findByAutoresId(id);
	//}
}