package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Clientes {
	
	@Id
	@Column
	private Long numDoc;
	
	@Column
	private String apellido;
	
	@Column
	private String nombre;

	public Long getNumDoc() {
		return numDoc;
	}

	public void setNumDoc(Long numDoc) {
		this.numDoc = numDoc;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
