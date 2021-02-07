package com.skilldistillery.blackjack;

import com.skilldistillery.cards.Card;

public class BlackjackHand extends Hand{
	
	public BlackjackHand() {
		// instantiates new ArrayList based on Hand ctor
	}
	
	
	
	@Override
	public int getHandValue() {
		int handValue = 0;
		if (cards.size() > 0) {
			for (Card card : cards) {
				handValue += card.getValue();
			}
		}
		return handValue;
	}
	
	public String printHandValue() {
		if (isSoft()) {
			return "The current value of the hand is a soft: " + getHandValue();
			
		}
		return "The current value of the hand is a hard: " + getHandValue();
	}
	
	public boolean isBlackjack() {
		return (getHandValue() == 21);
		
	}
	
	public boolean isBust() {
		if (isSoft()) {
			return (getHandValue() > 31);
			
		} else {
			return (getHandValue() > 21);
		}
	}
	
	public boolean isHard() {
		// optional
		return (!isSoft());
		
	}
	
	public boolean isSoft() {
		//optional

		for (Card card : cards) {
			if (card.getValue() == 11) {
				return true;
			}
		} 
		return false;
	}
	
	

}
