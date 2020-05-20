package com.example.fcfm.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.example.fcfm.validator.MayorDeEdad;

public class Usuario {

	@NotEmpty
	private String name;
	
	@NotEmpty
	private String lastName;
	
	@NotNull
	@MayorDeEdad
	private Integer age;

	public Usuario() {

	}

	public Usuario(String name, String lastName, Integer age) {
		this.name = name;
		this.lastName = lastName;
		this.age = age;
	}

	/**Este metodo sirve para obtener el nombre del usuario
	 * @return name el nombre del usuario*/
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
