package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Municipio;
import com.example.services.MunicipioService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/api/municipios")
public class MunicipioController {

	@Autowired
	private MunicipioService municipioService;
	
	// /api/municipios/1/provincia
	
	@GetMapping("/{id_provincia}/provincia")
	@ApiOperation("Buscar municipios por provincia.")
	@ApiResponses({
		@ApiResponse( code = 302, message = "Provincia encontrada com sucesso."),
		@ApiResponse( code = 500, message = "Requisição invalida.")
	})
	@ResponseStatus(HttpStatus.FOUND)
	public List<Municipio> getMunicipiosProvincia(@PathVariable("id_provincia") Integer idProvincia) {
		log.info("MunicipioController - buscando municipios por provincia.");
		return this.municipioService.getMunicipiosProvincia(idProvincia);
	}
	
	
}
