package bankofjava.service;

import java.math.BigDecimal;

import bankofjava.infra.CoinRepository;



public class Coin {

	public void generate(bankofjava.domain.Coin coin, BigDecimal amount){
		CoinRepository repository = new CoinRepository();
		for(int i = 0; i < amount.intValue(); i++){
			repository.insert(coin);;
		}
	}
}
