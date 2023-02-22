package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Contacto;
import com.example.repository.ContactoRepository;

@Service
public class ContactoService {

	@Autowired
	private ContactoRepository contactoRepository;
	
	public Contacto salvar(Contacto contacto) {
		return this.contactoRepository.save(contacto);
	}
	
}
