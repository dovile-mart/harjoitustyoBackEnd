package com.example.hoteldatabase.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface HuonevarausRepository extends CrudRepository<Huonevaraus, Long>{
	List<Huonevaraus> findByHuonevarausId(Long huonevarausId);
//	Optional<Huonevaraus> findByHuonevarausId(Long huonevarausId);
	//List<Huonevaraus> findByVarausId(Varaus varausId);
	//List<Huonevaraus> findByHuoneNro(Huone huoneNro);
}
