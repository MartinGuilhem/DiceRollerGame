package com.ITAcademy.DiceRollerGame.controller;

import com.ITAcademy.DiceRollerGame.service.GameServiceImpl;
import com.ITAcademy.DiceRollerGame.service.PlayerServiceImpl;
import com.ITAcademy.DiceRollerGame.dto.Game;
import com.ITAcademy.DiceRollerGame.dto.Player;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api")
public class GameController {
	
	// Use of methods from Service
	@Autowired
	GameServiceImpl gameServiceImpl;
	@Autowired
	PlayerServiceImpl playerServiceImpl;

	
	// PLAYER {ID} ROLLS THE DICES (CREATE GAME)
 	@PostMapping("/players/{id}/games")
 	public Game rollTheDices(@PathVariable(name ="id") Long id) {
 		Player player = playerServiceImpl.getPlayer(id);
 		Long gameId=gameServiceImpl.rollDices(player);
 		return gameServiceImpl.getGameById(gameId);	 		
 	}
	 	
	// GET GAMES FROM PLAYER
	@GetMapping("/players/{id}/games")
	public ResponseEntity<Object> listGames(@PathVariable(name = "id") Player player) {
		HashMap<String, Object> map = new HashMap<>();		
		try {
			map.put("Games", gameServiceImpl.listGames(player));
		}catch(Exception e) {
			map.put("Success", false);
			map.put("Players", e.getMessage());			
		}		
		return ResponseEntity.ok().body(map);
	}
	
	// DELETE ALL GAMES FROM PLAYER
	@DeleteMapping("/players/{id}/games")
	public String deleteGames(@PathVariable(name = "id") Player player) {
		List<Game> games = player.getGame();
		for (Game g : games) {
			Long gameId = g.getId();
			gameServiceImpl.deleteGame(gameId);
		}
		player.setWinAvg(0.00);
		playerServiceImpl.updatePlayer(player);			
		return "\n Games from " + player.getName() + " have been deleted";
	}
	
}
