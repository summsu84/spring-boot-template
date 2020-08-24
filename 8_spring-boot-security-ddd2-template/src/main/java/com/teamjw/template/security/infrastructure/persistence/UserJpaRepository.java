package com.teamjw.template.security.infrastructure.persistence;

import com.teamjw.template.security.domain.User;
import com.teamjw.template.security.domain.imports.UserRepository;
import com.teamjw.template.security.infrastructure.persistence.imports.ImportedUserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**A Repository for Client entities implemented with Spring Data JPA.
 * @author Christoph Knabe
 * @since 2017-03-06
 */
@Service
public class UserJpaRepository implements UserRepository {

    private final ImportedUserJpaRepository impl;

    @Autowired
    public UserJpaRepository(final ImportedUserJpaRepository impl) {
        this.impl = impl;
    }

    public void deleteAll(){impl.deleteAll();}

    public User save(final User client){
        return impl.save(client);
    }

    public void delete(User client){
        impl.delete(client);
    }

	@Override
	public Optional<User> find(Long id) {
		return impl.findOneById(id);
	}

	@Override
	public Optional<User> find(String username) {
		return impl.findOneByUsername(username);
	}

    public List<User> findAll(){
        return impl.findAllByOrderByIdDesc();
    }

    public List<User> findAllBornFrom(final LocalDate minDate){
        return impl.findAllByBirthDateGreaterThanEqualOrderByBirthDateDescIdDesc(minDate);
    }

}
