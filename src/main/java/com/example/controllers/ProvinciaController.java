package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Provincia;
import com.example.services.ProvinciaService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/provincias")
public class ProvinciaController {

	@Autowired
	private ProvinciaService provinciaService;
	
	@GetMapping("/{id}")
	@ApiOperation("Buscar provincia por id")
	@ApiResponses({
		@ApiResponse( code = 302, message = "Provincia encontrada com sucesso."),
		@ApiResponse( code = 400, message = "Requisição invalida para obter a provincia.")
	})
	@ResponseStatus(HttpStatus.FOUND)
	public Provincia getProvincia(@PathVariable("id") Integer idProvincia) {
		return this.provinciaService.findById(idProvincia);
	}
	
	@GetMapping
	@ApiResponses({
		@ApiResponse( code = 302, message = "Provincias encontrada com sucesso."),
		@ApiResponse( code = 400, message = "Requisição invalida para obter as provincias."),
	})
	@ResponseStatus(HttpStatus.FOUND)
	public List<Provincia> listarTodas() {
		return this.provinciaService.listarTodas();
	}
	
}
