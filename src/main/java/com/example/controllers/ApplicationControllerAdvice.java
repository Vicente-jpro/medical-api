package com.example.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class ApplicationControllerAdvice {

	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErrors produtoNotFoundExceptionHandle(ProdutoNotFoundException ex) {
		this.mensagemErro = ex.getMessage();
		return new ApiErrors(mensagemErro);
	}
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErrors pedidoNotFoundExceptionHandle(PedidoNotFoundException ex) {
		this.mensagemErro = ex.getMessage();
		return new ApiErrors(mensagemErro);
	}
	
	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ApiErrors validateFieldsHandle( MethodArgumentNotValidException ex ) {
		List<String> erros = ex.getBindingResult()
		  .getAllErrors()
		  .stream()
		  .map( erro -> erro.getDefaultMessage()
				).collect( Collectors.toList());
		
		return new ApiErrors(erros);
	}
}
