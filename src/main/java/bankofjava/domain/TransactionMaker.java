package bankofjava.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import bankofjava.infra.database.AccountRepository;
import bankofjava.infra.database.TransactionRepository;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;


public class TransactionMaker {
	
	private final TransactionRepository transactionRepository;
	private final AccountRepository accountRepository;
	public TransactionMaker(TransactionRepository transactionRepository, AccountRepository accountRepository){
		this.transactionRepository = transactionRepository;
		this.accountRepository = accountRepository;
	}
	
	public void transact(Transaction transaction){
		float transactionPrice = transaction.getCount() * transaction.getPrice();
		if(transaction.getType() == TransactionType.Sell){
			transactionPrice *= -1;
		}
		float newAccountBallance = transaction.getAccount().getBalance() - transactionPrice;
		transaction.getAccount().setBalance(newAccountBallance);
		
		accountRepository.save(transaction.getAccount(), true);
		transactionRepository.save(transaction, true);
	}
	
	
	
}
