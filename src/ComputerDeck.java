import java.util.*;

public class ComputerDeck {
    public int deckSize;
    public int[] deckCardVals = {};
    public String[] deckCardLetters = {};

    CardAssignments compAssign = new CardAssignments();

    public ComputerDeck() {
        deckSize = 13;
    }

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

    public void AssignCards() {
        int randomNum;
        for (int i = 1; i <= 13; i++) {
            randomNum = (int) ((Math.random() * 51) + 1);
            deckCardVals = addElementInt(deckCardVals.length, deckCardVals, randomNum);
        }
    }

    public void setDeckCardVals(int[] array) {
        deckCardVals = array;
    }
    public String getNumDeck() {
        return Arrays.toString(deckCardVals);
    }

    public void setLetterDeck() {
        deckCardLetters = compAssign.DeckLetters(deckCardVals);
    }
    public String getLetterDeck() {
        return Arrays.toString(deckCardLetters);
    }

    public void removeCard(int cardValue) {
        int element = -1;
        for (int i = 0; i < deckCardVals.length; i++) {
            if (deckCardVals[i] == cardValue) {
                element = i;
            }
        }
        deckCardVals = removeElement(deckCardVals, element);
    }

    public void addCard(int cardValue) {
        deckCardVals = addElementInt(deckCardVals.length, deckCardVals, cardValue);
        setLetterDeck();
    }
}
