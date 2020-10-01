package com.ITAcademy.DiceRollerGame.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "player")
public class Player {
	
	// ATTRIBUTES
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@Column(columnDefinition = "varchar(255) default 'Anonymous'")
	String name;
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	Date date = new Date(System.currentTimeMillis());
	@Column
	Double winAvg;

	// Entities relationship
	@OneToMany(mappedBy = "player")
	@JsonIgnore // To fix issue with infinite recursion
	private List<Game> game;

		
	// CONSTRUCTORS
	public Player() {}

	public Player(Long id, String name) {
		this.id = id;
		this.name = addName(name);
		this.date = new Date(System.currentTimeMillis());
	}
	
	
	//GETTERS & SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = addName(name);
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public Double getWinAvg() {
		return winAvg;
	}

	public void setWinAvg(Double winAvg) {
		this.winAvg = winAvg;
	}

	public List<Game> getGame() {
	return game;
	}

	public void setGame(List<Game> game) {
	this.game = game;
	}
	
	// METHODS
	
	// Set author as Anonymous if name is null
	private String addName(String name) {
		if (name == null) {
			name = "Anonymous";
		}
		return name;
	}	

//	// ROLL THE DICES: bring a player nd sets its game
//	public void rollDices(Player player) {
//		int dice1=(int) (Math.random()*7); 
//		int dice2=(int) (Math.random()*7); 
//		boolean won=won(dice1, dice2);
//		
//		Game game = new Game();
//		game.setDice1(dice1);
//		game.setDice2(dice2);
//		game.setWon(won);
//		game.toString();
//		
//		this.game.add(game);
//		
//		System.out.println(game.toString());
//	}
//	
//	// WIN OR NOT?: returns boolean 
//	public boolean won(int dice1, int dice2) {
//		if(dice1+dice2==7) {
//			System.out.println("You Win!");
//			return true;}
//		else {
//			System.out.println("You Loose!");	
//			return false;}
//	}
	
//	// SETTING WINAVG FROM GAME 
//	public void winAvGames() {
//		int gamesWon=0;
//		for(Game g: game)
//		{
//			if(g.isWon()) {
//				gamesWon++;
//			}
//		}
//		this.setWinAvg((double) gamesWon / (double) game.size());
//	}

	@Override
	public String toString() {
		return "Player [id=" + id + ", name= " + name + ", winAvg=" + winAvg
				+ ", entry date=" + date + "  ]";
	}

}
