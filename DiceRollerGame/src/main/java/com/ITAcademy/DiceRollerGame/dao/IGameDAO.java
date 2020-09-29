package com.ITAcademy.DiceRollerGame.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ITAcademy.DiceRollerGame.dto.Game;
import com.ITAcademy.DiceRollerGame.dto.Player;


public interface IGameDAO extends JpaRepository<Game, Long> {

	// List all games from player
	List<Game> findAllByPlayer(Player player);

}
