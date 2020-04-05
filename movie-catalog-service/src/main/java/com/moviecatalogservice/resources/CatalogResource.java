package com.moviecatalogservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
//import org.springframework.web.reactive.function.client.WebClient;

import com.moviecatalogservice.models.CatalogItem;
import com.moviecatalogservice.models.Movie;
import com.moviecatalogservice.models.Rating;
import com.moviecatalogservice.models.UserRating;
import com.moviecatalogservice.services.MovieInfo;
import com.moviecatalogservice.services.RatingsInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class CatalogResource {

    //@Autowired
    //private RestTemplate restTemplate;

    //@Autowired
    //WebClient.Builder webClientBuilder;

    @Autowired
    MovieInfo movieInfo;
    
    @Autowired
    RatingsInfo ratingsInfo;
    
    
    @RequestMapping("/{userId}")
    //@HystrixCommand(fallbackMethod = "getFallbackCatalog")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

		UserRating userRating = ratingsInfo.getRatings(userId);

		List<CatalogItem> list = userRating.getRatings().stream()
				.map(rating -> {
						CatalogItem catalogItem = movieInfo.getCatalogItem(rating);
						return catalogItem;
				}).collect(Collectors.toList());

		return list;
	}

	
    /*
    public List<CatalogItem> getFallbackCatalog(@PathVariable("userId") String userId) {
        return Arrays.asList(new CatalogItem("No Moview", "", 0));
    	
    } */

    
    //test method only
	@GetMapping("/fault-tolerance-example")
	// configuring a fallback method
	@HystrixCommand(fallbackMethod = "fallbackRetrieveConfigurations")
	public CatalogItem retrieveConfigurations() {
		throw new RuntimeException("Not Available");
		//return new CatalogItem("No Moview--33", "", 0);
	}

	// defining the fallback method
	public CatalogItem fallbackRetrieveConfigurations() {
		return new CatalogItem("No Moview22", "", 0);
	}
}

/*
Alternative WebClient way
Movie movie = webClientBuilder.build().get().uri("http://localhost:8082/movies/"+ rating.getMovieId())
.retrieve().bodyToMono(Movie.class).block();
*/