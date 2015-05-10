package bankofjava.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="transfer")
public class Transfer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="accountid_from")
	private Account accountFrom;
	@ManyToOne
	@JoinColumn(name="accountid_to")
	private Account accountTo;
	private float amount;
	private Date created;
	
	private Transfer(){}
	public Transfer(Account from, Account to, float ammount){
		this.accountFrom = from;
		this.accountTo = to;
		this.amount = ammount;
		this.created = new Date();
	}
	
	
	
}
