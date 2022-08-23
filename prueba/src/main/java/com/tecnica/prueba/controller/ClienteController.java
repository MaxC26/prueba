package com.tecnica.prueba.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tecnica.prueba.entity.Cliente;
import com.tecnica.prueba.services.ClienteServices;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	ClienteServices clienteServices;
	
	@GetMapping()
	@CrossOrigin(origins = "http://localhost")
	public ArrayList<Cliente> obtenerClientes(){
		return clienteServices.obtenerCliente();
	}
	
	@PostMapping()
	@CrossOrigin(origins = "http://localhost")
	public Cliente guardarCliente(@RequestBody Cliente cliente) {
		return this.clienteServices.guardarCliente(cliente);
	}
	
	@GetMapping(path = "/{id}")
	@CrossOrigin(origins = "http://localhost")
	public Optional<Cliente> obtenerClientePorId(@PathVariable("id") Integer id){
		return this.clienteServices.obtenerPorId(id);
	}
	
	@PatchMapping
	@CrossOrigin(origins = "http://localhost")
	public Cliente actualizarCliente(@RequestBody Cliente cliente) {
		return this.clienteServices.guardarCliente(cliente);
	}
	
	@DeleteMapping(path = "/{id}")
	@CrossOrigin(origins = "http://localhost")
	public String eliminarCliente(@PathVariable("id") Integer id) {
		boolean ok = this.clienteServices.eliminarCliente(id);
		if(ok) {
			return "Eliminado";
		}else {
			return "Cliente no encontrado";
		}
	}
	
	
}
