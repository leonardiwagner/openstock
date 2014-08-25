package bankofjava.service;

import bankofjava.domain.Account;

public interface IAccountService {
	public Account getAccount(int id);
	public Account getAccount(String email, String password);
}
