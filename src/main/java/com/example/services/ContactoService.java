package com.example.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Contacto;
import com.example.repository.ContactoRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ContactoService {

	@Autowired
	private ContactoRepository contactoRepository;
	
	public Contacto salvar(Contacto contacto) {
		return this.contactoRepository.save(contacto);
	}

	@Transactional
	public void salvarTodos(List<Contacto> listaContacto) {
		log.info("Salvando os contactos da pessoa.");
		
		this.contactoRepository.saveAll(listaContacto);
		
		log.info("Fim da operação salvar");
	}
	
	public List<Contacto> getPessoaAndContactos(Integer idPessoa){
		return this.contactoRepository.findByPessoaIdFetchContacts(idPessoa);
	}
}
