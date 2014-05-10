package bankofjava.domain;

public class InsufficientFundsException extends Exception {
	public InsufficientFundsException(){
		super("Insufficient Funds");
	}
}
