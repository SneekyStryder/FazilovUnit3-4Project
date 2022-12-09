/**
 * The CardAssignments class contains the letter values of cards.
 */
public class CardAssignments {
    /**
     * Instance variable that contains all the letter values for their respective integer values.
     */
    public String[] CardDNs = {"n",
                               "AD", "2D", "3D", "4D", "5D", "6D", "7D", "8D", "9D", "10D", "JD", "QD", "KD",
                               "AC", "2C", "3C", "4C", "5C", "6C", "7C", "8C", "9C", "10C", "JC", "QC", "KC",
                               "AH", "2H", "3H", "4H", "5H", "6H", "7H", "8H", "9H", "10H", "JH", "QH", "KH",
                               "AS", "2S", "3S", "4S", "5S", "6S", "7S", "8S", "9S", "10S", "JS", "QS", "KS",};


    /**
     * Adds an element to a specified array.
     * @param length represents the length of the array
     * @param array represents the specified array
     * @param element represents the element being added to the array
     * @return returns an updated array with the new element
     */
    public static String[] addElementString(int length, String array[], String element)
    {
        int i;

        // create a new array of size n+1
        String newarray[] = new String[length + 1];

        for (i = 0; i < length; i++)
            newarray[i] = array[i];

        newarray[length] = element;

        return newarray;
    }


    /**
     * Creates an array with the letter values of a card instead of the integer values
     * @param deckArray represents the integer array being converted
     * @return returns a new array that has the name values
     */
    public String[] DeckLetters(int[] deckArray) {
        String[] deckArrayLetters = {};
        for (int i = 0; i < 14; i++) {
            int element = deckArray[i];
            deckArrayLetters = addElementString(deckArrayLetters.length, deckArrayLetters, CardDNs[element]);
        }
        return deckArrayLetters;
    }
}
