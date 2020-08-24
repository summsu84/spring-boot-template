package com.teamjw.template.security.infrastructure.persistence.imports;

import com.teamjw.template.security.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**Required repository for accounts. The methods are named according to the Spring Data JPA convention.
 * They can be implemented by Spring during bean creation, but can be implemented independently of Spring, too.
 * @author Christoph Knabe
 * @since 2017-03-03
 * @see <a href="https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation">Spring Data Query Methods</a>
 */
public interface ImportedAccountJpaRepository extends JpaRepository<Account, Long> {

    void deleteAll();

    Optional<Account> findOneById(Long id);
    
    Account save(Account account);

    List<Account> findAllByOrderByIdAsc();

    /*
    Iterable<Client> findAllBornFrom(LocalDate minDate);

    Optional<Client> findFirstByOrderByIdAsc();
    */
}
