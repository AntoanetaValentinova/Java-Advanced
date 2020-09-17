import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");

        int n = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);
        int x = Integer.parseInt(input[2]);

        String[] inputNumbers = scan.nextLine().split("\\s+");

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            queue.offer(Integer.parseInt(inputNumbers[i]));
        }

        for (int i = 0; i < s; i++) {
            queue.poll();
        }

        if (queue.isEmpty()) {
            System.out.println(0);
        } else {

            int min = Integer.MAX_VALUE;
            if (queue.contains(x)) {
                System.out.println(true);
            } else {
                while (!queue.isEmpty()) {
                    int toRemove = queue.poll();
                    if (toRemove < min) {
                        min = toRemove;
                    }
                }
                System.out.println(min);
            }
        }
    }
}
