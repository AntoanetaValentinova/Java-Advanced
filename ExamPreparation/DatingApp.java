import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DatingApp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Deque<Integer> male=new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(e->male.push(e));

        Deque<Integer> female=Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int matches=0;
        while (!male.isEmpty()&&!female.isEmpty()) {
            int women=female.peek();
            int man=male.peek();
            if (women<=0||man<=0) {
                if (women<=0) {
                    female.poll();
                }
                if (man<=0) {
                    male.pop();
                }
            } else if (women%25==0||man%25==0) {
                if (women%25==0) {
                    female.poll();
                    female.poll();
                }
                if (man%25==0) {
                    male.pop();
                    male.pop();
                }
            } else {
                if (women==man) {
                    matches++;
                    male.pop();
                    female.poll();
                } else {
                    female.poll();
                    male.push(male.pop()-2);
                }
            }
        }

        System.out.println("Matches: "+matches);
        if (!male.isEmpty()) {
            System.out.print("Males left: ");
            System.out.println(male.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        } else {
            System.out.println("Males left: none");
        }

        if (!female.isEmpty()) {
            System.out.print("Females left: ");
            System.out.println(female.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        } else {
            System.out.println("Females left: none");
        }
    }
}
