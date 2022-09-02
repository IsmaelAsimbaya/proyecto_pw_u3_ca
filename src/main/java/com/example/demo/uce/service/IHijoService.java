package com.example.demo.uce.service;

import java.util.List;

import com.example.demo.uce.service.to.HijoTo;

public interface IHijoService {
	
	public List<HijoTo> buscarHijosporId(Integer id);
	
}
