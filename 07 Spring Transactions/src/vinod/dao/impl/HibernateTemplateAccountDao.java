package vinod.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;

import vinod.dao.AccountDao;
import vinod.dao.DaoException;
import vinod.entity.Account;
import vinod.entity.AccountTransaction;

public class HibernateTemplateAccountDao implements AccountDao {

	@Autowired
	private HibernateTemplate template;

	@Override
	public Account getAccount(Integer id) throws DaoException {
		try {
			return template.get(Account.class, id);
		} catch (DataAccessException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public void updateAccount(Account account) throws DaoException {
		try {
			template.update(account);
			template.evict(account);
		} catch (DataAccessException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public void createAccount(Integer id, String name, Double amount)
			throws DaoException {
		try {
			Account ac = new Account(id, name, amount);
			template.save(ac);
		} catch (DataAccessException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public void createAccount(Account account) throws DaoException {
		try {
			template.save(account);
		} catch (DataAccessException e) {
			throw new DaoException(e);
		}
	}

	@Override
	public void createAccountTransaction(AccountTransaction transaction)
			throws DaoException {

		try {
			template.save(transaction);

		} catch (DataAccessException e) {
			throw new DaoException(e);
		}
	}

}
