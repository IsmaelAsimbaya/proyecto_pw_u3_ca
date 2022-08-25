package com.example.demo.uce.repository;

import com.example.demo.uce.repository.modelo.Estudiante;

public interface IEstudianteRepository {

	public void crear(Estudiante estudiante);

	public void actualizar(Estudiante estudiante);

	public void eliminar(Integer id);

	public Estudiante buscar(Integer id);

}