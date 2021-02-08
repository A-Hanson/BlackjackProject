## Blackjack Project
### An Object Oriented Blackjack Application
<img src = "http://clipart-library.com/image_gallery/339264.jpg" alt="Ace of Spades and Jack of Spades playing cards." />

### Description

This application creates a functional command line blackjack game. The application's fields are objects created by other classes. The deck was built using a general card class, which used Enum data types to build the constants that are used within the standard 52 card deck. The player and dealer objects were created and made use of the methods they inherited from super classes. The player only plays against the dealer within this game.

---

### Topics and Technologies Used
<ul>
    <li>Test Driven Development - I wrote J-Unit tests for the functionality expected out of my BlackjackHand methods. This allowed me to make sure that my class was functioning appropriately before I started integrating objects into the "Game." Examples included how the toString was outputting and if the getHandValue was totalling the cards correctly.</li>
    <li>Object Oriented Programming
        <ul>
            <li>Abstract Classes - The Hand class was used as an abstract class from which to provide basic information that might be within a hand of cards for any game. There was an abstract getHandValue method. The concrete methods defined were a no-argument constructor, adding a card, clearing the hand, calculating the number of cards in the hand, and the toString indicating the number of cards in the hand.</li>
            <li>Inheritance - For the actual BlackjackHand class, this extended the Hand class and defined the getHandValue method. It also went on to add the methods of finding out if a player had blackjack, went bust, or if the hand was hard or soft. The Player and Dealer classes extended this general BlackjackHand class to further define characteristics of a point-of-view player and the dealer (who keeps their second card face-down until it's their turn).</li>
            <li>Enum Data Type - For the Ranks and Suits of the card, I used Enum data types. This allowed me to use constants while building the Card and Deck classes.</li>
        </ul>
    </li>
</ul>

---

### How to Run

Run from the BlackjackApplication.java file.

---

### Lessons Learned

Building out a J-Unit test for my BlackjackHand class was tremendously helpful in the long run. Getting the base functional game was fairly straightforward. However I realized after I had a minimum viable game working that it would be better to create a player and dealer class with their specific toStrings and potentially different methods down the line. Eventually I decided to refactor the code I had written to include the new classes and alter the code within the game to match with the new classes. 

Also not having any area knowledge about Blackjack or interest in card games I think really hindered my ability to invest in expanding the game into the stretch goals. Even after watching several videos and reading multiple articles, I still don't exactly understand how the soft hand works. Not understanding the nuances around the theory of what you're trying to code makes it very difficult to translate into actionable items within the game. 