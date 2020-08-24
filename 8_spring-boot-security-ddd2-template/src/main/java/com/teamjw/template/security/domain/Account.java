package com.teamjw.template.security.domain;


import com.teamjw.template.security.domain.base.EntityBase;

import javax.persistence.Entity;

/**
 * An account, which a client of a bank can manage. This entity is an Anemic
 * Domain Object, as it only has stupid setters.
 *
 * Account (User가 관리)
 * 빈약한 도메인 오브젝트 (setter만 가지고 있음)
 *
 */
@Entity
public class Account extends EntityBase<Account> {

	private String name;
	private Amount balance = new Amount(0);

	/** Necessary for JPA entities internally. */
	@SuppressWarnings("unused")
	private Account() {
	}

	public Account(final String name) {
		this.name = name;
	}
	
	public AccountNo accountNo() {
		return new AccountNo(getId());
	}

	@Override
	public String toString() {
		return String.format("Account{accountNo=%d, name='%s', balance='%s'}", accountNo(), name, balance);
	}

	public String getName() {
		return name;
	}

	public Amount getBalance() {
		return balance;
	}

	void setBalance(final Amount amount) {
		this.balance = amount;
	}

	/**
	 * Returns the minimum balance for the application.
	 * 
	 * @return The minimum balance, which must stay on each account.
	 */
	public static final Amount getMinimumBalance() {
		return new Amount(-1000, 0);
	}

}
