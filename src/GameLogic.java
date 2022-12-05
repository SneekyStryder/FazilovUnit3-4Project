public class GameLogic {
    ComputerDeck comp1 = new ComputerDeck();
    ComputerDeck comp2 = new ComputerDeck();
    ComputerDeck comp3 = new ComputerDeck();

    CardNames cards = new CardNames();
    public int startingCardVal;
    public int startingPlayer;
    private int currentCard;
    private int nextCard;
    public String StartingPlayer() {
        int randomNum = (int) ((Math.random() * 3) + 1);
        startingPlayer = randomNum;
        if (startingPlayer == 1) {
            String startingPlayerName = "Computer 1";
            return startingPlayerName;
        }
        else if (startingPlayer == 2) {
            String startingPlayerName = "Computer 2";
            return startingPlayerName;
        }
        else if (startingPlayer == 3) {
            String startingPlayerName = "Computer 3";
            return startingPlayerName;
        }
        else if (startingPlayer == 4) {
            String startingPlayerName = "You";
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

    public void NextCard() {
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

    public void RunGame() {
        System.out.println("The Starting Card Is: " + StartingCard());
        System.out.println(StartingPlayer() + "will start");

    }

}
