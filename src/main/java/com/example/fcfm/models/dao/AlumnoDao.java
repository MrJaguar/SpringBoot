package com.example.fcfm.models.dao;

import java.util.List;

import com.example.fcfm.models.entitys.Alumno;

public interface AlumnoDao {

	List<Alumno> findAll();
	Alumno find(Long id);
	void insert(Alumno nuevo);
	void update(Alumno nuevo);// debatible
	void delete(Long id);
}
