package bankofjava.domain.investment;

import javax.persistence.*;

import bankofjava.domain.Account;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	@ManyToMany
	@JoinTable(	name = "account_investment", 
				joinColumns = {
								@JoinColumn(name = "accountid") },
								inverseJoinColumns = {@JoinColumn(name = "investmentid")
								})
	private List<Account> investors;
	private BigDecimal price;
	private Date created;
	
	
	public Investment(){}
	public Investment(Account account){
		this.account = account;
		this.price = new BigDecimal(0);
		this.created = new Date();
		this.investors = new ArrayList<Account>();
	}
	
	public void addInvestor(Account account){
		this.investors.add(account);
	}
}
