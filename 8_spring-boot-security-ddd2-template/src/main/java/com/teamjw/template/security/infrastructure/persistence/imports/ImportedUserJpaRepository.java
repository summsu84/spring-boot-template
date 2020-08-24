package com.teamjw.template.security.infrastructure.persistence.imports;

import com.teamjw.template.security.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**Required Spring JPA repository for users. The methods are named according to the Spring Data JPA convention.
 * They can be implemented by Spring during bean creation, but can be implemented independently of Spring, too.
 * @author Christoph Knabe
 * @since 2017-03-03
 * @see <a href="https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation">Spring Data Query Methods</a>
 */
public interface ImportedUserJpaRepository extends JpaRepository<User, Long> {

    /**Deletes all Users. Useful for test scenarios in order to start with an empty user set*/
    void deleteAll();

    User save(User user);

    void delete(User user);
    
    Optional<User> findOneById(Long id);
    
    Optional<User> findOneByUsername(String username);
    
    Optional<User> findOneByUsernameAndBirthDate(String name, LocalDate birthDate);

    List<User> findAllByOrderByIdDesc();

    List<User> findAllByBirthDateGreaterThanEqualOrderByBirthDateDescIdDesc(LocalDate minDate);

    Optional<User> findFirstByOrderByIdAsc();
}
