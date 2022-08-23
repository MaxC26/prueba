package com.tecnica.prueba.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecnica.prueba.entity.Documento;
import com.tecnica.prueba.repository.DocumentoRepository;

@Service
public class DocumentoService {

	@Autowired
	DocumentoRepository documentoRepository;
	
	public ArrayList<Documento> obtenerDocumento(){
		return (ArrayList<Documento>) documentoRepository.findAll();
	}
	
	public Documento guardarDocumento(Documento documento) {
		return documentoRepository.save(documento);
	}
	
	public Optional<Documento> obtenerPorId(Integer id){
		return documentoRepository.findById(id);
	}
	
	public boolean eliminarDocumento(Integer id) {
		try {
			documentoRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public ArrayList<Documento> obtenerPorLlaveFk(Integer id){
		return documentoRepository.obtenerPorIdFk(id);
	}
	
}
