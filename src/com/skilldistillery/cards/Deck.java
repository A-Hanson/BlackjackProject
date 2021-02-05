package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Deck {
	private List<Card> cards;
	
	public Deck() {
		cards = makeDeckOf52();
	}
	
	private List<Card> makeDeckOf52(){
		cards = new ArrayList<>();
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				cards.add(new Card(rank, suit));
			}
		}
		return cards;
	}
	
	public int checkDeckSize() {
		// returns number of cards still in deck
		return cards.size();
	}
	
	public Card dealCard() {
		// removes and returns the card at index 0
		return cards.remove(0);
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
		System.out.println("The dealer shuffles the cards.");
	}
}
