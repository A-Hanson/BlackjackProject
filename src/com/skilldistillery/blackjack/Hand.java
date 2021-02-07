package com.skilldistillery.blackjack;

import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.cards.Card;

public abstract class Hand {
	protected List<Card> cards;
	
	public Hand() {
		cards = new ArrayList<>();
	}
	
	public void addCard(Card card) {
		cards.add(card);
	}
	
	public void clear() {
		cards.clear();
	}
	
	public abstract int getHandValue(); 
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("There are " + cards.size() + " cards in the hand.");
		if (cards.size() > 0) {
			sb.append("\nThey are: ");
			for (Card card : cards) {
				sb.append(card + ", ");
			}
			// remove last space and comma
			sb.deleteCharAt(sb.length()-1);
			sb.deleteCharAt(sb.length()-1);
		}
		return sb.toString();
	}
	
	public int getNumberOfCardsInHand() {
		if (cards != null) {
			return cards.size();
			
		} else {
			return 0;
		}
	}
		
}
