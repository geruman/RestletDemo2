package com.restlet.course.project;

import java.util.List;

import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

import com.google.gson.Gson;

public class PlayerCrudController extends ServerResource{
	Gson jsonParser;
	public PlayerCrudController () {
		jsonParser = new Gson();
	}
    private PlayerService playerService = new PlayerService();  

    
    
    @Get("application/json")
    public List<Player> findAll(){
        return playerService.findAll();         
    }
    
    @Post("application/json")
    public Player create(String jsonData) {
    	Player p = jsonParser.fromJson(jsonData, Player.class);
        return playerService.create(p.getUsername());
    }

    
    @Put("application/json")
    public Player update(String jsonData) {
        Player player = jsonParser.fromJson(jsonData, Player.class);
        return playerService.update(player);
    }

    
    @Delete        
    public void remove(String jsonData) {
        Player player = jsonParser.fromJson(jsonData, Player.class);
        playerService.delete(player.getId());
    }

}
