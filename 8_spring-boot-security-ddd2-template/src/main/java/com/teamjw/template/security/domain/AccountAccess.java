package com.teamjw.template.security.domain;

import com.teamjw.template.security.domain.base.EntityBase;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * User와 Account간의 맵핑 오브젝트 (Setter만 존재)
 *
 * @author Christoph Knabe
 */
@Entity
public class AccountAccess extends EntityBase<AccountAccess> {

	@ManyToOne
	private User user;

	private boolean isOwner;

	@ManyToOne
	private Account account;

	/** Necessary for JPA entities internally. */
	@SuppressWarnings("unused")
	private AccountAccess() {
	}

	public AccountAccess(final User client, final boolean isOwner, final Account account) {
		this.user = client;
		this.isOwner = isOwner;
		this.account = account;
	}

	/** Returns the {@link Client} who is managing the {@link Account}.
	 * @return the linked {@link Client} */
	public User getClient() {
		return user;
	}

	/**
	 * Informs if the {@link Client} is the owner of the {@link Account}.
	 * 
	 * @return true if the {@link Client} is the owner of the Account, but false if
	 *         he is only manager of the account.
	 */
	public boolean isOwner() {
		return isOwner;
	}

	/**
	 * Returns the {@link Account} accessible by this object.
	 * 
	 * @return the {@link Account} accessible by this object
	 */
	public Account getAccount() {
		return account;
	}

	@Override
	public String toString() {
		return String.format("%s{client='%s', isOwner='%b', account='%s'}", getClass().getSimpleName(), user, isOwner,
				account);
	}

}
