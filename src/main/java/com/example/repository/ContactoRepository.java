package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.models.Contacto;


@Repository
public interface ContactoRepository extends JpaRepository<Contacto, Integer>{
//	
//	@Query( value ="SELECT * "
//			+ "	FROM public.pessoas "
//			+ "	Left JOIN contactos "
//			+ "	ON contactos.pessoa_id = pessoas.id "
//			+ " WHERE pessoas.id = :id_pessoa", 
//			nativeQuery = true)
//	List<Contacto> findByPessoaIdFetchContacts(@Param("id_pessoa") Integer idPessoa);

}
