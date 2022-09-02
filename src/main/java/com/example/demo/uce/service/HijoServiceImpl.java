package com.example.demo.uce.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.uce.repository.HijoRepository;
import com.example.demo.uce.repository.modelo.Hijo;
import com.example.demo.uce.service.to.HijoTo;

@Service
public class HijoServiceImpl implements IHijoService {

	@Autowired
	private HijoRepository hijoRepository;

	@Override
	public List<HijoTo> buscarHijosporId(Integer id) {
		List<Hijo> lista = this.hijoRepository.buscarHijosporId(id);
		return lista.stream().map(hijo -> this.convertirHijoTo(hijo))
				.collect(Collectors.toList());
	}

	private HijoTo convertirHijoTo(Hijo hijo) {
		HijoTo hijoto = new HijoTo();
		hijoto.setId(hijo.getId());
		hijoto.setNombre(hijo.getNombre());
		hijoto.setGenero(hijo.getGenero());
		return hijoto;
	}

}
