package com.example.hoteldatabase.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AsiakasRepository extends CrudRepository<Asiakas, Long>{
	List<Asiakas> findByEtunimi(String etunimi);
//	List<Asiakas> findByAsiakasId(Long asiakasId);
//	List<Asiakas> findByVarausId(Long varausId);

}
