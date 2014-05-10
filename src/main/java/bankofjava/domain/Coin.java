package bankofjava.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="coin")
public class Coin {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="accountid")
	private Account account;
	private String ip;
	private Date created;
	//private Date deleted;
	
	private Coin() {}
	
	public Coin(Account account, String ip){
		this.account = account;
		this.ip = ip;
		this.created = new Date();
	}
	

}
