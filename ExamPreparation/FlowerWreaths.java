import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FlowerWreaths {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Deque<Integer> liliesStack = new ArrayDeque<>();
                Arrays.stream(scan.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .forEach(e->liliesStack.push(e));

        Deque<Integer> rosesQueue = Arrays.stream(scan.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));

        int flowersLeft=0;


        int wreath = 0;
        while (!liliesStack.isEmpty()&&!rosesQueue.isEmpty()) {
            int currentLil = liliesStack.peek();
            int currentRose = rosesQueue.peek();
            if (currentLil + currentRose == 15) {
                wreath += 1;
                liliesStack.pop();
                rosesQueue.poll();
            } else if (currentLil + currentRose > 15) {
                liliesStack.push(liliesStack.pop()-2);
            } else if (currentLil + currentRose < 15) {
                flowersLeft+=liliesStack.pop();
                flowersLeft+=rosesQueue.poll();
            }
        }

       if (flowersLeft>=15) {
           wreath+=flowersLeft/15;
       }
        if (wreath >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!%n", wreath);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!%n",5-wreath);
        }
    }
}
