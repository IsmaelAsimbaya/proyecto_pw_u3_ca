package com.example.demo.uce.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.uce.repository.modelo.Hijo;

@Repository
@Transactional
public class HijoRepository implements IHijoRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Hijo> buscarHijosporId(Integer id) {
		TypedQuery<Hijo> myQuery = this.em.createQuery("SELECT h FROM Hijo h WHERE h.empleado.id = :idEmpleado", Hijo.class);
		myQuery.setParameter("idEmpleado", id);
		return myQuery.getResultList();
	}

}
