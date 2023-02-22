package com.example.exceptions;

public class PessoaNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PessoaNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
