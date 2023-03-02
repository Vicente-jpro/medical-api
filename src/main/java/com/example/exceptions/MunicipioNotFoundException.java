package com.example.exceptions;

public class MunicipioNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public MunicipioNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
