package com.ibm.test.imbtest.movies;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MoviesService {
	
	@Autowired
	private MovieRepository repo ;
	List<String> movies = null;
	
	
	public List<String> getTitleList(String title) {
		ResponseEntity<MoviesDetails> findMovies = repo.findMovies(title);
		loadListReturn(title, findMovies.getBody().getTotal_pages());
		Collections.sort(movies);
		return movies;
	}
	
	public void loadListReturn(String title, int totalPages) {
		int counter = 1;
		
		movies =  new ArrayList<String>();
		
		while(counter <= totalPages) {
			ResponseEntity<MoviesDetails> findMovies = repo.findMoviesByPage(title, counter);
			for(int i =0;i < findMovies.getBody().getData().size(); i ++ ) {
				movies.add(findMovies.getBody().getData().get(i).getTitle());
			}
			counter ++;
		}
	}
}
