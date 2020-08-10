package com.teamjw.template.app.place.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.*;

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

	public Place() {
	}

	public Place(String name, String country, Long population) {
		this.name = name;
		this.country = country;
		this.population = population;
	}
}
