package com.example.demo.uce.repository;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.uce.repository.modelo.Estudiante;

@Repository
@Transactional
public class EstudianteRepositoryImpl implements IEstudianteRepository {

	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void crear(Estudiante estudiante) {
		this.em.persist(estudiante);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		this.em.merge(estudiante);
	}

	@Override
	public Estudiante buscar(Integer id) {
		return this.em.find(Estudiante.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		this.em.remove(this.buscar(id));
	}

	
}
