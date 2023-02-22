package com.example.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.ContactoDto;
import com.example.dto.PessoaDto;
import com.example.models.Contacto;
import com.example.models.Pessoa;
import com.example.repository.PessoaRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private ContactoService contactoService;
	
	@Transactional
	public Pessoa salvar(PessoaDto pessoaDto) {
		log.info("Salvando a pessoa...");
		
		Pessoa pessoa = new Pessoa();
		pessoa.setBi( pessoaDto.getBi() );
		pessoa.setNome( pessoaDto.getNome());
	
		List<Contacto> listaContacto = this.converterContacto(pessoaDto.getContactos());
		pessoaRepository.save(pessoa);
		contactoService.salvarTodos(listaContacto);
		pessoa.setContactos(listaContacto);
		
		return pessoa;
		
	}
	
	
	public List<Contacto> converterContacto(List<ContactoDto> listaContactoDto){
		log.info("Obtendo os contactos do da listaContactoDto...");
		
		return listaContactoDto
				.stream()
				.map( dto ->{
					Contacto contacto = new Contacto();
					contacto.setEmail( dto.getEmail() );
					contacto.setTelemovel(dto.getTelemovel());
					contacto.setWhatsapp( dto.getWhatsapp() );
					
					log.info("Fim da obtenção dos contactos.");
					return contacto;
					}).collect(Collectors.toList() );
	}
}
