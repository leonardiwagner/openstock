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
	private TransactionType type;
	private int count;
	private float price;
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	private DateTime date;
	
	private Transaction(){}
	public Transaction(TransactionType transactionType, Account account,Stock stock, int count){
		this.type = transactionType;
		this.account = account;
		this.stock = stock;
		this.count = count;
		this.price = stock.getCurrentValue();
		this.date = new DateTime();
	}
	
	public Stock getStock(){
		return this.stock;
	}
	public Account getAccount(){
		return this.account;
	}
	public TransactionType getType(){
		return this.type;
	}
	public int getCount(){
		return this.count;
	}
	public float getPrice(){
		return this.price;
	}

	
	
	
}
