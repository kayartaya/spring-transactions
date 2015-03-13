package vinod.entity;

import java.util.HashSet;
import java.util.Set;

public class Account {
	private Integer id;
	private String name;
	private Double amount;

	private Set<AccountTransaction> transactions = new HashSet<AccountTransaction>();

	public Account() {
	}

	public Account(Integer id, String name, Double amount) {
		this.id = id;
		this.name = name;
		this.amount = amount;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Set<AccountTransaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<AccountTransaction> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + "]";
	}

}
