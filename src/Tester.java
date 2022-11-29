public class Tester {
    public static void main(String[] args) {
        ComputerDeck test = new ComputerDeck();
        test.AssignCards();
        System.out.println(test.getNumDeck());
        System.out.println(test.getLetterDeck());
    }
}
