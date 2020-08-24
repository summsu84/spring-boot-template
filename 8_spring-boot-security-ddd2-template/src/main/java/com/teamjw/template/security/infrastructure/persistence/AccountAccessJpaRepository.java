package com.teamjw.template.security.infrastructure.persistence;

import com.teamjw.template.security.domain.Account;
import com.teamjw.template.security.domain.AccountAccess;
import com.teamjw.template.security.domain.Amount;
import com.teamjw.template.security.domain.User;
import com.teamjw.template.security.domain.imports.AccountAccessRepository;
import com.teamjw.template.security.infrastructure.persistence.imports.ImportedAccountAccessJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**A Repository for {@link de.beuth.knabe.spring_ddd_bank.domain.AccountAccess} link objects implemented with Spring Data JPA.
 * @author Christoph Knabe
 * @since 2017-03-06
 */
@Service
public class AccountAccessJpaRepository implements AccountAccessRepository {

    private final ImportedAccountAccessJpaRepository impl;

    @Autowired
    public AccountAccessJpaRepository(final ImportedAccountAccessJpaRepository impl) {
        this.impl = impl;
    }

    public void deleteAll(){impl.deleteAll();}

    public AccountAccess save(final AccountAccess accountAccess){
        return impl.save(accountAccess);
    }

    @Override
    public void delete(AccountAccess accountAccess) {
        impl.delete(accountAccess);
    }

    @Override
    public List<AccountAccess> findManagedAccountsOf(User user, boolean asOwner) {
        return null;
    }


    @Override
    public Optional<AccountAccess> find(final User user, final Account account) {
        return impl.findOneByClientAndAccount(user, account);
    }

}
