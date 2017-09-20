package com.tyfone.springdatasolr.enums;

public enum Genre {

	IT("IT"), FANTASY("fantasy");
	
	private final String type;
	
	private Genre(String type){
		this.type= type;
	}
	
	
	public String getType() {
	    return type;
	}

	public static Genre fromValue(String type){
	      for(Genre genre:values()){
	        if(genre.getType().equals(type)){
	         return genre;
	        }
	      }
	        return null;
	}
	      
	public static Genre getGenreType(String genreName){
	    for(Genre genre:values()){
	        if(genre.name().equals(genreName)){
	            return genre;
	        }
	    } return null;
	}
	
}
