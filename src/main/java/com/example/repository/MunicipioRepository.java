package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.models.Municipio;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio, Integer>{
	
	
	@Query( value = "SELECT * "
			+ "	FROM municipios "
			+ "	where provincia_id = :idProvincia ",
			
			nativeQuery = true
		)
	List<Municipio> findByIdProvincia(@Param("idProvincia") Integer idProvincia);

}
