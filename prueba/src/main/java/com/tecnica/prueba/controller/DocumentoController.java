package com.tecnica.prueba.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tecnica.prueba.entity.Documento;
import com.tecnica.prueba.services.DocumentoService;

@RestController
@RequestMapping("/documento")
public class DocumentoController {

	@Autowired
	DocumentoService documentoService;
	
	@GetMapping()
	@CrossOrigin(origins = "http://localhost")
	public ArrayList<Documento> obtenerDocumentos(){
		return documentoService.obtenerDocumento();
	}
	
	@PostMapping()
	@CrossOrigin(origins = "http://localhost")
	public Documento guardarDocumento(@RequestBody Documento documento) {
		return documentoService.guardarDocumento(documento);
	}
	
	@GetMapping(path = "/{id}")
	@CrossOrigin(origins = "http://localhost")
	public Optional<Documento> obtenerDocumentoPorId(@PathVariable("id") Integer id){
		return this.documentoService.obtenerPorId(id);
	}
	
	@GetMapping(path = "/user/{id}")
	@CrossOrigin(origins = "http://localhost")
	public ArrayList<Documento> obtenerDireccionesPorIdUsuario(@PathVariable("id") Integer id){
		return this.documentoService.obtenerPorLlaveFk(id);
	}
	
	@DeleteMapping(path = "/{id}")
	@CrossOrigin(origins = "http://localhost")
	public String eliminarDocumento(@PathVariable("id") Integer id) {
		boolean ok = this.documentoService.eliminarDocumento(id);
		if(ok) {
			return "Eliminado";
		}else {
			return "Documento no encontrado";
		}
	}
}
