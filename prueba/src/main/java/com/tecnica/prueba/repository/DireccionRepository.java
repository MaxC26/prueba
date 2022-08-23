package com.tecnica.prueba.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tecnica.prueba.entity.Direccion;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion, Integer>{

	@Query(value = "select * from direccion where cd_fk = :id", nativeQuery = true)
	ArrayList<Direccion> obtenerPorIdFk(@Param("id") Integer id);
}
