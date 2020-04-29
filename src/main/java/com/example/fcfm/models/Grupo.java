package com.example.fcfm.models;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Grupo {

	//@Value("${grupo.clave}")
	private Integer clave;
	//@Value("${grupo.salon}")
	private Integer salon;
	@Autowired
	private Maestro maestro;
	@Autowired
	private List<Alumno> alumnos;
	
	@PostConstruct
	public void construct() {
		this.clave = 123213;
		this.salon = 309;
	}
	
	@PreDestroy
	public void destroy() {
		//alumnos.stream().forEach(System.out::println);
		for(Alumno a : alumnos) {
			System.out.println(a.getNombre().concat(" ").concat(a.getMatricula().toString()));
		}
	}

	public Integer getClave() {
		return clave;
	}

	public void setClave(Integer clave) {
		this.clave = clave;
	}

	public Integer getSalon() {
		return salon;
	}

	public void setSalon(Integer salon) {
		this.salon = salon;
	}

	public Maestro getMaestro() {
		return maestro;
	}

	public void setMaestro(Maestro maestro) {
		this.maestro = maestro;
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

}
