package com.teamjw.template.app.place.domain;

import lombok.Data;
import org.apache.ibatis.type.Alias;


/**
 * 
 * @author teamjw - JJW
 */

@Data
@Alias("place")
public class Place  {

	private Long id;
	private String name;
	private String country;
	private Long population;

}
