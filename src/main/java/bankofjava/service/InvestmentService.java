package bankofjava.service;

import java.util.List;

import bankofjava.domain.Account;
import bankofjava.domain.Coin;
import bankofjava.domain.InsufficientFundsException;
import bankofjava.domain.Investment;
import bankofjava.infra.AccountRepository;

public class InvestmentService {
	
	private static int UP_REGISTERED_VALUE = 10;
	private static int UP_ANONYMOUS_VALUE = 1;
	private static int DOWN_REGISTERED_VALUE = 10;
	private static int DOWN_ANONYMOUS_VALUE = 1;
	
	private final Investment investment;
	
	public InvestmentService(Investment investment){
		this.investment = investment;
	}
	
	public void up(){
		
	}

	public void up(Account account) throws InsufficientFundsException{
		AccountRepository accountRepository = new AccountRepository();
		List<Coin> withdrawList = account.withdrawCoin(UP_REGISTERED_VALUE);

	}
	
	

}
