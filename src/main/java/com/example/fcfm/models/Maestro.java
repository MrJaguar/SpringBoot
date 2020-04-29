package com.example.fcfm.models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Maestro {

	@Value("${maestro.nombre}")
	private String nombre;
	@Value("${maestro.numero.empleado}")
	private Long numeroEmpleado;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getNumeroEmpleado() {
		return numeroEmpleado;
	}

	public void setNumeroEmpleado(Long numeroEmpleado) {
		this.numeroEmpleado = numeroEmpleado;
	}

}
