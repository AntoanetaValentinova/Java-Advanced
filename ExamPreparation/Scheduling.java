import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Scheduling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Deque<Integer> tasks = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .forEach(e->tasks.push(e));

        Deque<Integer> threads = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));

        int taskToKill= Integer.parseInt(scan.nextLine());

        boolean isTheTask=false;
        int thread=0;

        while (!isTheTask) {
            int currentTask=tasks.peek();
            int currentThread=threads.peek();
            if (currentTask==taskToKill) {
                thread=currentThread;
                isTheTask=true;
            } else if (currentThread>=currentTask) {
                tasks.pop();
                threads.poll();
            } else if (currentThread<currentTask) {
                threads.poll();
            }
        }

        System.out.printf("Thread with value %d killed task %d%n",thread,taskToKill);
        threads.stream()
                .forEach(e-> System.out.print(e+" "));
    }
}
