package com.tecnica.prueba.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tecnica.prueba.entity.Cliente;
import com.tecnica.prueba.repository.ClienteRepository;

@Service
public class ClienteServices {

	@Autowired
	ClienteRepository clienteRepository;
	
	public ArrayList<Cliente> obtenerCliente(){
		return (ArrayList<Cliente>) clienteRepository.findAll();
	}
	
	public Cliente guardarCliente(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public Optional<Cliente> obtenerPorId(Integer id){
		return clienteRepository.findById(id);
	}
	
	public boolean eliminarCliente(Integer id) {
		try {
			clienteRepository.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
}
