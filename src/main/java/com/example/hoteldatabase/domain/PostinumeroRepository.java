package com.example.hoteldatabase.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface PostinumeroRepository extends CrudRepository<Postinumero, String>{
	List<Postinumero> findByPostinumero(String postinumero);

}
