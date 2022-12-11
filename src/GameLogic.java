import java.util.Scanner;

/**
 * The class GameLogic contains all the main game logic for the game
 */
public class GameLogic {
    Scanner scan = new Scanner(System.in);
    ComputerDeck comp1 = new ComputerDeck();
    ComputerDeck comp2 = new ComputerDeck();
    ComputerDeck comp3 = new ComputerDeck();
    ComputerDeck user = new ComputerDeck();

    CardNames cards = new CardNames();

    public int startingCardVal;
    public int startingPlayer;
    private int currentCard;
    private int currentPlayer;
    private int nextCard;
    private int nextPlayer;
    private int placeCardVal;
    private int deckSize;
    private int[] deck = {0};
    private int[] emptyDeck = {0};
    private boolean cont = true;
    private int win;

    /**
     * Creates the randomized decks for each player
     */
    public void assignCards() {
        comp1.AssignCards();
        comp2.AssignCards();
        comp3.AssignCards();
        user.AssignCards();
    }

    /**
     * Sets the card pile to 0
     */
    public void resetDeck() {
        deck = emptyDeck;
    }

    /**
     * Adds a card to a deck based on the card value
     * @param length represents length of the deck
     * @param array represents the deck
     * @param element represents the card value that is to be added
     * @return returns the updated deck with the specified card
     */
    public static int[] addElementInt(int length, int array[], int element)
    {
        int i;

        // create a new array of size n+1
        int newarray[] = new int[length + 1];

        for (i = 0; i < length; i++)
            newarray[i] = array[i];

        newarray[length] = element;

        return newarray;
    }

    /**
     * Sets the starting player of the game
     * @return returns the starting player's name
     */
    public String StartingPlayer() {
        int randomNum = (int) ((Math.random() * 3) + 1);
        startingPlayer = randomNum;
        if (startingPlayer == 1) {
            String startingPlayerName = "Computer 1";
            currentPlayer = 1;
            return startingPlayerName;
        }
        else if (startingPlayer == 2) {
            String startingPlayerName = "Computer 2";
            currentPlayer = 2;
            return startingPlayerName;
        }
        else if (startingPlayer == 3) {
            String startingPlayerName = "Computer 3";
            currentPlayer = 3;
            return startingPlayerName;
        }
        else if (startingPlayer == 4) {
            String startingPlayerName = "You";
            currentPlayer = 4;
            return startingPlayerName;
        }
        return "nothing";
    }

    /**
     * Sets the starting card of the game
     * @return returns the name of the starting card
     */
    public String StartingCard() {
        int randomNum = (int) ((Math.random() * 51) + 1);
        startingCardVal = randomNum;
        String startingCardName = cards.CardNames[randomNum];
        currentCard = startingCardVal;
        setNextCard();
        deck = addElementInt(deck.length, deck, startingCardVal);
        deckSize++;
        return startingCardName;
    }

    /**
     * Sets the next card based on the current card on the pile
     */
    public void setNextCard() {
        if (currentCard == 13) {
            nextCard = 1;
        }
        else if (currentCard == 26) {
            nextCard = 14;
        }
        else if (currentCard == 39) {
            nextCard = 27;
        }
        else if (currentCard == 52) {
            nextCard = 40;
        }
        else {
            nextCard = currentCard + 1;
        }
    }

    /**
     * Sets the current card based on the next card
     */
    public void setCurrentCard() {
        currentCard = nextCard;
    }

    /**
     * Sets the next player based on the current player
     */
    public void setNextPlayer() {
        if (currentPlayer == 4) {
            nextPlayer = 1;
        }
        else {
            nextPlayer = currentPlayer + 1;
        }
    }

    /**
     * Sets the current player based on the next player
     */
    public void setCurrentPlayer() {
        currentPlayer = nextPlayer;
    }

    /**
     * Returns the current player's name
     * @return returns the current player's name
     */
    public String getCurrentPlayer() {
        if (currentPlayer == 1) {
            return "Computer 1";
        }
        else if (currentPlayer == 2) {
            return "Computer 2";
        }
        else if (currentPlayer == 3) {
            return "Computer 3";
        }
        else if (currentPlayer == 4) {
            return "You";
        }
        return "nothing";
    }

