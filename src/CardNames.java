/**
 * The CardNames class stores the text names for each card that are used when printing to the user.
 */
public class CardNames {
    /**
     * Instance variable array that stores every text name for the respective card value integers.
     */
    public String[] CardNames = {"nothing",
            "Ace of Diamonds",
            "2 of Diamonds",
            "3 of Diamonds",
            "4 of Diamonds",
            "5 of Diamonds",
            "6 of Diamonds",
            "7 of Diamonds",
            "8 of Diamonds",
            "9 of Diamonds",
            "10 of Diamonds",
            "Jack of Diamonds",
            "Queen of Diamonds",
            "King of Diamonds",
            "Ace of Clubs",
            "2 of Clubs",
            "3 of Clubs",
            "4 of Clubs",
            "5 of Clubs",
            "6 of Clubs",
            "7 of Clubs",
            "8 of Clubs",
            "9 of Clubs",
            "10 of Clubs",
            "Jack of Clubs",
            "Queen of Clubs",
            "King of Clubs",
            "Ace of Hearts",
            "2 of Hearts",
            "3 of Hearts",
            "4 of Hearts",
            "5 of Hearts",
            "6 of Hearts",
            "7 of Hearts",
            "8 of Hearts",
            "9 of Hearts",
            "10 of Hearts",
            "Jack of Hearts",
            "Queen of Hearts",
            "King of Hearts",
            "Ace of Spades",
            "2 of Spades",
            "3 of Spades",
            "4 of Spades",
            "5 of Spades",
            "6 of Spades",
            "7 of Spades",
            "8 of Spades",
            "9 of Spades",
            "10 of Spades",
            "Jack of Spades",
            "Queen of Spades",
            "King of Spades",};

    /**
     * Converts a specified card value into its text counterpart
     * @param cardVal represents the value of the card
     * @return returns the text version of the card
     */
    public String cardValToName(int cardVal) {
        return CardNames[cardVal];
    }

    /**
     * Converts a specified card name into its integer counterpart
     * @param cardName represents the value of the card
     * @return rteurns the integer version of the card
     */
    public int cardNameToVal(String cardName) {
        for (int i = 1; i <= 52; i++) {
            String name = CardNames[i];
            if (name.equals(cardName)) {
                return i;
            }
        }
        return -1;
    }
}
