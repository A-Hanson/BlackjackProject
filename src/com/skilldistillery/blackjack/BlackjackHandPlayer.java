package com.skilldistillery.blackjack;

import com.skilldistillery.cards.Card;

public class BlackjackHandPlayer extends BlackjackHand {
	
	public BlackjackHandPlayer() {
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("You have " + cards.size() + " cards in your hand.");
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
}
