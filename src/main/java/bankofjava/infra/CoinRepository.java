package bankofjava.infra;

import org.hibernate.Query;

import bankofjava.domain.Coin;

public class CoinRepository extends Repository<Coin> {

	public long getCount(){
		Query query = session.createQuery("from Coin");
		return query.list().size();
	}
}
