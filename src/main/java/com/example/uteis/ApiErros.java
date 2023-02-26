package com.example.uteis;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;

public class ApiErros {
	
	@Getter
	private List<String> listaErros;
	

	public ApiErros(String listaErros) {
		this.listaErros = Arrays.asList(listaErros);
	}
	
	public ApiErros(List<String> listaErros) {
		this.listaErros = listaErros;
	}
}
