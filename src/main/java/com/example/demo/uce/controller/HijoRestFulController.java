package com.example.demo.uce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.uce.service.IHijoService;
import com.example.demo.uce.service.to.HijoTo;

@RestController
@RequestMapping("/hijos")
public class HijoRestFulController {

	@Autowired
	private IHijoService hijoService;
	
	@GetMapping(path = "/{idEmpleado}/hijos")
	public List<HijoTo> buscarHijos(@PathVariable("idEmpleado") Integer idEmpleado){
		return this.hijoService.buscarHijosporId(idEmpleado);
	}
	
	
}
