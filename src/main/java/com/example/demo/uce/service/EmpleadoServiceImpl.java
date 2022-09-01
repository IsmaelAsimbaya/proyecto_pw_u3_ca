package com.example.demo.uce.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.uce.repository.IEmpleadoRepository;
import com.example.demo.uce.repository.modelo.Empleado;
import com.example.demo.uce.service.to.EmpleadoTo;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

	@Autowired
	private IEmpleadoRepository empleadoRepository;

	@Override
	public void crear(Empleado empleado) {
		this.empleadoRepository.crear(empleado);
	}

	@Override
	public void actualizar(Empleado empleado) {
		this.empleadoRepository.actualizar(empleado);
	}

	@Override
	public void eliminar(Integer id) {
		this.empleadoRepository.eliminar(id);
	}

	@Override
	public Empleado buscarPorId(Integer id) {
		return this.empleadoRepository.buscar(id);
	}

	@Override
	public List<Empleado> buscarPorSalario(BigDecimal salario){
		return this.empleadoRepository.buscarPorSalario(salario);
	}

	@Override
	public List<EmpleadoTo> buscarTodos() {
		List<Empleado> lista = this.empleadoRepository.buscarTodos();
		return lista.stream().map(empleado -> this.convertirEmpleadoTo(empleado))
		.collect(Collectors.toList());
	}
	
	private EmpleadoTo convertirEmpleadoTo(Empleado empleado){
		EmpleadoTo aux = new EmpleadoTo();
		aux.setId(empleado.getId());
		aux.setNombre(empleado.getNombre());
		aux.setApellido(empleado.getApellido());
		aux.setFechaNacimiento(empleado.getFechaNacimiento());
		aux.setSalario(empleado.getSalario());
		return aux;
	}
}
