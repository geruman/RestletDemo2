package com.restlet.course.project;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.ValidationException;

public class PlayerService {

    

    private static final List<Player> players = new ArrayList<Player>();    
    static {
    	players.add(new Player("c1e9cbaa-b98a-41ce-8a13-da3da091913c", "TRex"));
        players.add(new Player("5b4a651d-0191-4b71-be62-0f8470637ac6", "Ghost"));
    }

    public List<Player> findAll(){
        return players;
    }
    
    public Player findById(String id) {
        return players.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    
    public Player create(String name) {
        Player player = new Player();
    	player.setId(UUID.randomUUID().toString());
        player.setUsername(name);
        players.add(player);
        return player;
    }

    
    public Player update(Player player) {
        Player existePlayer = this.findById(player.getId());
        if(existePlayer == null) throw new ValidationException("No existe el usuario");
        existePlayer.setUsername(player.getUsername());
        return existePlayer;
    }

    
    public void delete(String id) {
        Player player = this.findById(id);
        if(player == null) throw new ValidationException("No existe el usuario");
        players.remove(player);
    }

}