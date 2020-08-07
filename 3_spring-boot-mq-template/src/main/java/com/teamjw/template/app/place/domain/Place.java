package com.teamjw.template.app.place.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.*;

/**
 * 
 * @author teamjw - JJW
 */

@Entity
@Table(name = "trip_tbl_place")
@Getter
@Setter
@ToString
public class Place extends BaseEntity {

	@Column(name = "place_cd", length=8, unique=true, nullable = false)
	@NotEmpty
	private String placeCd;

	@Column(name = "place_korean_name", length = 255, nullable = false)
	@NotEmpty
	private String placeKoreanName;

	@Column(name = "place_english_name", length=255)
	private String placeEnglishName;
}
