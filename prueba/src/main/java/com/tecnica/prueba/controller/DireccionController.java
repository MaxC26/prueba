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

import com.tecnica.prueba.entity.Direccion;
import com.tecnica.prueba.services.DireccionService;

@RestController
@RequestMapping("/direccion")
public class DireccionController {

	@Autowired
	DireccionService direccionService;
	
	@GetMapping()
	@CrossOrigin(origins = "http://localhost")
	public ArrayList<Direccion> obtenerDirecciones(){
		return direccionService.obtenerDireccion();
	}
	
	@PostMapping()
	@CrossOrigin(origins = "http://localhost")
	public Direccion guardarDireccion(@RequestBody Direccion direccion) {
		return direccionService.guardarDireccion(direccion);
	}
	
	@GetMapping(path = "/{id}")
	@CrossOrigin(origins = "http://localhost")
	public Optional<Direccion> obtenerDireccionPorId(@PathVariable("id") Integer id){
		return this.direccionService.obtenerPorId(id);
	}
	
	@GetMapping(path = "/user/{id}")
	@CrossOrigin(origins = "http://localhost")
	public ArrayList<Direccion> obtenerDireccionesPorIdUsuario(@PathVariable("id") Integer id){
		return this.direccionService.obtenerPorLlaveFk(id);
	}
	
	@DeleteMapping(path = "/{id}")
	@CrossOrigin(origins = "http://localhost")
	public String eliminarDireccion(@PathVariable("id") Integer id) {
		boolean ok = this.direccionService.eliminarDireccion(id);
		if(ok) {
			return "Eliminado";
		}else {
			return "Direccion no encontrado";
		}
	}
}
