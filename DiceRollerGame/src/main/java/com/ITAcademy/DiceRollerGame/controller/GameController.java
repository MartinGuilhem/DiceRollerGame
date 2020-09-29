package com.ITAcademy.DiceRollerGame.controller;

import com.ITAcademy.DiceRollerGame.service.GameServiceImpl;
import com.ITAcademy.DiceRollerGame.dto.Game;
import com.ITAcademy.DiceRollerGame.dto.Player;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




import java.util.List;

@RestController
@RequestMapping("/api")
public class GameController {
	
	// Use of methods from Service
	@Autowired
	GameServiceImpl gameServiceImpl;
	
	// Get games from player
	@GetMapping("/players/{id}/games")
	public List<Game> listGames(@PathVariable(name = "id") Player player) {
		return gameServiceImpl.listGames(player);
	}
	
	// Delete all games from player
	@DeleteMapping("/players/{id}/games")
	public void deleteGames(@PathVariable(name = "id") Player player) {
		List<Game> games = player.getGames();
		for (Game g : games) {
			Long gameId = g.getId();
			gameServiceImpl.deleteGame(gameId);
		}		
	}
	
	
}
