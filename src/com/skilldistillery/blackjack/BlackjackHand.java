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
		return "The current value of the hand is: " + getHandValue();
	}
	
	public boolean isBlackjack() {
		return (getHandValue() == 21);
		
	}
	
	public boolean isBust() {
		return (getHandValue() > 21);
	}
	
//	public boolean isHard() {
//		// optional
//		// dealer has slightly different rules
//	}
//	
//	public boolean isSoft() {
//		// optional
//	}
	
	public String printDealerHand(boolean secondFaceDown) {
		StringBuilder sb = new StringBuilder("The dealer has " + cards.size() + " cards in their hand.");
		if (cards.size() > 0) {
			sb.append("\nThey are: ");
			for (int i = 0; i < cards.size(); i++) {
				if (secondFaceDown && i==1) {
					sb.append("Second card is face down, ");
				} else {
					sb.append(cards.get(i) + ", ");
				}
			}
			// remove last space and comma
			sb.deleteCharAt(sb.length()-1);
			sb.deleteCharAt(sb.length()-1);
		}
		return sb.toString();
	}

}
