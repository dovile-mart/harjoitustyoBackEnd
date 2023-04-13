package com.example.hoteldatabase.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface VarausRepository extends CrudRepository<Varaus, Long>{
List<Varaus> findByVarausId(Long varausId);
//List<Varaus> findByHuoneNro(Huonevaraus huoneNro);
//List<Varaus> findByHuonevarausId(Huonevaraus huonevarausId);
//List<Varaus> findByHuonevarausId(Huonevaraus huonevarausId);
//List<Varaus> findByAsiakasId(Long asiakasId);
//List<Varaus> findByTyontekijaId(Long tyontekijaId);
List<Varaus> findByAsiakasAndTyontekija(Asiakas asiakas, Tyontekija tyontekija);
List<Varaus> findByAsiakas(Asiakas asiakas);
//List<Varaus> findByHuoneNro(Huone huoneNro);
//List<Varaus> findByHuonevaraus(Huonevaraus huonevaraus);
}
