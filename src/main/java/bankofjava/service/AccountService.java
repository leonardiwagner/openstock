package bankofjava.service;

import bankofjava.domain.Account;

public class AccountService implements IAccountService {

	@Override
	public Account getAccount(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account getAccount(String email, String password) {
		return new Account("Renato Loyola", "renatinho@vidgal.com","123");
	}

}
