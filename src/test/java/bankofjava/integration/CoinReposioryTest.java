package bankofjava.integration;

public class CoinReposioryTest extends bankofjava.infra.CoinRepository {

	public void deleteAll(){
		//session.beginTransaction();
		session.createQuery("delete from Coin").executeUpdate();
		//session.getTransaction().commit();
	}
}
