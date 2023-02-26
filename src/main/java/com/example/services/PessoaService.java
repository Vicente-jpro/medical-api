package com.example.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.ContactoDto;
import com.example.dto.PessoaDto;
import com.example.exceptions.PessoaNotFoundException;
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
	public PessoaDto salvar(PessoaDto pessoaDto) {
		log.info("Salvando a pessoa...");
		
		Pessoa pessoa = new Pessoa();
		pessoa.setIdPessoa( pessoaDto.getIdPessoa());;
		pessoa.setBi( pessoaDto.getBi() );
		pessoa.setNome( pessoaDto.getNome());
	
		List<Contacto> listaContacto = this.converterListaContacto(pessoa, pessoaDto.getContactos());
		pessoaRepository.save(pessoa);
		contactoService.salvarTodos(listaContacto);
		pessoa.setContactos(listaContacto);
		
		PessoaDto psDto = converterPessoaParaDto(pessoa);
		
		return psDto;
		
	}
	

	public PessoaDto findByPessoaIdFetchContacts(Integer idPessoa){
		Pessoa pessoa = this.getPessoa(idPessoa);
		return PessoaDto
				.builder()
				.idPessoa( pessoa.getIdPessoa() )
				.nome( pessoa.getNome())
				.bi(pessoa.getBi())
				.contactos( converterListaContacto( pessoa.getContactos()))
				.build();
	}
	
	public List<Contacto> converterListaContacto(Pessoa pessoa, List<ContactoDto> listaContactoDto){
		log.info("Obtendo os contactos do da listaContactoDto...");
		
		return listaContactoDto
				.stream()
				.map( dto ->{
					Contacto contacto = new Contacto();
					contacto.setIdContacto( dto.getIdContacto() );
					contacto.setEmail( dto.getEmail() );
					contacto.setTelemovel(dto.getTelemovel());
					contacto.setWhatsapp( dto.getWhatsapp() );
					contacto.setPessoa( pessoa );
					
					log.info("Fim da obtenção dos contactos.");
					return contacto;
					}).collect(Collectors.toList() );
	}
	
	public PessoaDto converterPessoaParaDto(Pessoa pessoa) {
		return PessoaDto
				.builder()
				.idPessoa( pessoa.getIdPessoa())
				.nome( pessoa.getNome())
				.bi(pessoa.getBi())
				.contactos( converterListaContacto(pessoa.getContactos()) )
				.build();

	}
	public List<ContactoDto> converterListaContacto(List<Contacto> listaContacto){

		
		return listaContacto
				.stream()
				.map( contacto -> {
					
					return ContactoDto
							.builder()
							.idContacto(contacto.getIdContacto())
							.telemovel( contacto.getTelemovel()	)
							.whatsapp(contacto.getWhatsapp())	
							.email(contacto.getEmail())
							.build();
					
				}).collect(Collectors.toList() );
	}
	

	
	public Pessoa getPessoa(Integer idPessoa) {
		return this.pessoaRepository
				.findById(idPessoa)
				.orElseThrow( () -> new PessoaNotFoundException("Id invalido . Pessoa não encontada. id: "+idPessoa));
		
	}
	
}
