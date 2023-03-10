package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.PessoaDto;
import com.example.models.Pessoa;
import com.example.services.PessoaService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	
	@PostMapping
	@ApiOperation("Salvar pessoa com os seus contactos.")
	@ApiResponse( code = 200, message = "Pessoa salva com sucesso.")
	@ResponseStatus(HttpStatus.CREATED)
	public PessoaDto salvar(@RequestBody PessoaDto pessoaDto) {
		log.info("PessoaController - Salvar pessoa.");
		return pessoaService.salvar(pessoaDto);
	}
	
	
	@PatchMapping
	@ApiOperation("Atualizar pessoa.")
	@ApiResponse( code = 200, message = "Pessoa atualizado com sucesso.")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Pessoa update(@RequestBody Pessoa pessoa) {
		log.info("PessoaController - atualizar pessoa.");
		return pessoaService.update(pessoa);
	}
	
	@GetMapping("/{id}")
	@ApiOperation("Buscar pessoa pelo id.")
	@ApiResponses( {
			@ApiResponse( code = 302, message = "Pessoa encontrada."),
			@ApiResponse( code = 404, message = "Pessoa não encontrada.")
			})
	@ResponseStatus(HttpStatus.FOUND)
	public Pessoa getPessoa(@PathVariable("id") Integer idPessoa) {
		log.info("PessoaController - pesquisar pessoa com id: "+idPessoa);
		return this.pessoaService.getPessoa(idPessoa);
	}

	
	@GetMapping("/{id_pessoa}/contactos")
	@ApiOperation("Buscar pessoa com os seus contactos.")
	@ApiResponses({
		@ApiResponse( code = 302, message = "Pessoa encontrada"),
		@ApiResponse( code = 404, message = "Passoa não encontrada")
	})
	@ResponseStatus(HttpStatus.FOUND)
	public PessoaDto getPessoaComContactos(@PathVariable("id_pessoa") Integer idPessoa) {
		log.info("PessoaController - pesquisar pessoa com os seus contactos id: "+idPessoa);
		return this.pessoaService.findByPessoaIdFetchContacts(idPessoa);
	}
	
}
