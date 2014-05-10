package bankofjava.service;

import java.util.List;
import bankofjava.domain.Account;
import bankofjava.domain.Coin;
import bankofjava.domain.InsufficientFundsException;
import bankofjava.domain.Transfer;
import bankofjava.infra.AccountRepository;
import bankofjava.infra.TransferRepository;

public class TransactionService {
	
	public Transfer transfer(Account from, Account to, int ammount) throws InsufficientFundsException{
		List<Coin> transferCoin = from.withdrawCoin(ammount);
		to.depositCoin(transferCoin);
		
		AccountRepository accountRepository = new AccountRepository();
		accountRepository.save(from);
		accountRepository.save(to);
		
		TransferRepository transferRepository = new TransferRepository();
		Transfer transfer = new Transfer(from, to, ammount);
		transferRepository.save(transfer);
		
		return transfer;
	}
}
