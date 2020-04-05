package com.moviecatalogservice.models;

public class CatalogItem {
    private String name;
    private int rating;
    private String original_language;

    public CatalogItem(String name, String original_language, int rating) {
        this.name = name;
        this.original_language = original_language;
        this.rating = rating;
    }

    public String getOriginal_language() {
		return original_language;
	}

	public void setOriginal_language(String original_language) {
		this.original_language = original_language;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
