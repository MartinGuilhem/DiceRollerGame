package com.ITAcademy.DiceRollerGame.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ITAcademy.DiceRollerGame.dto.Game;
import com.ITAcademy.DiceRollerGame.dto.Player;
import com.ITAcademy.DiceRollerGame.service.GameServiceImpl;
import com.ITAcademy.DiceRollerGame.service.PlayerServiceImpl;

@RestController
@RequestMapping("/api")
public class PlayerController {

	// Use of methods from Service
	@Autowired
	PlayerServiceImpl playerServiceImpl;
	@Autowired
	GameServiceImpl gameServiceImpl;
	
	// CREATE PLAYER
	@PostMapping("/players")
	public Player createPlayer(@RequestBody Player player) {
		
		player.setWinAvg(0.00);
		int i=playerServiceImpl.listPlayers().size()+1;
		player.setId(Long.valueOf(i));
		return playerServiceImpl.createPlayer(player);
	}

	// GET ALL PLAYERS WITH THEIR WINAVG
	@GetMapping("/players")
	public List<Player> listPlayers() {
		return playerServiceImpl.listPlayers();
	}
	
	// UPDATE PLAYER NAME
	@PutMapping("/players/{id}")
	public Player updatePlayer(@PathVariable(name = "id") Long id, @RequestBody Player player) {
		Player playerToUpdate = playerServiceImpl.getPlayer(id);
		playerToUpdate.setName(player.getName());
		return playerServiceImpl.updatePlayer(playerToUpdate);
	}
	
	// GET AVERAGE RANKING
	@GetMapping("/players/ranking")
	public String getRanking() {
		
		double ranking=0.00;
		List<Player> players = new ArrayList<Player>();
		players=this.listPlayers();
		ranking=playerServiceImpl.getRanking(players);
		
		return "The total Average Ranking of All Players is: "+ranking;
	}
	
	// Delete player by id
	@DeleteMapping("/players/{id}")
	public void deletePlayer(@PathVariable(name = "id") Player player) {
		Long id=player.getId();
		List<Game> games = player.getGame();
		for (Game g : games) {
			Long gameId = g.getId();
			gameServiceImpl.deleteGame(gameId);
		}
		playerServiceImpl.deletePlayer(id);
	}
	
	// Delete all players
	@DeleteMapping("/players/delete")
	public void deletePlayers() {
		gameServiceImpl.deleteGames();
		playerServiceImpl.deletePlayers();
	}
	
}
