package com.business;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Credit {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="movieID")
	private Movie movie;
	
	@ManyToOne
	@JoinColumn(name="actorID")
	private Actor actor;
	private String character;
	
	public Credit() {
		super();
	}

	public Credit(int id, Movie movie, Actor actor, String character) {
		super();
		this.id = id;
		this.movie = movie;
		this.actor = actor;
		this.character = character;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	@Override
	public String toString() {
		return "Credit [id=" + id + ", movie=" + movie + ", actor=" + actor + ", character=" + character + "]";
	}
	
}
