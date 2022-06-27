package com.api.bibliotecacontrol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.bibliotecacontrol.entities.LivroEntity;

@Repository
public interface LivroRepository extends JpaRepository<LivroEntity, Long>{
	
	//List<LivroEntity> findByAutoresId(Long id);

}
