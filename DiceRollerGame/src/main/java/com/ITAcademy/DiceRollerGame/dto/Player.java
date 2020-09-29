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
	Date date;
	@Column
	Double winAvg;


	// Entities relationship
	@OneToMany(mappedBy = "player")
	@JsonIgnore // To fix issue with infinite recursion
	private List<Game> games;

		
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

	public List<Game> getGames() {
	return games;
	}

	public void setGames(List<Game> games) {
	this.games = games;
	}
	
	// METHODS
	
	// Set author as Anonymous if name is null
	private String addName(String name) {
		if (name == null) {
			name = "Anonymous"+id;
		}
		return name;
	}
	
	@Override
	public String toString() {
		return "Player [id=" + id + ", name= " + name + ", winAvg=" + winAvg
				+ ", entry date=" + date + "  ]";
	}

}
