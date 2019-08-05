package com.ibm.test.imbtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

import com.ibm.test.imbtest.movies.MovieRepository;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EntityScan(basePackages = { "com.ibm.test.imbtest" })
@EnableSwagger2
@ServletComponentScan(basePackages = { "com.ibm.test.imbtest" })
@SpringBootApplication
public class ImbtestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImbtestApplication.class, args);
	}
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
					.select()
					.apis(RequestHandlerSelectors.basePackage("com.ibm.test.imbtest"))
					.paths(PathSelectors.any())
					.build()
					.apiInfo(this.metaData());
	}
	
	private ApiInfo metaData() {
		return new ApiInfoBuilder().title("TEST IBM movies API WS")
				.description("\"Documentação da API Rest para o projeto de teste da IBM\"").build();
	}

	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate;
	}

	@Bean
	public HttpHeaders httpHeaders() {
		HttpHeaders httpHeaders = new HttpHeaders();
		return httpHeaders;
	}
	
	@Bean
	public MovieRepository movieRepository() {
		MovieRepository movieRepository = new MovieRepository();
		return movieRepository;
	}

}
