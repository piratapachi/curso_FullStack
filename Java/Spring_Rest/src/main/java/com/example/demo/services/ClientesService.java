package com.example.demo.services;

import com.example.demo.models.Clientes;

public interface ClientesService {
	Clientes newCliente(Clientes newCliente);
	Iterable<Clientes> getAll();
	Clientes modifyCliente(Clientes clientes);
	Boolean deleteCliente(Long numDoc);
}
