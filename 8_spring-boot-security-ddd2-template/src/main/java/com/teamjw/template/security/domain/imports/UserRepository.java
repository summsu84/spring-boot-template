package com.teamjw.template.security.domain.imports;

import com.teamjw.template.security.domain.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Required repository for {@link User} objects.
 * 
 * @author Christoph Knabe
 * @version 2018-10-03
 * @since 2017-03-01
 */
public interface UserRepository {

	/**
	 * Deletes all Users. Useful for test scenarios in order to start with an
	 * empty {@link User} set.
	 */
	void deleteAll();

	/**Saves a user giving it a unique, higher ID
	 * @param user the {@link User} to be saved
	 * 
	 * @return the modified instance1`
	 */
	User save(User user);

	/** Deletes the given user. 
	 * @param user the {@link User} to be deleted*/
	void delete(User user);

	/**Searches the user object by its ID.
	 * @param id the unique ID of the searched user object
	 * @return the {@link User} object with the given id, if existing.
	 * 
	 * 
	 * @throws IllegalArgumentException
	 *             id is null
	 */
	Optional<User> find(Long id);

	/**Searches the user object by username.
	 * @param username the unique username of the searched user
	 * @return  the {@link User} object with the given username, if existing.
	 * @throws IllegalArgumentException
	 *             username is null or empty
	 */
	Optional<User> find(String username);

	/** Finds all {@link User}s. 
	 * @return all users ordered by descending IDs*/
	List<User> findAll();

	/**
	 * Finds all {@link User}s born at the given date or later.
	 * @param minDate the oldest birth date of users
	 * @return the users ordered firstly by their descending birth date, and secondly by descending
	 * IDs.
	 */
	List<User> findAllBornFrom(LocalDate minDate);

}
