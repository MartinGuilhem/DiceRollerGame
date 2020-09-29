package com.ITAcademy.DiceRollerGame.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "game")
public class Game {

	// ATTRIBUTES
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@Column
	int dice_1;
	@Column
	int dice_2;
	@Column
	boolean won;
	
	// Entities relationship
	@ManyToOne()
	@JoinColumn(name = "player_id")
	private Player player;
	
	// CONSTRUCTORS
	public Game() {}

	public Game(Long id, int dice_1, int dice_2, boolean won, Player player) {
		this.id = id;
		this.dice_1 = dice_1;
		this.dice_2 = dice_2;
		this.won = won;
		this.player = player;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getDice_1() {
		return dice_1;
	}

	public void setDice_1(int dice_1) {
		this.dice_1 = dice_1;
	}

	public int getDice_2() {
		return dice_2;
	}

	public void setDice_2(int dice_2) {
		this.dice_2 = dice_2;
	}

	public boolean isWon() {
		return won;
	}

	public void setWon(boolean won) {
		this.won = won;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", dice_1=" + dice_1 + ", dice_2=" + dice_2 + ", Win or Not=" + won + ", player=" + player
				+ "]";
	}

	

}
