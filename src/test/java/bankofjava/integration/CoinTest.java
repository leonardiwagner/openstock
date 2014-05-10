package bankofjava.integration;

import java.math.BigDecimal;

import bankofjava.domain.*;
import bankofjava.domain.account.*;
import bankofjava.infra.*;

import org.junit.*;

public class CoinTest extends TestHelper{
	
	private Database database;
	
	@Before
	public void testInitialize()
	{
		this.database = new Database();
	}
	
	@Test
	public void testCreateCoin(){
		CoinRepository coinRepository = new CoinRepository(this.database);
		
		Coin coin = new Coin(super.createTestAccount(), "192.0.0.1");
		coinRepository.save(coin);
	}
}
