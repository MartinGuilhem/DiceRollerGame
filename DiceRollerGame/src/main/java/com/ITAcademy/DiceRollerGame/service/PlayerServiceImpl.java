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
	
	// Create player
	@Override
	public Player createPlayer(Player player) {
		return iPlayerDAO.save(player);
	}

	// Get all players with their winAvg
	@Override
	public List<Player> listPlayers() {
		return iPlayerDAO.findAll();
	}
	
	// Get player by id
	@Override
	public Player getPlayer(Long id) {
		return iPlayerDAO.findById(id).get();
	}
	
	// Update player
	@Override
	public Player updatePlayer(Player player) {
		return iPlayerDAO.save(player);
	}
	
	



}
