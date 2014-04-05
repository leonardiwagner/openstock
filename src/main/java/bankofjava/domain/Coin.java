package bankofjava.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Coin {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int accountId;
	private String ip;
	private Date created;
	private Date deleted;
	
	private Coin() {}
	
	public Coin(int accountId, String ip){
		this.accountId = accountId;
		this.ip = ip;
		this.created = new Date();
	}
	

}
