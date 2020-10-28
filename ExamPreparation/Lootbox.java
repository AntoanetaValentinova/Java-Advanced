import java.util.*;
import java.util.stream.Collectors;

public class Lootbox {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Deque<Integer> firstBox=Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));

        Deque<Integer> secondBox=new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .forEach(e->secondBox.push(e));

        int claimedItems=0;

        while (!firstBox.isEmpty()&&!secondBox.isEmpty()) {
            int firstNumber=firstBox.peek();
            int secondNumber=secondBox.peek();
            int sum=firstNumber+secondNumber;
            if (sum%2==0) {
                claimedItems+=sum;
                firstBox.poll();
                secondBox.pop();
            } else {
                int numberToMove=secondBox.pop();
                firstBox.offer(numberToMove);
            }
        }

        if (firstBox.isEmpty()) {
            System.out.println("First lootbox is empty");
        } else if (secondBox.isEmpty()) {
            System.out.println("Second lootbox is empty");
        }

        if (claimedItems>=100) {
            System.out.println("Your loot was epic! Value: "+claimedItems);
        } else {
            System.out.println("Your loot was poor... Value: "+claimedItems);
        }
    }
}
