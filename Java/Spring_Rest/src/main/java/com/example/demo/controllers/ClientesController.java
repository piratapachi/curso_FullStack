package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Clientes;
import com.example.demo.services.ClientesService;

@RestController
@RequestMapping("/clientes")
@CrossOrigin(origins = {"http://localhost:3306/Clientes"})
public class ClientesController {
	@Autowired
	private ClientesService clientesService;
	
	@PostMapping("/nuevo")
	public Clientes newCliente(@RequestBody Clientes newCliente) {
		return this.clientesService.newCliente(newCliente);
	}
	
	@GetMapping("/mostrar")
	public Iterable<Clientes> getAll(){
		return clientesService.getAll();
	}
	
	@PostMapping("/update")
	public Clientes updateCliente(@RequestBody Clientes cliente) {
		return this.clientesService.modifyCliente(cliente);
	}
	
	@PostMapping(value = "/{id}")
	public Boolean deleteCliente(@PathVariable(value = "id")Long id) {
		return this.clientesService.deleteCliente(id);
	}
}
