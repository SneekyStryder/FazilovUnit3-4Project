public class GameLogic {
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

    public String StartingCard() {
        int randomNum = (int) ((Math.random() * 51) + 1);
        startingCardVal = randomNum;
        String startingCardName = cards.CardNames[randomNum];
        return startingCardName;
    }

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
    }

    public void setNextPlayer() {
        if (currentPlayer == 4) {
            nextPlayer = 1;
        }
        else {
            nextPlayer = currentPlayer + 1;
        }
    }

    public void setCurrentPlayer() {
        currentPlayer = nextPlayer;
    }

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

    public void PlaceCard(String element, int player) {
        int cardVal = -1;
        for (int i = 1; i <= 52; i++) {
            String card = cards.CardNames[i];
            if (card.equals(element)) {
                cardVal = i;
            }
        }

        if (player == 1) {
            boolean hasCard = false;
            for (int j = 0; j < comp1.deckCardVals.length; j++) {
                if (comp1.deckCardVals[j] == cardVal) {
                    hasCard = true;
                }
            }

            if (hasCard) {
                comp1.removeCard(cardVal);
                comp1.setLetterDeck();

            }
            else {
                System.out.println("You do not have that card, skip your turn");
            }
        }


    }


    public String PromptUser() {
        System.out.print("Your deck: ");
        for (int i = 0; i < user.deckCardVals.length; i++) {
            int cardVal = user.deckCardVals[i];
            System.out.print(user.cardValToName(cardVal) + ", ");
        }
        System.out.println()
    }

    public void RunGame() {
        System.out.println("The Starting Card Is: " + StartingCard());
        System.out.println(StartingPlayer() + "will start");
        System.out.println("Current Card: " + cards.cardValToName(currentCard));
        System.out.println("Card Needed: " + cards.cardValToName(nextCard));
        if (currentPlayer == 4) {
            System.out.println("Your turn!");
        }
        else {
            System.out.println("Wait for " + getCurrentPlayer() + "'s turn to end");
        }


    }

}
