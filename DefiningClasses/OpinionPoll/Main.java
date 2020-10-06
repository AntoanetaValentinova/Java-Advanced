package OpinionPoll;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            if (age > 30) {
                Person person = new Person(name, age);
                personList.add(person);
            }
        }

        personList
                .stream()
                .sorted(Comparator.comparing(Person::getName))
                .forEach(p-> System.out.printf("%s - %d%n",p.getName(),p.getAge()));
    }
}
