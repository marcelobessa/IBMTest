package com.ibm.test.imbtest.movies;

import com.fasterxml.jackson.annotation.JsonAlias;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieData {
	@JsonAlias("Title")
	private String title;
	@JsonAlias("Year")
	private int year;
	private String imdbID;

}
