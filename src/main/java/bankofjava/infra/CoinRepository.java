package bankofjava.infra;

import java.util.List;

import bankofjava.domain.Coin;

public class CoinRepository extends Repository<Coin>{

	public CoinRepository(Database database) {
		super(database);
	}
	
	

}
