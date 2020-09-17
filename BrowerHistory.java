import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowerHistory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input=scan.nextLine();

        ArrayDeque<String> stack = new ArrayDeque<>();

        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (stack.size()>1) {
                    stack.pop();
                    System.out.println(stack.peek());
                } else {
                    System.out.println("no previous URLs");
                }
            } else {
                stack.push(input);
                System.out.println(input);
            }

            input=scan.nextLine();
        }
    }
}
