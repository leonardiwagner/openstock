package bankofjava.integration;

import org.junit.Before;
import org.junit.Test;
import bankofjava.domain.*;
import bankofjava.infra.*;

public class InvestmentTest extends TestHelper {

	@Test
	public void createInvestment(){
		Investment investment = new Investment(super.createTestAccount());
		InvestmentRepository investmentRepository = new InvestmentRepository();
		investmentRepository.save(investment);
	}
	
	@Test
	public void invest(){
		Investment investment = new Investment(super.createTestAccount());
		InvestmentRepository investmentRepository = new InvestmentRepository();
		investmentRepository.save(investment);
		
		investment.addInvestor(super.createTestAccount());
		investmentRepository.save(investment);
	}
	
	@Test
	public void upInvestment(){
		/*
		Investment investment = super.createTestInvestment(super.createTestAccount());
		Account voterAccount = super.createTestAccount();
		investment.up(voterAccount, )
		*/
	}
}
