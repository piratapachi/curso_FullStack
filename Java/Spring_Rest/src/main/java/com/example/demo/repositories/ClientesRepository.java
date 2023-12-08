package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Clientes;

public interface ClientesRepository extends  JpaRepository<Clientes, Long>{

}
