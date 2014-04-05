package bankofjava.domain;

import javax.persistence.*;

import bankofjava.domain.account.Account;

import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Loan {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private Account account;
	private BigDecimal amount;
	private BigDecimal tax;
	private Date created;
	private Date settled;
	
	public Loan(){}
	public Loan(Account account, BigDecimal amount, BigDecimal tax){
		this.account = account;
		this.amount = amount;
		this.tax = tax;
		this.created = new Date();
	}
}
