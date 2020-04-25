package com.example.fcfm.services;

import org.springframework.stereotype.Service;

import com.example.fcfm.services.interfaces.CalcularService;
/* 
 * Controladores Controller
 * Servicios Serivces
 * Daos Repositorys
 * */
@Service
public class CalcularServiceImpl implements CalcularService{
	
	@Override
	public Integer suma(Integer num1, Integer num2) {
		return num1 + num2;
	}

}
