package com.teamjw.template.app.place.controller;


import com.teamjw.template.app.place.domain.Place;
import com.teamjw.template.app.place.service.PlaceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlaceController {
	@Value("#{environment['SERVICE_ENDPOINT'] ?: 'localhost:8080'}")
	private String serviceEndpoint;


	@Autowired
    private PlaceService placeService;

	private static final Logger logger = LoggerFactory.getLogger(PlaceController.class);

    /**
     *  Get place list
     * @return
     */
    @RequestMapping(value = "/places", method = RequestMethod.GET)
    public List<Place> getPlaces() {
        return placeService.getPlaces();
    }

    /**
     *  Get place by id
     * @param placeId
     * @return
     */
    @RequestMapping(value = "/places/{id}", method = RequestMethod.GET)
    public Place getPlaceById(@PathVariable(value = "id") Long placeId) {
        return (placeService.getPlaceById(placeId)).get();
    }

    /**
     *  Save place
     * @param place
     * @return
     */
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/places", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Place createPlace(@RequestBody Place place) {
        return placeService.createPlaceAll(place);
    }




}