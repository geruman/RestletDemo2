package com.restlet.course.project;

import java.util.List;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import com.google.gson.Gson;

public class SearchOnePlayerController extends ServerResource{
	Gson jsonParser;
	public SearchOnePlayerController() {
		jsonParser = new Gson();
	}
    private PlayerService playerService = new PlayerService();  


    
    @Get("application/json")
    public Player find() {
    	String id = getAttribute("id");
    	return playerService.findById(id);
    }
    

}