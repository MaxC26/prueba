package com.tecnica.prueba.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecnica.prueba.entity.Direccion;
import com.tecnica.prueba.repository.DireccionRepository;

@Service
public class DireccionService {

	@Autowired
	DireccionRepository direccionRepository;
	
	public ArrayList<Direccion> obtenerDireccion(){
		return (ArrayList<Direccion>) direccionRepository.findAll();
	}
	
	public Direccion guardarDireccion( Direccion direccion) {
		return direccionRepository.save(direccion);
	}
	
	public Optional<Direccion> obtenerPorId(Integer id){
		return direccionRepository.findById(id);
	}
	
	public boolean eliminarDireccion(Integer id) {
		try {
			direccionRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	public ArrayList<Direccion> obtenerPorLlaveFk(Integer id){
		return direccionRepository.obtenerPorIdFk(id); 
	}
}
