package com.example.fcfm.services;

import org.springframework.stereotype.Service;

import com.example.fcfm.services.interfaces.AlgoService;

@Service("ServicioSimple")
public class ServicioSimple implements AlgoService {

	@Override
	public String servicio() {
		return "Servicio simple";
	}

}
