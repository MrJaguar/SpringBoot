package com.example.fcfm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.fcfm.models.Grupo;


@Controller
@RequestMapping({ "/salon" })
public class SalonController {
	@Value("${titulo.index}")
	private String titulo;

	@Value("${h1.index}")
	private String h1;

//	@Autowired
//	private Environment env;
//	
	@Autowired
	private Grupo grupo;
	@GetMapping({ "/uno" })
	public String salon(Model model) {
		model.addAttribute("titulo", titulo);
		model.addAttribute("h1", h1);
		model.addAttribute("clave", grupo.getClave());
		model.addAttribute("salon", grupo.getSalon());
		model.addAttribute("maestro", grupo.getMaestro().getNombre());
		model.addAttribute("alumnos", grupo.getAlumnos());
		return "salon";
	}
	

}
