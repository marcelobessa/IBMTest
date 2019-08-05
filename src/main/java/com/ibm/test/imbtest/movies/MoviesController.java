package com.ibm.test.imbtest.movies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/movies")
public class MoviesController {
	
	@Autowired
	private MoviesService service;
	
	@ApiOperation(value = "Retorna a lista de filmes por título.", produces = MediaType.APPLICATION_JSON_VALUE)
	@GetMapping(value = "/{title}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code=HttpStatus.OK)
	public List<String> showMovies(final @PathVariable("title") String title){
		
		return service.getTitleList(title);
	}
}
