package com.example.hoteldatabase;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.hoteldatabase.domain.Huone;
import com.example.hoteldatabase.domain.HuoneRepository;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@DataJpaTest
public class HuoneRepositoryTest {
	@Autowired
	private HuoneRepository huoneRepo;
	
	
	//etsi kaikki huoneet H2-kannasta
	@Test
	public void etsiKaikkiHuoneetH2() {
		Iterable<Huone> huoneet = huoneRepo.findAll();
		assertThat(huoneet).hasSize(3);
	}
	

	//luo uusi huone
	@Test
	public void luoHuone() {
		Huone huone = huoneRepo.save(new Huone("222","Huoneen 222 kuvaus",155, true));
		assertThat(huone).hasFieldOrPropertyWithValue("huoneNro", "222");
		assertThat(huone).hasFieldOrPropertyWithValue("huoneKuvaus", "Huoneen 222 kuvaus");
		assertThat(huone).hasFieldOrPropertyWithValue("hinta", 155);
		assertThat(huone).hasFieldOrPropertyWithValue("onkoVapaa", true);
	}
	

	//etsi huone numerolla 101
	@Test
	public void etsiHuone() {
		Huone huoneet = huoneRepo.findByHuoneNro("101").get(0);
		assertThat(huoneet).isNotNull();
	}
	
	
	//etsi huoneet joiden hinta on 111€ 
	@Test
	public void etsiKaikkiHuoneet() {
		Huone huone1 = huoneRepo.save(new Huone("111","Hieno huone 111",111, false));
		Huone huone2 = huoneRepo.save(new Huone("222","Hieno huone 222",222, false));
		Huone huone3 = huoneRepo.save(new Huone("333","Hieno huone 333",111, true));
		List<Huone> huoneet = huoneRepo.findByHinta(111);
		assertThat(huoneet).hasSize(2).contains(huone1, huone3);
	}
	
	//etsi varatut huoneet (onkoVapaa = false)
	@Test
	public void etsiVaratutHuoneet() {
		Huone huone1 = huoneRepo.save(new Huone("111","Hieno huone 111",111, false));
		Huone huone2 = huoneRepo.save(new Huone("222","Hieno huone 222",222, false));
		Huone huone3 = huoneRepo.save(new Huone("333","Hieno huone 333",111, true));
		List<Huone> huoneet = huoneRepo.findByOnkoVapaa(false);
		assertThat(huoneet).hasSize(2).contains(huone1, huone2);
	}
	
	
	//poista huoneen tietokannasta
	@Test
	public void poistaHuone() {
		Huone huone = huoneRepo.save(new Huone("222","Hieno huone 222",222, false));
		huoneRepo.delete(huone);
		assertThat(huoneRepo.findByHuoneNro("222").isEmpty());
	}
	
	
}
