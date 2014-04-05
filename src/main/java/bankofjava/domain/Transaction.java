package bankofjava.domain;

import javax.persistence.*;

import bankofjava.domain.account.Account;

import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private Account accountFrom;
	private Account accountTo;
	private BigDecimal amount;
	private Date created;
	
	public Transaction(){}
	public Transaction(Account from, Account to, BigDecimal amount){
		this.accountFrom = from;
		this.accountTo = to;
		this.amount = amount;
		this.created = new Date();
	}
}
