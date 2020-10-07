package com.ITAcademy.DiceRollerGame.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ITAcademy.DiceRollerGame.dao.IPlayerDAO;
import com.ITAcademy.DiceRollerGame.dto.Player;

@Service
public class PlayerServiceImpl implements IPlayerService {
	
	// Use of methods from repository DAO
	@Autowired
	IPlayerDAO iPlayerDAO;
	
	// CREATE PLAYER
	@Override
	public Player createPlayer(Player player) {
		return iPlayerDAO.save(player);
	}

	// GET ALL PLAYERS WITH THEIR WINAVG
	@Override
	public List<Player> listPlayers() {
		return iPlayerDAO.findAll();
	}
	
	// GET PLAYER BY ID
	@Override
	public Player getPlayer(Long id) {
		return iPlayerDAO.findById(id).get();
	}
	
	// UPDATE PLAYER
	@Override
	public Player updatePlayer(Player player) {
		return iPlayerDAO.save(player);
	}
	
	// GET TOTAL RANKING OF ALL PLAYERS
	public Double getRanking(List<Player> players) {
		double ranking=0.00;
		double sumRanking=0.00;
		
		System.out.println("\n\n\n####"+players.get(1).toString()+"\n\n\n");

		for (int i=1;i<players.size();i++) {
			ranking=players.get(i).getWinAvg();
			System.out.println("\n\n\n####"+ranking+"\n\n\n");
			sumRanking = sumRanking + ranking;
		}
		return sumRanking / (double) players.size();
	}

	// GET PLAYER WITH LOWEST RANKING
	public Player Loser() {
		List<Player> players = this.listPlayers();
		Long id = null;
		int i = 0;
		double min = 100.00;

		for (i = 0; i < players.size(); i++) {
			if (players.get(i).getWinAvg() < min) {
				min = players.get(i).getWinAvg();
				id = players.get(i).getId();
			}
		}
		System.out.println("Mínimo: " + min); // SOUT test
		return this.getPlayer(id);
	}

	// GET PLAYER WITH LOWEST RANKING
	public Player Winner() {
		List<Player> players = this.listPlayers();
		Long id = null;
		int i = 0;
		double max = 0.00;

		for (i = 0; i < players.size(); i++) {
			if (players.get(i).getWinAvg() > max) {
				max = players.get(i).getWinAvg();
				id = players.get(i).getId();
			}
		}
		System.out.println("Maximo: " + max); // SOUT test
		return this.getPlayer(id);
	}

	// DELETE PLAYER BY ID
	public void deletePlayer(Long id) {
		iPlayerDAO.deleteById(id);
	}	
	
	// DELETE ALL PLAYERS
	public void deletePlayers() {
		iPlayerDAO.deleteAll();
	}

}
