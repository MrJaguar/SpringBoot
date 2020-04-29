package com.example.fcfm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.fcfm.services.interfaces.CalcularService;

@Controller
public class IndexController {

	@Value("${titulo.index}")
	private String titulo;

	@Value("${h1.index}")
	private String h1;

	@Autowired
	private Environment env;

	@Autowired
	private CalcularService cal;

//	@RequestMapping(path = "/index")
	@GetMapping({ "/index", "/home" })
	public String index(Model model) {
		model.addAttribute("titulo", titulo);
		model.addAttribute("h1", h1);
		model.addAttribute("h2", env.getProperty("h1.index2"));
//		List<String> lista = new ArrayList<>();
//		for (String actual : lista) {
//			if (actual.contains("L"))
//				System.out.println(actual);
//		}
//		lista.stream().filter((o) -> o.contains("L")).filter(o -> o.contains("R")).forEach(System.out::println);
		return "index";
	}

	@GetMapping({ "/suma" })
	public String suma(@RequestParam Integer num1, @RequestParam Integer num2, Model model) {
		model.addAttribute("titulo", titulo);
		model.addAttribute("h1", "Suma");
		model.addAttribute("suma", cal.suma(num1, num2));
		return "suma";
	}

	@GetMapping({ "/suma/{num1}/{num2}" })
	public String sumaPath(@PathVariable Integer num1, @PathVariable Integer num2, Model model) {
		model.addAttribute("titulo", titulo);
		model.addAttribute("h1", "Suma");
		model.addAttribute("suma", cal.suma(num1, num2));
		return "suma";
	}

}
