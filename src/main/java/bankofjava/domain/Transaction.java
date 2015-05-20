package bankofjava.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.joda.time.DateTime;

@Entity
@Table(name="transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="accountid")
	private Account account;
	@ManyToOne
	@JoinColumn(name="stockid")
	private Stock stock;
	private TransactionType transactionType;
	private int count;
	private float price;
	private DateTime date;
	
	private Transaction(){}
	public Transaction(TransactionType transactionType, Account account,Stock stock, int count, float price){
		this.transactionType = transactionType;
		this.account = account;
		this.stock = stock;
		this.count = count;
		this.price = price;
	}
	
	
	
}