    /**
     * The PlaceCard method places a specified card based on what the card is and the player placing it
     * @param element represents the card name
     * @param player represents the player number
     */
    public void PlaceCard(String element, int player) {
        int cardVal = -1;
        for (int i = 1; i <= 52; i++) {
            String card = cards.CardNames[i];
            if (card.equals(element)) {
                cardVal = i;
            }
        }

        if (player == 4) {
            boolean hasCard = false;
            for (int j = 0; j < user.deckCardVals.length; j++) {
                if (user.deckCardVals[j] == cardVal) {
                    hasCard = true;
                }
            }

            if (hasCard) {
                user.removeCard(cardVal);
                deck = addElementInt(deck.length, deck, cardVal);
                deckSize++;
                System.out.println("You placed a " + cards.cardValToName(nextCard));

            }
            else {
                System.out.println("You do not have that card, skip your turn");
            }
        }

        else if (player == 1) {
            boolean hasCard = false;
            for (int i = 0; i < comp1.deckCardVals.length; i++) {
                if (comp1.deckCardVals[i] == nextCard) {
                    hasCard = true;
                }
            }

            if (hasCard) {
                placeCardVal = nextCard;
                comp1.removeCard(nextCard);
                deck = addElementInt(deck.length, deck, nextCard);
                deckSize++;
                System.out.println("Computer 1 placed a " + cards.cardValToName(nextCard));
            }

            else {
                int firstCard = comp1.deckCardVals[0];
                placeCardVal = firstCard;
                comp1.removeCard(firstCard);
                deck = addElementInt(deck.length, deck, firstCard);
                deckSize++;
                System.out.println("Computer 1 placed a " + cards.cardValToName(nextCard));
            }
        }

        else if (player == 2) {
            boolean hasCard = false;
            for (int i = 0; i < comp2.deckCardVals.length; i++) {
                if (comp2.deckCardVals[i] == nextCard) {
                    hasCard = true;
                }
            }

            if (hasCard) {
                placeCardVal = nextCard;
                comp2.removeCard(nextCard);
                deck = addElementInt(deck.length, deck, nextCard);
                deckSize++;
                System.out.println("Computer 2 placed a " + cards.cardValToName(nextCard));
            }

            else {
                int firstCard = comp2.deckCardVals[0];
                placeCardVal = firstCard;
                comp2.removeCard(firstCard);
                deck = addElementInt(deck.length, deck, firstCard);
                deckSize++;
                System.out.println("Computer 2 placed a " + cards.cardValToName(nextCard));
            }
        }

        else if (player == 3) {
            boolean hasCard = false;
            for (int i = 0; i < comp3.deckCardVals.length; i++) {
                if (comp3.deckCardVals[i] == nextCard) {
                    hasCard = true;
                }
            }

            if (hasCard) {
                placeCardVal = nextCard;
                comp3.removeCard(nextCard);
                deck = addElementInt(deck.length, deck, nextCard);
                deckSize++;
                System.out.println("Computer 3 placed a " + cards.cardValToName(nextCard));
            }

            else {
                int firstCard = comp3.deckCardVals[0];
                placeCardVal = firstCard;
                comp3.removeCard(firstCard);
                // comp3.setLetterDeck();
                deck = addElementInt(deck.length, deck, firstCard);
                deckSize++;
                System.out.println("Computer 3 placed a " + cards.cardValToName(nextCard));
            }
        }


    }

    /**
     * The PromptUser method shows the user their deck and asks the user to place a card
     * @return returns the name of the card to be placed
     */
    public String PromptUser() {
        System.out.print("Your deck: ");
        for (int i = 0; i < user.deckCardVals.length; i++) {
            int cardVal = user.deckCardVals[i];
            System.out.print(user.cardValToName(cardVal) + ", ");
        }
        System.out.println();
        System.out.print("Card to place: ");
        String userCardSelect = scan.nextLine();
        return userCardSelect;
    }

