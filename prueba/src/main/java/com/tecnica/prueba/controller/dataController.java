package com.tecnica.prueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tecnica.prueba.dto.DataRequest;
import com.tecnica.prueba.entity.Cliente;
import com.tecnica.prueba.repository.ClienteRepository;

@RestController
public class dataController {
	
	@Autowired
	private ClienteRepository clienteRepository;
		
	@PostMapping("/info-cliente")
	public Cliente guardarCliente(@RequestBody DataRequest request) {
		return clienteRepository.save(request.getCliente());
	}
	
	@GetMapping("/info-cliente")
	public List<Cliente> finAllCliente(){
		return clienteRepository.findAll();
	}
}
