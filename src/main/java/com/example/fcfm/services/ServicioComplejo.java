package com.example.fcfm.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.example.fcfm.services.interfaces.AlgoService;

@Component("ServicioComplejo")
@Primary
public class ServicioComplejo implements AlgoService {

	@Override
	public String servicio() {
		return "Servicio complejo";
	}

}
