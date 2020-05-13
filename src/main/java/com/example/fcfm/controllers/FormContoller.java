package com.example.fcfm.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.fcfm.models.Usuario;

@Controller
@RequestMapping(path = "/form")
public class FormContoller {

	@Value("${titulo.index}")
	private String titulo;

	@Value("${h1.index}")
	private String h1;

	@GetMapping({ "/", "" })
	public String form(Model model) {
		model.addAttribute("h1", h1);
		model.addAttribute("titulo", titulo);
		Usuario usuario = new Usuario();
		model.addAttribute("usuario", usuario);
		return "form";
	}

	@GetMapping(path = "/resultado")
	public String result(@RequestParam String name, @RequestParam String lastName, @RequestParam Integer age,
			Model model) {
		model.addAttribute("h1", "Resultado Formulario");
		model.addAttribute("titulo", titulo);
		Usuario usuario = new Usuario(name, lastName, age);
		model.addAttribute("usuario", usuario);

		model.addAttribute("completeName", name.concat(" ").concat(lastName).toUpperCase().trim());

		return "result";
	}

	@GetMapping(path = "/resultadoObject")
	public String resultObject(@Valid Usuario usuario, BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			model.addAttribute("h1", h1.concat(" Existen errores"));
			model.addAttribute("titulo", titulo);
			Map<String, String> errores = new HashMap<>();
			result.getFieldErrors()
			.forEach(err -> errores.put(err.getField(), err.getDefaultMessage()));
			model.addAttribute("error", errores);
			return "form";
		}
		model.addAttribute("h1", "Resultado Formulario");
		model.addAttribute("titulo", titulo);

		model.addAttribute("usuario", usuario);
		model.addAttribute("completeName",
				usuario.getName().concat(" ").concat(usuario.getLastName()).toUpperCase().trim());

		return "result";
	}

}
