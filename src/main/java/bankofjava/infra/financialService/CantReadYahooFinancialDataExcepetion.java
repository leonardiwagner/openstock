package bankofjava.infra.financialService;

public class CantReadYahooFinancialDataExcepetion extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5299348826094713879L;
	
	public Exception originalException;
	
	public CantReadYahooFinancialDataExcepetion(Exception originalException){
		this.originalException = originalException;
	}

}
