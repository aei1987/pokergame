package com.lyf.poker;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	private int id;
	private String name;
	private List<Card> cards = null;
	
	public Player(int id, String name) {
		this.id = id;
		this.name = name;
		this.cards = new ArrayList<Card>();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Card> getCards() {
		return this.cards;
	}

	public void setCard(Card card) {
		this.cards.add(card);
	}

}
