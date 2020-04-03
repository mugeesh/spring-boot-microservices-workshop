package io.javabrains.movieinfoservice.resources;

import io.javabrains.movieinfoservice.models.Movie;
import io.javabrains.movieinfoservice.models.MovieSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movies")
public class MovieResource {

    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
    	String URLs="https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" +  apiKey;
    	System.out.println(URLs);
        MovieSummary movieSummary = restTemplate.getForObject(URLs, MovieSummary.class);
        
        System.out.print(movieSummary);  
        return new Movie(movieId, movieSummary.getTitle(), movieSummary.getOriginal_language(),movieSummary.getBudget());

    }
    //597
    //https://api.themoviedb.org/3/movie/550?api_key=c3d95b014f453457d789e6cf61508351

}
