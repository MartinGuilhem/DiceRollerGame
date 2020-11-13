package com.ITAcademy.DiceRollerGame.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ITAcademy.DiceRollerGame.dto.Game;
import com.ITAcademy.DiceRollerGame.dto.Player;

@Repository
public interface IGameDAO extends JpaRepository<Game, Long> {

	// List all games from player
	List<Game> findAllByPlayer(Player player);

}
