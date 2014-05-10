package bankofjava.infra;

import bankofjava.domain.investment.Investment;

public class InvestmentRepository extends Repository<Investment> {
	public InvestmentRepository(Database database) {
		super(database);
	}
}