    /**
     * The userCallBS method asks the user to call BS or not and returns either true or false depending on their answer
     * @return returns true if user calls BS and false if user does not
     */
    public boolean userCallBS() {
        System.out.println("Call BS? (BS for yes, n for no): ");
        String userCall = scan.nextLine();
        if (userCall.equals("BS")) {
            return true;
        }
        else if (userCall.equals("n")) {
            return false;
        }
        return false;
    }

    /**
     * Computer logic for calling BS (50/50 chance of calling BS)
     * @return returns true if computer calls BS and false if it does not
     */
    public boolean compCallBS() {
        int randomNum = (int) ( Math.random() * 2 + 1);
        if (randomNum == 1) {
            return true;
        }
        else if (randomNum == 2) {
            return false;
        }
        return false;
    }

    /**
     * Tests if player who calls BS is right by checking the needed card and the placed card
     * @return returns true if the cards are not the same and false if they are
     */
    public boolean testBS() {
        if (placeCardVal == nextCard) {
            return false;
        }
        else if (placeCardVal != nextCard) {
            return true;
        }
        return false;
    }

    /**
     * Runs the PlaceCard method for the computer
     */
    public void runComputerMove() {
        PlaceCard("whatever", currentPlayer);
    }

    /**
     * Makes the current player pick up the deck
     */
    public void playerPickUp() {
        if (currentPlayer == 1) {
            for (int i = 1; i <= deckSize; i++) {
            comp1.addCard(deck[i]);
            }
            deckSize = 0;
            resetDeck();
        }
        else if (currentPlayer == 2) {
            for (int i = 1; i <= deckSize; i++) {
            comp2.addCard(deck[i]);
            }
            deckSize = 0;
            resetDeck();
        }
        else if (currentPlayer == 3) {
            for (int i = 1; i <= deckSize; i++) {
            comp3.addCard(deck[i]);
            }
            deckSize = 0;
            resetDeck();
        }
        else if (currentPlayer == 4) {
            for (int i = 1; i <= deckSize; i++) {
                user.addCard(deck[i]);
            }
            deckSize = 0;
            resetDeck();
        }

    }

    /**
     * Makes the player who called BS pick up the deck
     */
    public void callerPickUp() {
        if (nextPlayer == 1) {
            for (int i = 1; i <= deckSize; i++) {
                comp1.addCard(deck[i]);
            }
            deckSize = 0;
            resetDeck();
        }
        else if (nextPlayer == 2) {
            for (int i = 1; i <= deckSize; i++) {
                comp2.addCard(deck[i]);
            }
            deckSize = 0;
            resetDeck();
        }
        else if (nextPlayer == 3) {
            for (int i = 1; i <= deckSize; i++) {
                comp3.addCard(deck[i]);
            }
            deckSize = 0;
            resetDeck();
        }
        else if (nextPlayer == 4) {
            for (int i = 1; i <= deckSize; i++) {
                user.addCard(deck[i]);
            }
            deckSize = 0;
            resetDeck();
        }
    }

    /**
     * Skips the turn for the next player
     */
    public void skipTurn() {
        setCurrentPlayer();
        setNextPlayer();
        setCurrentPlayer();
        setNextPlayer();
    }

