import java.util.Scanner;
public class Tester {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean cont = true;
        while (cont) {
            ComputerDeck test = new ComputerDeck();
            test.AssignCards();
            System.out.println(test.getNumDeck());
            test.setLetterDeck();
            System.out.println(test.getLetterDeck());
            int cardVal = scan.nextInt();
            test.removeCard(cardVal);
            System.out.println(test.getNumDeck());
        }
    }
}
