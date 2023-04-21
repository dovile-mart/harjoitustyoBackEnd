package com.example.hoteldatabase.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface HuonevarausRepository extends CrudRepository<Huonevaraus, Long>{
	List<Huonevaraus> findByHuonevarausId(Long huonevarausId);
//	List<Huonevaraus> findByHuoneNro(Huone huoneNro);
//	Optional<Huonevaraus> findByHuonevarausId(Long huonevarausId);
//  List<Huonevaraus> findByVarausId(Varaus varausId);
//	List<Huonevaraus> findByHuoneNro(Huone huoneNro);
	List<Huonevaraus> findByHuone(Huone huone);
	List<Huonevaraus> findByVaraus(Varaus varaus);
}
