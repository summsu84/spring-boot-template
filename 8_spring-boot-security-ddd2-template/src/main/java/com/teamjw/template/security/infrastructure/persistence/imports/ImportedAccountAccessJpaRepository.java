package com.teamjw.template.security.infrastructure.persistence.imports;

import com.teamjw.template.security.domain.Account;
import com.teamjw.template.security.domain.AccountAccess;
import com.teamjw.template.security.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Required repository for
 * {@link de.beuth.knabe.spring_ddd_bank.domain.AccountAccess} objects. The
 * methods are named according to the Spring Data JPA convention. They can be
 * implemented by Spring during bean creation, but can be implemented
 * independently of Spring, too.
 * 
 * @author Christoph Knabe
 * @since 2017-03-06
 * @see <a href=
 *      "https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation">Spring
 *      Data Query Methods</a>
 */
public interface ImportedAccountAccessJpaRepository extends JpaRepository<AccountAccess, Long> {

	void deleteAll();

	AccountAccess save(AccountAccess account);

	void delete(AccountAccess account);

	Optional<AccountAccess> findOneByClientAndAccount(User user, Account account);

	//Optional<AccountAccess> findOneByClientAndAccount(Client client, Long accountId);

}
