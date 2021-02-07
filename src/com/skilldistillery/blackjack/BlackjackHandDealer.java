package com.skilldistillery.blackjack;

public class BlackjackHandDealer extends BlackjackHand{
	private boolean isTurn = false;
	
	public BlackjackHandDealer() {
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("The dealer has " + cards.size() + " cards in their hand.");
		if (cards.size() > 0) {
			sb.append("\nThey are: ");
			for (int i = 0; i < cards.size(); i++) {
				if (!isTurn && i==1) {
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

	public boolean isTurn() {
		return isTurn;
	}

	public void setTurn(boolean isTurn) {
		this.isTurn = isTurn;
	}
	
}
