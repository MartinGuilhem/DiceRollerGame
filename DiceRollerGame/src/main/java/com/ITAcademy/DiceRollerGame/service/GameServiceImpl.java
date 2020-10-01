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

	// Create Game
	public Game addGame(Game game) {
		return iGameDAO.save(game);
	}
		
	// Get games from player
	public List<Game> listGames(Player player) {
		return iGameDAO.findAllByPlayer(player);
	}

	// Delete Game
	public void deleteGame(Long gameId) {
		iGameDAO.deleteById(gameId);
	}
	


////	 Roll the dices
//	public void rollDices(Player player) {
//		
//		int dice1=(int) (Math.random()*7	); 
//		int dice2=(int) (Math.random()*7); 
//		
//		boolean won=won(dice1, dice2);
//		
//		Game game = new Game();
//		game.setDice1(dice1);
//		game.setDice2(dice2);
//		game.setWon(won);
//		game.toString();
//		
//	}
//	
//	// return boolean for win or not (won) 
//	public boolean won(int dice1, int dice2) {
//		if(dice1+dice2==7) {
//			System.out.println("You Win!");
//			return true;}
//		else {
//			System.out.println("You Loose!");	
//			return false;}
//	}
//	
}
