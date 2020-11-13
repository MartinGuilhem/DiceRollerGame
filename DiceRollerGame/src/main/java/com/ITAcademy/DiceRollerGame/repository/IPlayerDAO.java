package com.ITAcademy.DiceRollerGame.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ITAcademy.DiceRollerGame.dto.Player;

@Repository
public interface IPlayerDAO extends JpaRepository<Player, Long>{
		
}
