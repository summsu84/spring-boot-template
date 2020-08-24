package com.teamjw.template.security.domain.imports;


import com.teamjw.template.security.domain.Account;
import com.teamjw.template.security.domain.AccountNo;

import java.util.Optional;

/**
 * Account Object Repository
 */
public interface AccountRepository {

	/**
	 * Searches the {@link Account} object with the given account number.
	 * 
	 * @param acccountNo
	 *            unique account number of the searched account
	 * @return the {@link Account} object with the given account number, if existing.
	 * @throws IllegalArgumentException
	 *             acccountNo is null or empty
	 */
	Optional<Account> find(AccountNo acccountNo);

	/**
	 * Deletes all Accounts. Useful for test scenarios in order to start with an
	 * empty account set.
	 */
	void deleteAll();

	/**
	 * Saves the account giving it a unique, higher account number (accountNo).
	 * 
	 * @param account
	 *            the {@link Account} to be saved
	 * @return the modified instance
	 */
	Account save(Account account);

}
