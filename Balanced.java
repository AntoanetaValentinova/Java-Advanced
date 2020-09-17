import java.util.ArrayDeque;
import java.util.Scanner;

public class Balanced {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String [] input=scan.nextLine().split("");

        ArrayDeque <String> stack = new ArrayDeque<>();

        boolean isBalanced=true;

        for (int i = 0; i <input.length ; i++) {
            if (input[i].equals("{")||input[i].equals("(")||input[i].equals("[")) {
                stack.push("}");
            } else {
               if (stack.isEmpty()||!stack.pop().equals(input[i])) {
                   isBalanced=false;
                   break;
               }
            }
        }

        if (isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
