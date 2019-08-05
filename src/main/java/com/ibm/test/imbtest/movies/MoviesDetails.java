package com.ibm.test.imbtest.movies;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MoviesDetails {
	private int page;
	private int per_page;
	private int total;
	private int total_pages;
	private List<MovieData> data;
	
}
