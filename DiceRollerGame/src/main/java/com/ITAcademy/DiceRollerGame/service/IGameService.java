package com.ITAcademy.DiceRollerGame.service;

import java.util.List;

import com.ITAcademy.DiceRollerGame.dto.Game;
import com.ITAcademy.DiceRollerGame.dto.Player;

public interface IGameService {

	// Get games from player
	public List<Game> listGames(Player player);

	// Delete Game
	public void deleteGame(Long gameId);

}
