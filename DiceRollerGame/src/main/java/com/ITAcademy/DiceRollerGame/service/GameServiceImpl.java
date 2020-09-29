package com.ITAcademy.DiceRollerGame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ITAcademy.DiceRollerGame.dao.IGameDAO;
import com.ITAcademy.DiceRollerGame.dto.Game;
import com.ITAcademy.DiceRollerGame.dto.Player;

@Service
public class GameServiceImpl implements IGameService {

	// Use of methods from repository DAO
	@Autowired
	IGameDAO iGameDAO;

	
	// Get games from player
	public List<Game> listGames(Player player) {
		return iGameDAO.findAllByPlayer(player);
	}

	// Delete Game
	public void deleteGame(Long gameId) {
		iGameDAO.deleteById(gameId);
	}


}
