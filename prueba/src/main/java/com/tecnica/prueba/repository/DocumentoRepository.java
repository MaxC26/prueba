package com.tecnica.prueba.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tecnica.prueba.entity.Documento;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Integer>{

	@Query(value = "select * from documento where cn_fk = :id", nativeQuery = true)
	ArrayList<Documento> obtenerPorIdFk(@Param("id") Integer id);
}
