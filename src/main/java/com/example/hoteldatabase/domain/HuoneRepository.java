package com.example.hoteldatabase.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface HuoneRepository extends CrudRepository<Huone, Long>{
	List<Huone> findByHuoneNro(String huoneNro);
	List<Huone> findByHinta(int hinta);
	List<Huone> findByOnkoVapaa(boolean onkoVapaa); //In addition, this class provides many methods forconverting a boolean to a String and a String to a boolean, as well as otherconstants and methods useful when dealing with a boolean. 
}
