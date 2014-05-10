package bankofjava.domain.investment;

import javax.persistence.*;

import bankofjava.domain.account.Account;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="investment")
public class Investment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	//@OneToMany(targetEntity=Account.class, mappedBy="accountid", fetch=FetchType.EAGER)
	@ManyToOne
	@JoinColumn(name="accountid")
	private Account account;
	private int investors;
	private BigDecimal price;
	private Date created;
	
	
	public Investment(){}
	public Investment(Account account){
		this.account = account;
		this.price = new BigDecimal(0);
		this.created = new Date();
	}
}
