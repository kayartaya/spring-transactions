package vinod.service;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import vinod.dao.DaoException;


public interface AccountService {
	
	public void deposit(Integer id, Double amount) throws ServiceException;

	@Transactional(rollbackFor=ServiceException.class)
	public void withdraw(Integer id, Double amount) throws ServiceException;

	
	public void transferFund(Integer idFrom, Integer idTo, Double amount)
			throws ServiceException;

	@Transactional
	public void createAccount(Integer id, String name, Double amount)
			throws ServiceException;

}
