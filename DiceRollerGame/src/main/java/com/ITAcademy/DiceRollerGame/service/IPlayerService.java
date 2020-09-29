package com.ITAcademy.DiceRollerGame.service;

import java.util.List;

import com.ITAcademy.DiceRollerGame.dto.Player;

public interface IPlayerService {

	// CRUD METHODS

	// Create player
	public Player createPlayer(Player player);

	// Get all players
	public List<Player> listPlayers();

	// Get Player by id
	public Player getPlayer(Long id);

	// Update Player
	Player updatePlayer(Player player);

	
}
