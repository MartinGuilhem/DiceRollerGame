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
	
//	// PLAYER {ID} ROLLS THE DICES (CREATE GAME)
// 	@PostMapping("/players/{id}/games")
// 	public void rollTheDices(@PathVariable(name ="id") Long id) {
// 		
// 		Player player = playerServiceImpl.getPlayer(id);
// 		
// 		gameServiceImpl.rollDices(player);
// 		 			
// 	}
	
//	// GET GAMES FROM PLAYER
//	@GetMapping("/players/{id}/games")
//	public List<Game> listGames(@PathVariable(name = "id") Player player) {
//		return gameServiceImpl.listGames(player);
//	}
	
//	// DELETE ALL GAMES FROM PLAYER
//	@DeleteMapping("/players/{id}/games")
//	public String deleteGames(@PathVariable(name = "id") Player player) {
//		List<Game> games = player.getGame();
//		for (Game g : games) {
//			Long gameId = g.getId();
//			gameServiceImpl.deleteGame(gameId);
//		}		
//		return "\n Games from" + player.getName() + "have been deleted";
//	}
	
}
