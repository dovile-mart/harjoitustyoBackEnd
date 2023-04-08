package com.example.hoteldatabase.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface HuoneRepository extends CrudRepository<Huone, String>{
	List<Huone> findByHuoneNro(String huoneNro);
	List<Huone> findByHuoneNro(Huone hinta);
}
