package bankofjava.infra.database;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import bankofjava.domain.Stock;
import bankofjava.domain.Transaction;
import bankofjava.domain.TransactionType;

public class TransactionRepository extends Repository<Transaction> {


	public TransactionRepository(DatabaseSession session) {
		super(session, Transaction.class);
	}
	
	public Hashtable<Stock, Integer> mostTransactionsToday(TransactionType transactionType){
		List<Object[]> queryData = session.createCriteria(Transaction.class)       
                .add(Restrictions.eq("type", transactionType))      
                .setProjection(Projections.projectionList()
                        .add(Projections.groupProperty("stock"))
                        .add(Projections.count("stock"))           
                ).list();
		
		Hashtable<Stock, Integer> stockCountList = new Hashtable<Stock, Integer>();
		for(Object[] o : queryData){
			stockCountList.put((Stock)o[0], (int)((long)(o[1])));
		}
		
		return stockCountList;
	}
	
}
