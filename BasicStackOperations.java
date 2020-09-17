import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");

        int n = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);
        int x = Integer.parseInt(input[2]);

        String[] inputNumbers = scan.nextLine().split("\\s+");

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            stack.push(Integer.parseInt(inputNumbers[i]));
        }

        for (int i = 0; i < s; i++) {
            stack.pop();
        }

        if (stack.isEmpty()) {
            System.out.println(0);
        } else {

            int min = Integer.MAX_VALUE;
            if (stack.contains(x)) {
                System.out.println(true);
            } else {
                while (!stack.isEmpty()) {
                    int toRemove = stack.pop();
                    if (toRemove < min) {
                        min = toRemove;
                    }
                }
                System.out.println(min);
            }
        }

    }
}
