package com.skilldistillery.blackjack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Rank;
import com.skilldistillery.cards.Suit;

class BlackjackHandTester {
	private BlackjackHand hand;
	private Card card1 = new Card(Rank.TWO, Suit.DIAMONDS);
	private Card card2 = new Card(Rank.TWO, Suit.SPADES);
	private Card card3 = new Card(Rank.KING, Suit.SPADES);
	private Card card4 = new Card(Rank.ACE, Suit.SPADES);

	@BeforeEach
	void setUp() throws Exception {
		hand = new BlackjackHand();
	}

	@AfterEach
	void tearDown() throws Exception {
		hand = null;
	}

	@Test
	void test_addCard_adds_one_card_to_hand() {
		hand.addCard(card1);
		hand.addCard(card2);
		assertEquals(2, hand.getNumberOfCardsInHand());
	}
	
	@Test
	void test_getNumberOfCardsInHand_returns_one_with_one_card_added() {
		hand.addCard(card1);
		assertEquals(1, hand.getNumberOfCardsInHand());
	}
	
	@Test
	void test_getNumberOfCardsInHand_returns_zero_with_no_cards_added() {
		assertEquals(0, hand.getNumberOfCardsInHand());
	}
	
	@Test
	void test_clear_returns_zero_when_called_after_adding_cards() {
		hand.addCard(card1);
		hand.addCard(card2);
		hand.clear();
		assertEquals(0, hand.getNumberOfCardsInHand());
	}

	@Test
	void test_toString_returns_zero_cards_in_hand_with_no_cards_added() {
		assertEquals("You have 0 cards in your hand."
				, hand.toString());
	}
	
	@Test
	void test_toString_returns_two_cards_in_hand_with_two_cards_added() {
		hand.addCard(card1);
		hand.addCard(card2);
		assertEquals("You have 2 cards in your hand.\nThey are: TWO of Diamonds, TWO of Spades"
				, hand.toString());
	}
	
	@Test
	void test_getHandValue_returns_zero_with_empty_hand() {
		assertEquals(0, hand.getHandValue());
	}
	
	@Test
	void test_getHandValue_returns_four_with_two_twos_in_hand() {
		hand.addCard(card1);
		hand.addCard(card2);
		assertEquals(4, hand.getHandValue());
	}
	
	@Test
	void test_isBlackjack_returns_true_with_king_and_ace_in_hand() {
		hand.addCard(card3);
		hand.addCard(card4);
		assertEquals(true, hand.isBlackjack());
	}
	
	@Test
	void test_isBlackjack_returns_false_with_two_and_king_and_ace_in_hand() {
		hand.addCard(card1);
		hand.addCard(card3);
		hand.addCard(card4);
		assertEquals(false, hand.isBlackjack());
	}
	
	@Test
	void test_isBlackjack_returns_false_with_two_and_king_in_hand() {
		hand.addCard(card1);
		hand.addCard(card3);
		assertEquals(false, hand.isBlackjack());
	}
	
	@Test
	void test_isBust_returns_true_with_two_and_king_and_ace_in_hand() {
		hand.addCard(card1);
		hand.addCard(card3);
		hand.addCard(card4);
		assertEquals(true, hand.isBust());
	}
	
	@Test
	void test_isBust_returns_false_with_two_and_king_in_hand() {
		hand.addCard(card1);
		hand.addCard(card3);
		assertEquals(false, hand.isBust());
	}
	
	@Test
	void test_isBust_returns_false_with_king_and_ace_in_hand() {
		hand.addCard(card3);
		hand.addCard(card4);
		assertEquals(false, hand.isBust());
	}
}
