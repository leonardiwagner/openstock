package bankofjava.infra.database;

import bankofjava.domain.Transfer;

public class TransferRepository extends Repository<Transfer> {

	public TransferRepository(DatabaseSession session) {
		super(session, Transfer.class);
	}
	
}
