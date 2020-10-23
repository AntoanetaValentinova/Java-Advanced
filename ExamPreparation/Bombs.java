import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bombs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Deque<Integer> bombEffect  = Arrays.stream(scan.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toCollection(ArrayDeque::new));
        Deque<Integer> bombCasing =new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .forEach(e->bombCasing.push(e));

        int daturaBombs=0;
        int cherryBombs=0;
        int smokeDecoyBombs=0;

        while (!bombEffect.isEmpty()&&!bombCasing.isEmpty()) {
            int currentEffect=bombEffect.peek();
            int currentCasing=bombCasing.peek();
            int sum=currentEffect+currentCasing;
            if (sum==40) {
                daturaBombs+=1;
                bombEffect.poll();
                bombCasing.pop();
            } else if (sum==60) {
                cherryBombs+=1;
                bombEffect.poll();
                bombCasing.pop();
            } else if (sum==120) {
                smokeDecoyBombs+=1;
                bombEffect.poll();
                bombCasing.pop();
            } else {
                bombCasing.push(bombCasing.pop()-5);
            }
            if (daturaBombs>=3&&cherryBombs>=3&&smokeDecoyBombs>=3){
                break;
            }
        }
        if (daturaBombs>=3&&cherryBombs>=3&&smokeDecoyBombs>=3) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        if (bombEffect.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            System.out.print("Bomb Effects: ");
            StringBuilder sb=new StringBuilder();
            for (Integer effect : bombEffect) {
                sb.append(effect+", ");
            }
            System.out.println(sb.substring(0, sb.lastIndexOf(", ")));
        }

        if (bombCasing.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            System.out.print("Bomb Casings: ");
            StringBuilder sb=new StringBuilder();
            for (Integer casing : bombCasing) {
                sb.append(casing+", ");
            }
            System.out.println(sb.substring(0, sb.lastIndexOf(", ")));
        }
        System.out.println("Cherry Bombs: "+cherryBombs);
        System.out.println("Datura Bombs: "+daturaBombs);
        System.out.println("Smoke Decoy Bombs: "+smokeDecoyBombs);
    }
}
