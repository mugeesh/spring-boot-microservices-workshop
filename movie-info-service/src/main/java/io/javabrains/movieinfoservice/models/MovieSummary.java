package io.javabrains.movieinfoservice.models;

public class MovieSummary {

    private String id;
    private String title;
    private String original_language;
    private long budget;
    
    
    public String toString() {
		return id+", title="+title+", "+original_language+", "+budget;
    	
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

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
