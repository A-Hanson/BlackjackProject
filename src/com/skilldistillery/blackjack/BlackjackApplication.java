package com.skilldistillery.blackjack;

import java.util.InputMismatchException;
import java.util.Scanner;


import com.skilldistillery.cards.Deck;

public class BlackjackApplication {
	private BlackjackHand player;
	private BlackjackHand dealer;
	private Deck deck;

	public static void main(String[] args) {
		BlackjackApplication b = new BlackjackApplication();
		b.game();

	}
	
	private void game() {
		Scanner kb = new Scanner(System.in);
		// intro
		System.out.println("You wake up at a Blackjack table.\n"
				+ "Your head throbs and the air is musty with the smell of unwashed money.");
		// menu: play game or see rules
		printIntroMenu();
		try {
			int ruleChoice = kb.nextInt();
			if (ruleChoice == 2) {
				printRules();
			} else if (ruleChoice == 1) {
				System.out.println("Alright son, if you're sure.");
			} else {
				System.out.println("I'm not sure what that was, but I'm going to start dealing.");
			}
		}
		catch (InputMismatchException e) {
			System.err.println(e);
			kb.nextLine();
		}
		boolean keepPlaying = true;
		do {
			// deal hands (don't forget to shuffle!)
			deck.shuffle();
			initialDeal();
			// choice stand or hit
			boolean dealerGoes;
			dealerGoes = isPlayersTurn(kb);
			// dealer only goes if player didn't bust.
			if (dealerGoes) {
				// dealers turn if .getHandValue > 17 must stand,
				// if .getHandValue <= 16 must hit
				boolean needToCompareScores;
				needToCompareScores = isDealersTurn();
				if (needToCompareScores) {
					// compare scores only if dealer didn't bust
					compareScores();
				}
			}
			// clear the hands
			player.clear();
			dealer.clear();
			keepPlaying = endOfGameContinue(kb);
		} while (keepPlaying);
		
		kb.close();
	}
	
	private void compareScores() {
		if (player.getHandValue() > dealer.getHandValue()) {
			System.out.println("You win!");
			
		} else if (player.getHandValue() < dealer.getHandValue()) {
			System.out.println("You lose!");
		} else {
			System.out.println("It's a tie!");
		}
		System.out.println("Your hand value was " + player.getHandValue() +
				" and the dealer had " + dealer.getHandValue());
		System.out.println();
	}
	
	private boolean isDealersTurn() {
		boolean compareScores = true;
		boolean keepGoing = true;
		while (keepGoing) {
			if (dealer.getHandValue() <= 16) {
				dealAndPrintDealer(false);
				if (dealer.isBust()) {
					keepGoing = false;
					compareScores = false;
					System.out.println("The dealer busted!! You win.");
				}
				if (dealer.isBlackjack()) {
					keepGoing = false;
					System.out.println("The dealer got Blackjack!!!");
				}
			}
			else {
				keepGoing = false;
				printDealerHand(keepGoing);
				System.out.println(dealer.printHandValue());
				System.out.println("The dealer stands. Let's compare scores.");
			}
			
		}
		System.out.println("---------------------");
		return compareScores;
	}
	
	private boolean isPlayersTurn(Scanner kb) {
		System.out.println("It's your turn.");
		boolean dealerGoes = true;
		boolean keepGoing = true;
		do {
			System.out.println("Enter 1 to hit (get another card) or 2 to stand (end your turn).");
			try {
				int choice = kb.nextInt();
				if (choice == 1) {
					dealAndPrintPlayer();
					if (player.isBust()) {
						keepGoing = false;
						dealerGoes = false;
						System.out.println("BUUUUUST!!! You lose.");
					}
					if (player.isBlackjack()) {
						keepGoing = false;
						System.out.println("Blackjack! Now it's the dealer's turn.");
					}
				} else if (choice == 2) {
					keepGoing = false;
					System.out.println("If you're sure.");
					System.out.println("Your turn is now over.");
				} else {
					System.out.println("That didn't make sense, enter 1 or 2.");
				}
			}
			catch (InputMismatchException e) {
				System.err.println(e);
				kb.nextLine();
			}
		} while (keepGoing);
		System.out.println("---------------------");
		return dealerGoes;
	}
	
	private void dealAndPrintPlayer() {
		player.addCard(deck.dealCard());
		printPlayerHand();
		System.out.println(player.printHandValue());
		System.out.println();
	}
	
	private void dealAndPrintDealer(boolean isNotTurn) {
		dealer.addCard(deck.dealCard());
		printDealerHand(isNotTurn);
		if (!isNotTurn) {
			System.out.println(dealer.printHandValue());
		}
		System.out.println();
	}
	
	private void initialDeal() {
		// deal two cards to each person
		System.out.println();
		System.out.println("The dealer starts to pass out cards...");
		System.out.println("---------------------");
		for (int i = 0; i<2; i++) {
			dealAndPrintPlayer();
			System.out.println("---------------------");
			dealAndPrintDealer(true);
			System.out.println("---------------------");
		}
	}
	
	private boolean endOfGameContinue(Scanner kb) {
		System.out.println("----------------------------");
		System.out.println("Do you want to play again?\n"
				+ "Enter 1 for yes, 2 for no");
		boolean keepPlaying = true;
		try {
			int choice = kb.nextInt();
			if (choice == 2) {
				keepPlaying = false;
				System.out.println("Alright, good luck finding an uber at this hour.");
			} else if (choice == 1) {
				System.out.println("An eager player, alright then let's see how your luck holds up.");
			} else {
				System.out.println("Not sure what that was, but I'll deal you in anyways.");
			}
		}
		catch (InputMismatchException e){
			System.err.println(e);
			kb.nextLine();
		}
		System.out.println("*****************************");
		return keepPlaying;
	}
	
	private void printPlayerHand() {
		System.out.println(player.toString());
	}
	
	private void printDealerHand(boolean secondFaceDown) {
		System.out.println(dealer.printDealerHand(secondFaceDown));
	}
	
	public BlackjackApplication() {
		player = new BlackjackHand();
		dealer = new BlackjackHand();
		deck = new Deck();
	}
	
	private void printIntroMenu() {
		System.out.println("*****************************");
		System.out.println("The dealer says 'son, do you need me to tell you the rules, or are you good?'");
		System.out.println("Enter 1 to start playing, 2 for the rules");
		System.out.println("*****************************");
	}
	private void printRules() {
		System.out.println("*****************************");
		System.out.println("You are playing against the dealer.");
		System.out.println("The goal is to get as close to 21 without going over.");
		System.out.println("Face cards are worth 10, Aces worth 11, and other cards worth their value.");
		System.out.println("You go first, requesting cards one at a time (a hit) until you want to stop.");
		System.out.println("If you bust (go over 21), you lose.");
		System.out.println("Then the dealer takes their turn.");
		System.out.println("If a bust hasn't happened, then whoever is closest to 21 wins.");
		System.out.println("That shoudld be enough to get your started...");
		System.out.println("Here we go!");
		System.out.println("*****************************");
	}
}
