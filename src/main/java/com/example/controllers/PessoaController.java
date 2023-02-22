package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.PessoaDto;
import com.example.models.Pessoa;
import com.example.services.PessoaService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/pessoas")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	
	@PostMapping
	@ApiOperation("Salvar pessoa com os seus contactos")
	@ApiResponse( code = 200, message = "Pessoa salva com sucesso")
	@ResponseStatus(HttpStatus.CREATED)
	public Pessoa salvar(@RequestBody PessoaDto pessoaDto) {
		log.info("PessoaController - Salvar pessoa");
		return pessoaService.salvar(pessoaDto);
	}
	
}
