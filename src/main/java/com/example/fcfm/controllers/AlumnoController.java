package com.example.fcfm.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.fcfm.models.dao.AlumnoDao;
import com.example.fcfm.models.entitys.Alumno;

@Controller
@RequestMapping(path = "/alumno")
@SessionAttributes("alumno")
public class AlumnoController {

	@Autowired
	private AlumnoDao alumnoDao;

	@GetMapping({ "", "/" })
	public String alumnos(Model model) {
		model.addAttribute("titulo", "Alumno");
		model.addAttribute("alumnos", alumnoDao.findAll());
		return "catalogo/alumno/lista";
	}

	@GetMapping({ "/form" })
	public String form(Model model) {
		model.addAttribute("titulo", "Alumno");
		Alumno nuevo = new Alumno();
		model.addAttribute("alumno", nuevo);
		return "catalogo/alumno/form";
	}

	@GetMapping({ "/form/{id}" })
	public String editar(@PathVariable Long id, Model model) {
		model.addAttribute("titulo", "Alumno");
		Alumno editar = alumnoDao.find(id);
		model.addAttribute("alumno", editar);
		return "catalogo/alumno/form";
	}

	@PostMapping({ "/guardar" })
	public String guardar(@Valid Alumno alumno, BindingResult result, Model model, SessionStatus sesion) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Alumno");
			return "catalogo/alumno/form";
		}
		System.out.println(alumno.getId());
		if (alumno.getId() != null && alumno.getId() > 0) {
			alumnoDao.update(alumno);
		} else {
			alumnoDao.insert(alumno);
		}

		sesion.setComplete();
		return "redirect:/alumno";
	}

	@GetMapping({ "/eliminar/{id}" })
	public String eliminar(@PathVariable Long id, Model model) {
		if (id != null && id > 0) {
			alumnoDao.delete(id);
		}
		return "redirect:/alumno";
	}

}
