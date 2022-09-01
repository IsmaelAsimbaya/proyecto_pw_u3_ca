package com.example.demo.uce.repository;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.uce.repository.modelo.Empleado;
import com.example.demo.uce.repository.modelo.Hijo;

@Repository
@Transactional
public class EmpleadoRepositoryImpl implements IEmpleadoRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void crear(Empleado empleado) {
		this.em.persist(empleado);
	}

	@Override
	public void actualizar(Empleado empleado) {
		this.em.merge(empleado);
	}

	@Override
	public Empleado buscar(Integer id) {
		return this.em.find(Empleado.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		this.em.remove(this.buscar(id));
	}
	
	@Override
	public List<Empleado> buscarPorSalario(BigDecimal salario){
		TypedQuery<Empleado> myQuery = this.em.createQuery("SELECT e FROM Empleado e WHERE e.salario > :salarioDato", Empleado.class);
		myQuery.setParameter("salarioDato", salario);
		return myQuery.getResultList();
	}
	
	@Override
	public List<Hijo> buscarHijosporId(Integer id){
		TypedQuery<Hijo> myQuery = this.em.createQuery("SELECT h FROM Hijo h WHERE h.empleado.id = :idEmpleado", Hijo.class);
		myQuery.setParameter("idEmpleado", id);
		return myQuery.getResultList();
	}
	
	
	@Override
	public List<Empleado> buscarTodos(){
		TypedQuery<Empleado> myQuery = this.em.createQuery("SELECT e FROM Empleado e", Empleado.class);
		return myQuery.getResultList();
	}

}
