package com.example.demo.uce.service;

import com.example.demo.uce.repository.modelo.Empleado;

public interface IEmpleadoService {

	public void crear(Empleado empleado);

	public void actualizar(Empleado empleado);

	public void eliminar(Integer id);
	
	public Empleado buscarPorId(Integer id);
	
}
