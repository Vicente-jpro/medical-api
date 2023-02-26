package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Contacto;
import com.example.services.ContactoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/api/contactos")
public class ContactoController {

	@Autowired
	private ContactoService contactoService;
	
	@PostMapping
	@ApiOperation("Salvar contactos")
	@ApiResponse( code = 200, message = "Contacto salvo com sucesso.")
	@ResponseStatus(HttpStatus.CREATED)
	public Contacto salvar(@RequestBody Contacto contacto) {
		log.info("ContactoController - Salvar");
		return this.contactoService.salvar(contacto);
	}
	
	
	@PatchMapping
	@ApiOperation("Atualizar contactos.")
	@ApiResponse( code = 200, message = "Contacto atualizado com sucesso.")
	@ResponseStatus(HttpStatus.CREATED)
	public Contacto update(@RequestBody Contacto contacto) {
		return this.contactoService.salvar(contacto);
	}
	
}
