package bankofjava.integration;

import java.math.BigDecimal;

import org.junit.*;

public class Coin {
	
	private CoinReposioryTest coinRepositoryTest = new CoinReposioryTest();

	@Test
	public void CreateCoins(){
		coinRepositoryTest.session.beginTransaction();
		coinRepositoryTest.deleteAll();
		coinRepositoryTest.session.getTransaction().commit();
		
		BigDecimal numberOfCoins = new BigDecimal(50);
		bankofjava.service.Coin coinService = new bankofjava.service.Coin();
		bankofjava.domain.Coin coin = new bankofjava.domain.Coin(0, "");
		
		coinRepositoryTest.session.beginTransaction();
		coinService.generate(coin, numberOfCoins);
		coinRepositoryTest.session.getTransaction().commit();
		
		
		Assert.assertEquals(numberOfCoins.intValue(), coinRepositoryTest.getCount());
		
		coinRepositoryTest.deleteAll();
		coinRepositoryTest.session.getTransaction().commit();
	}
}
