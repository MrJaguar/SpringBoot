package com.example.fcfm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.fcfm.services.interfaces.AlgoService;

@Controller
@RequestMapping({ "/service" })
public class ServiceController {

	@Value("${titulo.index}")
	private String titulo;

	@Value("${h1.index}")
	private String h1;

//	@Autowired
//	private Environment env;
	
	@Autowired
	private AlgoService service;
	
	@Autowired
	@Qualifier("ServicioSimple")
	private AlgoService service2;

	@GetMapping({ "/uno" })
	public String servicio1(Model model) {
		model.addAttribute("titulo", titulo);
		model.addAttribute("h1", h1);
		model.addAttribute("respuesta", service.servicio());
		return "service";
	}
	@GetMapping({ "/dos" })
	public String seervicio2(Model model) {
		model.addAttribute("titulo", titulo);
		model.addAttribute("h1", h1);
		model.addAttribute("respuesta", service2.servicio());
		return "service";
	}

}
