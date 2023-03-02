package com.example.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.exceptions.ProvinciaNotFoundException;
import com.example.models.Provincia;
import com.example.repository.ProvinciaRepository;

@Service
public class ProvinciaService {

	private ProvinciaRepository provinciaRepository;
	
	public List<Provincia> listarTodas() {
		return this.provinciaRepository.findAll();
	}
	
	public Provincia findById(Integer idProvincia) {
		return this.provinciaRepository
				.findById(idProvincia)
				.orElseThrow( () -> new ProvinciaNotFoundException("Código da provincia invalido. id: "+idProvincia));
	}
	
}
