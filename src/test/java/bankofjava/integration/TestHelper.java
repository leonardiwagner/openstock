package bankofjava.integration;

import java.util.List;
import bankofjava.domain.Account;
import bankofjava.domain.Coin;
import bankofjava.domain.Investment;
import bankofjava.infra.AccountRepository;
import bankofjava.infra.Database;
import bankofjava.infra.InvestmentRepository;
import bankofjava.service.CoinService;

public abstract class TestHelper {
	
	public Account createTestAccount(){
		Account account = new Account("User Test Coin","test.coin@bankofjava.com","123");
		AccountRepository accountRepository = new AccountRepository();
		accountRepository.save(account);
		
		return account;
	}
	
	public Investment createTestInvestment(Account account){
		Investment investment = new Investment(account);
		InvestmentRepository investmentRepository = new InvestmentRepository();
		investmentRepository.save(investment);
		
		return investment;
	}
	
	public List<Coin> generateCoins(Account account, int ammount){
		CoinService coinService = new CoinService();
		return coinService.generateCoin(account, "192.0.0.1", ammount);
	}
}
