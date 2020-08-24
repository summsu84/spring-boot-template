package com.teamjw.template.security.infrastructure.persistence;

import com.teamjw.template.security.domain.Account;
import com.teamjw.template.security.domain.AccountNo;
import com.teamjw.template.security.domain.imports.AccountRepository;
import com.teamjw.template.security.infrastructure.persistence.imports.ImportedAccountJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**A Repository for Account entities implemented with Spring Data JPA.
 * @author Christoph Knabe
 * @since 2017-03-06
 */
@Service
public class AccountJpaRepository implements AccountRepository {

    private final ImportedAccountJpaRepository impl;

    @Autowired
    public AccountJpaRepository(final ImportedAccountJpaRepository impl) {
        this.impl = impl;
    }
    
	@Override
	public Optional<Account> find(AccountNo acccountNo) {
		return impl.findOneById(acccountNo.toLong());
	}

    public void deleteAll(){impl.deleteAll();}

    public Account save(final Account account){
        return impl.save(account);
    }

}
