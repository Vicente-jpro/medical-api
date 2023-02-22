package com.example.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/")
@Log4j2
public class HomeController {
	
	@GetMapping( value = "/", produces = "application/json" )
	@ApiOperation("Obter detalhes de um cliente.")
	@ApiResponses({
		@ApiResponse(code = 200, message = "Cliente encontrado"),
		@ApiResponse(code = 404, message = "Cliente não encontrado para o Id informado")
	})
	public String hello() {
		log.info("THIS IS A HOME CONTROLLER");
		return "Hello from home controller";
	}
}
