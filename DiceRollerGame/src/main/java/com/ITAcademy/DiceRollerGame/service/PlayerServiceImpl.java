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

}
