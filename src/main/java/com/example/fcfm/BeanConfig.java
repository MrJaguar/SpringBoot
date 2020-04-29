package com.example.fcfm;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.fcfm.models.Alumno;

@Configuration
public class BeanConfig {
	
//	@Bean("ServicioSimple")
//	public ServicioSimple getServicioSimple() {
//		return new ServicioSimple();
//	}
//	@Bean("ServicioComplejo")
//	@Primary
//	public ServicioComplejo getServicioComplejo() {
//		return new ServicioComplejo();
//	}

	@Bean
	public List<Alumno> getListaAlumno(){
		List<Alumno> out = new ArrayList<>();
		Alumno a1 = new Alumno();
		a1.setMatricula(15895699l);
		a1.setNombre("Eduardo");
		Alumno a2 = new Alumno();
		a2.setMatricula(1599l);
		a2.setNombre("Raquel");
		out.add(a1);
		out.add(a2);
		return out;
	}
}
