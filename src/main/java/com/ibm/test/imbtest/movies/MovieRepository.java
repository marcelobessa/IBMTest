package com.ibm.test.imbtest.movies;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class MovieRepository {
	
	final String uri = "https://jsonmock.hackerrank.com/api/movies/search/?";
	
	public ResponseEntity<MoviesDetails> findMovies(String title){
		RestTemplate restTemplate = new RestTemplate();
		String url = uri+"Title="+title;
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
	     
	    ResponseEntity<MoviesDetails> result = restTemplate.exchange(url, HttpMethod.GET, entity, MoviesDetails.class);
		return result;
	}

	public ResponseEntity<MoviesDetails> findMoviesByPage(String title, int pageNr){
		RestTemplate restTemplate = new RestTemplate();
		String url = uri+"Title="+title+"&page="+pageNr;
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
	     
	    ResponseEntity<MoviesDetails> result = restTemplate.exchange(url, HttpMethod.GET, entity, MoviesDetails.class);
		return result;
	}
}
