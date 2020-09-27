import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WarGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedHashSet <Integer> firstPlayerCards= Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        LinkedHashSet <Integer> secondPlayerCards= Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        int rounds=50;

        while (rounds>0&&!firstPlayerCards.isEmpty()&&!secondPlayerCards.isEmpty()) {
            int cardPlayerOne=firstPlayerCards.iterator().next();
            int cardPlayerTwo=secondPlayerCards.iterator().next();
            firstPlayerCards.remove(cardPlayerOne);
            secondPlayerCards.remove(cardPlayerTwo);
            if (cardPlayerOne>cardPlayerTwo) {
               firstPlayerCards.add(cardPlayerOne);
               firstPlayerCards.add(cardPlayerTwo);
            } else if (cardPlayerTwo>cardPlayerOne) {
                secondPlayerCards.add(cardPlayerOne);
                secondPlayerCards.add(cardPlayerTwo);
            }
            rounds--;
        }

        if (secondPlayerCards.size()>firstPlayerCards.size()) {
            System.out.println("Second player win!");
        } else if (firstPlayerCards.size()>secondPlayerCards.size()) {
            System.out.println("First player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}
