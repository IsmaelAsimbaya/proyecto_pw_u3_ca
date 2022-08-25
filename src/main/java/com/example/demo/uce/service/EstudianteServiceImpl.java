package com.example.demo.uce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.uce.repository.IEstudianteRepository;
import com.example.demo.uce.repository.modelo.Estudiante;

@Service
public class EstudianteServiceImpl implements IEstudianteService{

	@Autowired
	private IEstudianteRepository estudianteRepository;
	
	@Override
	public void crear(Estudiante estudiante) {
		this.estudianteRepository.crear(estudiante);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		this.estudianteRepository.actualizar(estudiante);
	}

	@Override
	public void eliminar(Integer id) {
		this.estudianteRepository.eliminar(id);
	}

	@Override
	public Estudiante buscarPorId(Integer id) {
		return this.estudianteRepository.buscar(id);
	}

	@Override
	public List<Estudiante> buscarPorSemestre(Integer semestre) {
		return this.estudianteRepository.buscarPorSemestre(semestre);
	}

	
	
}
