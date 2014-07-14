package bankofjava.integration;

import org.junit.Before;
import org.junit.Test;
import bankofjava.domain.*;
import bankofjava.infra.*;

public class InvestmentTest extends TestHelper {

	//@Test
	public void createInvestment(){
		Investment investment = new Investment(super.createTestAccount());
		InvestmentRepository investmentRepository = new InvestmentRepository();
		investmentRepository.save(investment);
	}
	
	//@Test
	public void invest(){
		Investment investment = new Investment(super.createTestAccount());
		InvestmentRepository investmentRepository = new InvestmentRepository();
		investmentRepository.save(investment);
		
		investment.addInvestor(super.createTestAccount());
		investmentRepository.save(investment);
	}
	
	//@Test
	public void upInvestment(){
		AccountRepository accountRepository = new AccountRepository();
		InvestmentRepository investmentRepository = new InvestmentRepository();
		
		Account investmentCreator = super.createTestAccount();
		Investment investment = super.createTestInvestment(investmentCreator);
		investmentRepository.save(investment);
		
		Account invester = super.createTestAccount();
		invester.depositCoin(super.generateCoins(invester, 30));
		accountRepository.save(invester);
		
	}
}
