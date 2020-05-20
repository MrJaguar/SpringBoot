package com.example.fcfm.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.fcfm.models.entitys.Alumno;

@Repository
public class AlumnoDaoImp implements AlumnoDao {
	
	@PersistenceContext
	private EntityManager en;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly = true)
	public List<Alumno> findAll() {
		/*HQL o JPQL != SQL*/
		List<Alumno> result = en.createQuery("from Alumno").getResultList();//select * from alumno
		return result;
//		return en.createQuery("from Alumno").getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public Alumno find(Long id) {
		Alumno result = en.find(Alumno.class, id);//select * from alumno where id ={id}
		return result;
	}

	@Override
	@Transactional
	//Deberia llamarse guardar
	public void insert(Alumno nuevo) {
		if(nuevo.getId() != null && nuevo.getId() > 0) {
			en.merge(nuevo);
		}else {
			en.persist(nuevo);//insert into alumno (nombre, apellido, edad, fecha_nacimiento) values ('eduardo', 'guajardo', 24, '1995-11-26');
		}
		en.flush();
	}

	@Override
	@Transactional
	public void update(Alumno nuevo) {
		Alumno antes = find(nuevo.getId());
		//direccion de contexto nuevo es otra direccion
		BeanUtils.copyProperties(nuevo, antes);
//		antes.setNombre(nuevo.getNombre());
//		antes.setApellido(nuevo.getApellido());
//		antes.setEdad(nuevo.getEdad());
//		antes.setFechaNacimiento(nuevo.getFechaNacimiento());
		en.flush();
	}

	@Override
	@Transactional
	public void delete(Long id) {
		Alumno entity = find(id);
//		en.remove(find(id));
		en.remove(entity);
	}

}
