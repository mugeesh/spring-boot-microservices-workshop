package io.javabrains.movieinfoservice.models;

public class Movie {
    private String movieId;
    private String name;
    private String original_language;
    private long budget;
    

    public Movie(String movieId, String name, String original_language, long budget ) {
        this.movieId = movieId;
        this.name = name;
        this.original_language = original_language;
        this.budget=budget;
    }

    
    public String getOriginal_language() {
		return original_language;
	}


	public void setOriginal_language(String original_language) {
		this.original_language = original_language;
	}


	public long getBudget() {
		return budget;
	}


	public void setBudget(long budget) {
		this.budget = budget;
	}


	public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
