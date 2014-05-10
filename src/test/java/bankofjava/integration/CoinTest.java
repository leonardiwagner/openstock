package bankofjava.integration;

import java.math.BigDecimal;
import java.util.List;

import bankofjava.domain.*;
import bankofjava.infra.*;
import bankofjava.service.CoinService;

import org.junit.*;

public class CoinTest extends TestHelper{
	
	@Test
	public void generateCoin(){
		CoinRepository coinRepository = new CoinRepository();
		
		Coin coin = new Coin(super.createTestAccount(), "192.0.0.1");
		coinRepository.save(coin);
	}
	
	@Test
	public void generateManyCoins(){
		CoinService coinService = new CoinService();
		List<Coin> generatedCoinList = coinService.generateCoin(super.createTestAccount(), "192.0.0.1", 20);
		
		Assert.assertEquals(20, generatedCoinList.size());
	}
}
