package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Contacto;
import com.example.services.ContactoService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/contactos")
public class ContactoController {

	@Autowired
	private ContactoService contactoService;
	
	@ApiOperation("Salvar contactos")
	@ApiResponse( code = 200, message = "Constacto salvo com sucesso")
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public Contacto salvar(@PathVariable Contacto contacto) {
		return this.contactoService.salvar(contacto);
	}
}
