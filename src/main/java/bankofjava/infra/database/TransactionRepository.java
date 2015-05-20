package bankofjava.infra.database;

import bankofjava.domain.Transaction;

public class TransactionRepository extends Repository<Transaction> {


	public TransactionRepository(DatabaseSession session) {
		super(session, Transaction.class);
	}
	
}
