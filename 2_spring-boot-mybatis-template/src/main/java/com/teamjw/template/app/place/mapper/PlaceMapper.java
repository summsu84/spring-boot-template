package com.teamjw.template.app.place.mapper;


import com.teamjw.template.app.place.domain.Place;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface PlaceMapper {

  List<Place> selectPlaceList();


}