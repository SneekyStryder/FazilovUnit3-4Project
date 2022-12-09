import java.util.*;

/**
 * The ComputerDeck class is used to create, store, and assign cards
 */
public class ComputerDeck {
    public int deckSize;
    public int[] deckCardVals = {};
    public String[] deckCardLetters = {};

    CardAssignments compAssign = new CardAssignments();
    CardNames names = new CardNames();

    /**
     * Constructor for the ComputerDeck class. No parameter constructor that always sets the deckSize to 13
     */
    public ComputerDeck() {
        deckSize = 13;
    }

    /**
     * Adds an element to a specified array.
     * @param length represents the length of the array
     * @param array represents the specified array
     * @param element represents the element being added to the array
     * @return returns an updated array with the new element
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
     * Removes an element from an array
     * @param arr represents the array
     * @param index represents the index of the array
     * @return returns a new array without the deleted element
     */
    public static int[] removeElement(int[] arr, int index)
    {

        if (arr == null || index < 0
                || index >= arr.length) {

            return arr;
        }

        // Create another array of size one less
        int[] anotherArray = new int[arr.length - 1];

        // Copy the elements except the index
        // from original array to the other array
        for (int i = 0, k = 0; i < arr.length; i++) {

            // if the index is
            // the removal element index
            if (i == index) {
                continue;
            }

            // if the index is not
            // the removal element index
            anotherArray[k++] = arr[i];
        }

        // return the resultant array
        return anotherArray;
    }

    /**
     * Assigns cards for the starting deck
     */
    public void AssignCards() {
        int randomNum;
        for (int i = 1; i <= 13; i++) {
            randomNum = (int) ((Math.random() * 51) + 1);
            deckCardVals = addElementInt(deckCardVals.length, deckCardVals, randomNum);
        }
    }

    /**
     * sets the DeckCardVals to the specified array
     * @param array represents the specified array
     */
    public void setDeckCardVals(int[] array) {
        deckCardVals = array;
    }

    /**
     * gets the deck with integer values
     * @return returns the deckCardVals array
     */
    public String getNumDeck() {
        return Arrays.toString(deckCardVals);
    }

    /**
     * sets the deck with letter values
     */
    public void setLetterDeck() {
        deckCardLetters = compAssign.DeckLetters(deckCardVals);
    }

    /**
     * gets the deck with letter values
     * @return returns the deckCardLetters array
     */
    public String getLetterDeck() {
        return Arrays.toString(deckCardLetters);
    }

    /**
     * removes the specified card from the array
     * @param cardValue represents the value of the card that needs to be removed
     */
    public void removeCard(int cardValue) {
        int element = -1;
        for (int i = 0; i < deckCardVals.length; i++) {
            if (deckCardVals[i] == cardValue) {
                element = i;
            }
        }
        deckCardVals = removeElement(deckCardVals, element);
    }

    /**
     * adds the specified card to the array with integer values
     * @param cardValue represents the value of the card that needs to be added
     */
    public void addCard(int cardValue) {
        deckCardVals = addElementInt(deckCardVals.length, deckCardVals, cardValue);
    }

    /**
     * Converts a specified card value into its text counterpart
     * @param cardVal represents the card value to be converted
     * @return returns the name value of a card
     */
    public String cardValToName(int cardVal) {
        return names.CardNames[cardVal];
    }

}
