package bankofjava.service;

import java.util.ArrayList;
import java.util.List;
import bankofjava.infra.*;
import bankofjava.domain.*;

public class CoinService {
	private final AccountRepository accountRepository;
	private final CoinRepository coinRepository;
	
	public CoinService(){
		
		Database database = new Database();
		this.accountRepository = new bankofjava.infra.AccountRepository();
		this.coinRepository = new CoinRepository();
	}
	
	public List<Coin> generateCoin(Account account, String ip, int ammount){
		List<Coin> coinList = new ArrayList<Coin>();
		for(int i = 0; i < ammount; i++){
			coinList.add(coinRepository.save(new Coin(account, ip)));
		}
		
		return coinList;
	}
	
}
