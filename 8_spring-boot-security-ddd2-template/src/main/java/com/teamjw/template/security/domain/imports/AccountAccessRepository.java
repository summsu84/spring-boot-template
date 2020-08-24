package com.teamjw.template.security.domain.imports;


import com.teamjw.template.security.domain.Account;
import com.teamjw.template.security.domain.AccountAccess;
import com.teamjw.template.security.domain.Amount;
import com.teamjw.template.security.domain.User;

import java.util.List;
import java.util.Optional;

/**
 * AccountAccess Repository
 * 
 */
public interface AccountAccessRepository {

	/**
	 * 모든 AccountAccess 오브젝트들을 삭제
	 */
	void deleteAll();


	/**
	 * AccountAccess 저장 (User와 Account 미리 저장되어야 함)
	 * @param accountAccess
	 * @return
	 */
	AccountAccess save(AccountAccess accountAccess);

	/**
	 * Deletes the given {@link AccountAccess} object.
	 * 
	 * @param accountAccess
	 *            the AccountAccess object to be deleted
	 */
	void delete(AccountAccess accountAccess);


	List<AccountAccess> findManagedAccountsOf(User user, boolean asOwner);


	List<AccountAccess> findFullAccounts(final Amount minBalance);

	/**
	 *  적절한 Account에 대한 사용자의 Access 권한 체크
	 * @param user : 사용자
	 * @param account : 사용자가 사용하는 Account
	 * @return
	 */
	Optional<AccountAccess> find(User user, Account account);

}
