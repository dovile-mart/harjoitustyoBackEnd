package com.example.hoteldatabase.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TyontekijaRepository extends CrudRepository<Tyontekija, Long>{
	List<Tyontekija> findByTyontekijaId(Long tyontekijaId);
	List<Tyontekija> findByEtunimi(String etunimi);
}
