package vinod.dao;

import vinod.entity.Account;
import vinod.entity.AccountTransaction;

public interface AccountDao {

	public Account getAccount(Integer id) throws DaoException;

	public void updateAccount(Account account) throws DaoException;

	public void createAccount(Integer id, String name, Double amount)
			throws DaoException;

	public void createAccount(Account account) throws DaoException;

	public void createAccountTransaction(AccountTransaction transaction)
			throws DaoException;

}
