import java.util.*;

public class ComputerDeck {
    private int deckSize;
    private int[] deckCardVals = {};

    public ComputerDeck() {
        deckSize = 13;
    }

    public static int[] addElement(int length, int array[], int element)
    {
        int i;

        // create a new array of size n+1
        int newarray[] = new int[length + 1];

        for (i = 0; i < length; i++)
            newarray[i] = array[i];

        newarray[length] = element;

        return newarray;
    }

    public void AssignCards() {
        int randomNum;
        for (int i = 1; i <= 13; i++) {
            randomNum = (int) ((Math.random() * 51) + 1);
            deckCardVals = addElement(deckCardVals.length, deckCardVals, randomNum);
        }
    }

    public String getDeck() {
        return Arrays.toString(deckCardVals);
    }

}
