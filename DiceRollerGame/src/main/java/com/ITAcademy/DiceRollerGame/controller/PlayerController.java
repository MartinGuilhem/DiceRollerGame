package com.ITAcademy.DiceRollerGame.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ITAcademy.DiceRollerGame.dto.Player;
import com.ITAcademy.DiceRollerGame.service.PlayerServiceImpl;

@RestController
@RequestMapping("/api")
public class PlayerController {

	// Use of methods from Service
	@Autowired
	PlayerServiceImpl playerServiceImpl;
	
	// Create player
	@PostMapping("/players")
	public Player createPlayer(@RequestBody Player player) {
		return playerServiceImpl.createPlayer(player);
	}

	// Get all players with their winAvg (CHEQUEAR QUE DEVUELVA EL winAvg)
	@GetMapping("/players")
	public List<Player> listPlayers() {
		return playerServiceImpl.listPlayers();
	}
	
	// PUT / players: modifica el nombre del jugador
	// Update player name
	@PutMapping("/players/{id}")
	public Player updatePlayer(@PathVariable(name = "id") Long id, @RequestBody Player player) {
		Player playerToUpdate = playerServiceImpl.getPlayer(id);
		playerToUpdate.setName(player.getName());
		return playerServiceImpl.updatePlayer(playerToUpdate);
	}

	
}
