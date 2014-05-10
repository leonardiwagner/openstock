package bankofjava.integration;

import org.junit.Before;
import org.junit.Test;

import bankofjava.domain.*;
import bankofjava.domain.account.*;
import bankofjava.domain.investment.Investment;
import bankofjava.infra.*;
import junit.*;

public class InvestmentTest extends TestHelper {

	private Database database;
	private Account account;
	
	@Before
	public void testInitialize()
	{
		this.database = new Database();
	}
	
	@Test
	public void createInvestment(){
		Investment investment = new Investment(super.createTestAccount());
		InvestmentRepository investmentRepository = new InvestmentRepository(this.database);
		
		investmentRepository.save(investment);
	}
}
