package com.api.bibliotecacontrol.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.bibliotecacontrol.entities.AutorEntity;
//busca no banco de dados
@Repository
public interface AutorRepository extends JpaRepository<AutorEntity, Long>{

}
