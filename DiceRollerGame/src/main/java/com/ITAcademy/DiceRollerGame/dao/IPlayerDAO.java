package com.ITAcademy.DiceRollerGame.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ITAcademy.DiceRollerGame.dto.Player;

public interface IPlayerDAO extends JpaRepository<Player, Long>{
		
}
