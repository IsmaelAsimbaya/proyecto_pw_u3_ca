package com.example.demo.uce.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.uce.repository.modelo.Empleado;
import com.example.demo.uce.service.IEmpleadoService;

@RestController
@RequestMapping("/empleados")
public class EmpleadoRestFulController {

	@Autowired
	private IEmpleadoService empleadoService;

	@PostMapping
	public String crear(@RequestBody Empleado empleado) {
		String mensaje = "Empleado insertado correctamente";
		try {
			this.empleadoService.crear(empleado);
		} catch (Exception e) {
			mensaje = "Error intente de nuevo";
		}

		return mensaje;
	}

	@PutMapping
	public String actualizar(@RequestBody Empleado empleado) {
		this.empleadoService.actualizar(empleado);
		return "Empleado Actualizado";
	}

	@GetMapping(path = "/{idEmpleado}")
	public ResponseEntity<Empleado> buscarEmpleado(@PathVariable("idEmpleado") Integer id) {
		Empleado empl = this.empleadoService.buscarPorId(id);
		return ResponseEntity.ok(empl);
	}

	@DeleteMapping(path = "{idEmpleado}")
	public String eliminar(@PathVariable("idEmpleado") Integer id) {
		this.empleadoService.eliminar(id);
		return "Empleado eliminado";
	}
	
	@GetMapping
	public List<Empleado> buscarPorSalario(@PathParam(value="sal") BigDecimal salario){
		return this.empleadoService.buscarPorSalario(salario);
	}

}
