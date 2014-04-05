package bankofjava.domain.investment;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import bankofjava.domain.account.Account;

@Entity
public class InvestmentAction {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private Investment investment;
	private Account account;
	private InvestmentActionType type;
	private BigDecimal amount;
	private Date created;
	private Date deleted;
	
	public InvestmentAction() {}
	
	public InvestmentAction(Investment investment, InvestmentActionType type, BigDecimal amount){
		this.investment = investment;
		this.type = type;
		this.amount = amount;
		this.created = new Date();
	}
	
}
