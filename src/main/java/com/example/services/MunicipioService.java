package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Municipio;
import com.example.models.Provincia;
import com.example.repository.MunicipioRepository;

@Service
public class MunicipioService {

	@Autowired
	private MunicipioRepository muniRepository;
	
	@Autowired
	private ProvinciaService provinciaService;
	
	public List<Municipio> getMunicipiosProvincia(Integer idProvincia){
		Provincia provincia = this.provinciaService.findById(idProvincia);
		return this.muniRepository.findByIdProvincia(provincia.getIdProvincia());
	}
	
}
