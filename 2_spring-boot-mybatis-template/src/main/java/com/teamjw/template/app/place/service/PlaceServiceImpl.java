package com.teamjw.template.app.place.service;

import com.teamjw.template.app.place.mapper.PlaceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.teamjw.template.app.place.domain.*;

import java.util.List;

@Service("placeService")
public class PlaceServiceImpl implements PlaceService{
/*
    @Autowired
    private PlaceMapper placeMapper;*/

    /**
     *  get place list
     * @return
     */
    public List<Place> getPlaces() {
        // return placeMapper.selectPlaceList();
        return null;

    }


}
