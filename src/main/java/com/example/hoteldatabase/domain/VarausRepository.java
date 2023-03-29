package com.example.hoteldatabase.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface VarausRepository extends CrudRepository<Varaus, Long>{
List<Varaus> findByVarausId(Long varausId);
}
