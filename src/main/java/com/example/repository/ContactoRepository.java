package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.models.Contacto;


@Repository
public interface ContactoRepository extends JpaRepository<Contacto, Integer>{
	
	@Query( value ="SELECT * "
			+ "	FROM public.pessoas "
			+ "	Left JOIN contactos "
			+ "	ON contactos.pessoa_id = pessoas.id "
			+ " WHERE pessoas.id = :id_pessoa", 
			nativeQuery = true)
	List<Contacto> findByPessoaIdFetchContacts(@Param("id_pessoa") Integer idPessoa);

}
