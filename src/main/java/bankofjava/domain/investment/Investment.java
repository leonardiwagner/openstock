package bankofjava.domain.investment;

import javax.persistence.*;

import bankofjava.domain.account.Account;

import java.math.BigDecimal;
import java.util.Date;

@Entity
public abstract class Investment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private Account account;
	private BigDecimal index;
	private Date created;
	
	public Investment(){}
	public Investment(Account account){
		this.account = account;
		this.index = new BigDecimal(0);
		this.created = new Date();
	}
}
