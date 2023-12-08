package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Clientes;
import com.example.demo.repositories.ClientesRepository;

@Service
public class PersonaServiceImpl implements ClientesService {
	@Autowired
	private ClientesRepository clienteRepository;
	
	@Override
	public Clientes newCliente(Clientes newCliente) {
		return clienteRepository.save(newCliente);
	}

	@Override
	public Iterable<Clientes> getAll() {
		return this.clienteRepository.findAll();
	}

	@Override
	public Clientes modifyCliente(Clientes clientes) {
		Optional<Clientes> clienteEncontrado = this.clienteRepository.findById(clientes.getNumDoc());
		if(clienteEncontrado.get() != null) {
			clienteEncontrado.get().setNombre(clientes.getNombre());
			clienteEncontrado.get().setApellido(clientes.getApellido());
			return this.newCliente(clienteEncontrado.get());
	}
		return null;
		}

	@Override
	public Boolean deleteCliente(Long numDoc) {
		this.clienteRepository.deleteById(numDoc);
		return true;
	}

}