    /**
     * Main logic that runs the entire game until a player wins, using all logic methods
     */
    public void RunGame() {
        assignCards();
        System.out.println("The Starting Card Is: " + StartingCard());
        System.out.println(StartingPlayer() + " will start");
        setNextPlayer();
        while (cont) {
            System.out.println("Current Card: " + cards.cardValToName(currentCard) + "       Card Needed: " + cards.cardValToName(nextCard) + "       Deck Size: " + deckSize);
            if (currentPlayer == 4) {
                System.out.println("Your turn!");
                String cardName = PromptUser();
                placeCardVal = cards.cardNameToVal(cardName);
                PlaceCard(cardName, 4);
                boolean called = compCallBS();
                if (called) {
                    System.out.println("Computer 1 called BS!");
                    boolean correct = testBS();
                    if (correct) {
                        System.out.println("Computer 1 was right! You pick up the deck");
                        playerPickUp();
                        setCurrentPlayer();
                        setCurrentCard();
                        setNextCard();
                        setNextPlayer();
                    }
                    else {
                        System.out.println("Computer 1 was wrong! Computer 1 picks up the deck");
                        callerPickUp();
                        skipTurn();
                        setCurrentCard();
                        setNextCard();
                        // setNextPlayer();
                    }
                }
                else {
                    setCurrentPlayer();
                    setCurrentCard();
                    setNextCard();
                    setNextPlayer();
                }
                if (user.deckCardVals.length == 0) {
                    cont = false;
                    win = 4;
                }

            }
            else if (currentPlayer == 3) {
                System.out.println("Computer 3's turn");
                runComputerMove();
                boolean called = userCallBS();
                if (called) {
                    System.out.println("You called BS!");
                    boolean correct = testBS();
                    if (correct) {
                        System.out.println("You were right! Computer 3 picks up the deck");
                        playerPickUp();
                        setCurrentPlayer();
                        setCurrentCard();
                        setNextCard();
                        setNextPlayer();
                    }
                    else {
                        System.out.println("You were wrong! You pick up the deck");
                        callerPickUp();
                        skipTurn();
                        setCurrentCard();
                        setNextCard();
                        // setNextPlayer();
                    }
                }
                else {
                    setCurrentPlayer();
                    setCurrentCard();
                    setNextCard();
                    setNextPlayer();
                }
                if (comp3.deckCardVals.length == 0) {
                    cont = false;
                    win = 3;
                }
            }
            else if (currentPlayer == 2) {
                System.out.println("Computer 2's turn");
                runComputerMove();
                boolean called = compCallBS();
                if (called) {
                    System.out.println("Computer 3 called BS!");
                    boolean correct = testBS();
                    if (correct) {
                        System.out.println("Computer 3 was right! Computer 2 picks up the deck");
                        playerPickUp();
                        setCurrentPlayer();
                        setCurrentCard();
                        setNextCard();
                        setNextPlayer();
                    }
                    else {
                        System.out.println("Computer 3 was wrong! Computer 3 picks up the deck");
                        callerPickUp();
                        skipTurn();
                        setCurrentCard();
                        setNextCard();
                        // setNextPlayer();
                    }
                }
                else {
                    setCurrentPlayer();
                    setCurrentCard();
                    setNextCard();
                    setNextPlayer();
                }
                if (comp2.deckCardVals.length == 0) {
                    cont = false;
                    win = 2;
                }
            }
            else if (currentPlayer == 1) {
                System.out.println("Computer 1's turn");
                runComputerMove();
                boolean called = compCallBS();
                if (called) {
                    System.out.println("Computer 2 called BS!");
                    boolean correct = testBS();
                    if (correct) {
                        System.out.println("Computer 2 was right! Computer 1 picks up the deck");
                        playerPickUp();
                        setCurrentPlayer();
                        setCurrentCard();
                        setNextCard();
                        setNextPlayer();
                    }
                    else {
                        System.out.println("Computer 2 was wrong! Computer 2 picks up the deck");
                        callerPickUp();
                        skipTurn();
                        setCurrentCard();
                        setNextCard();
                        // setNextPlayer();
                    }
                }
                else {
                    setCurrentPlayer();
                    setCurrentCard();
                    setNextCard();
                    setNextPlayer();
                }
                if (comp1.deckCardVals.length == 0) {
                    cont = false;
                    win = 1;
                }
            }
            System.out.println();
        }

        if (win == 1) {
            System.out.println();
            System.out.println("Computer 1 Wins!");
        }
        else if (win == 2) {
            System.out.println();
            System.out.println("Computer 2 Wins!");
        }
        else if (win == 3) {
            System.out.println();
            System.out.println("Computer 3 Wins!");
        }
        else if (win == 4) {
            System.out.println();
            System.out.println("You Win!");
        }

    }

}
