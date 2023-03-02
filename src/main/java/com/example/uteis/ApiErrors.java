package com.example.uteis;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;

public class ApiErrors {
	
	@Getter
	private List<String> listaErros;
	

	public ApiErrors(String listaErros) {
		this.listaErros = Arrays.asList(listaErros);
	}
	
	public ApiErrors(List<String> listaErros) {
		this.listaErros = listaErros;
	}
}
