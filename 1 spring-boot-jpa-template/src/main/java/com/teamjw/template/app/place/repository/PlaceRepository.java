package com.teamjw.template.app.place.repository;

import com.teamjw.template.app.place.domain.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *  Place Repository
 */
@Repository
public interface PlaceRepository extends JpaRepository<Place, Long> {

}
