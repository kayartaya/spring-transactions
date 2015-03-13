package vinod.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import vinod.dao.AccountDao;
import vinod.dao.DaoException;
import vinod.entity.Account;
import vinod.entity.AccountTransaction;
import vinod.service.AccountService;
import vinod.service.ServiceException;

public class DefaultAccountService implements AccountService {

	@Autowired(required = true)
	private AccountDao dao;

	@Override
	public void deposit(Integer id, Double amount) throws ServiceException {
		try {
			Account account = dao.getAccount(id);
			account.setAmount(account.getAmount() + amount);
			dao.updateAccount(account);
			AccountTransaction tr = new AccountTransaction();
			tr.setAccount(account);
			tr.setAmount(amount);
			tr.setDescription("Deposit");
			tr.setTransactionDate(new Date());
			dao.createAccountTransaction(tr);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public void withdraw(Integer id, Double amount) throws ServiceException {
		try {
			Account account = dao.getAccount(id);
			account.setAmount(account.getAmount() - amount);
			dao.updateAccount(account);
			AccountTransaction tr = new AccountTransaction();
			tr.setAccount(account);
			tr.setAmount(amount);
			tr.setDescription("Withdrawal");
			tr.setTransactionDate(new Date());
			dao.createAccountTransaction(tr);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void transferFund(Integer idFrom, Integer idTo, Double amount)
			throws ServiceException {
		try {
			Account ac1 = dao.getAccount(idFrom);
			Account ac2 = dao.getAccount(idTo);

			ac1.setAmount(ac1.getAmount() - amount);
			dao.updateAccount(ac1);

			try {
				AccountTransaction tr1 = new AccountTransaction();
				tr1.setAccount(ac1);
				tr1.setAmount(amount);
				tr1.setDescription("Transfered to " + ac2.toString());
				tr1.setTransactionDate(new Date());
				dao.createAccountTransaction(tr1);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			ac2.setAmount(ac2.getAmount() + amount);
			dao.updateAccount(ac2);

			AccountTransaction tr2 = new AccountTransaction();
			tr2.setAccount(ac2);
			tr2.setAmount(amount);
			tr2.setDescription("Transfered from " + ac1.toString());
			tr2.setTransactionDate(new Date());
			dao.createAccountTransaction(tr2);

		} catch (DaoException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public void createAccount(Integer id, String name, Double amount)
			throws ServiceException {
		try {
			dao.createAccount(id, name, amount);
			Account account = dao.getAccount(id);

			AccountTransaction tr = new AccountTransaction();
			tr.setAccount(account);
			tr.setAmount(amount);
			tr.setDescription("Account opened");
			tr.setTransactionDate(new Date());
			dao.createAccountTransaction(tr);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}

	}

}
