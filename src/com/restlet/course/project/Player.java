package com.restlet.course.project;
public class Player {

    
    private String id;
    private String username;

    public Player() {
    	
    }
    public Player(String id, String userName) {
    	this.id = id;
    	this.username = userName;
    }
    
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
    

}