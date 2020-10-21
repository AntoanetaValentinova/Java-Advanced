import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FilterByAge {

    public static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());


        List<Person> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] personInfo = scan.nextLine().split(", ");
            Person person = new Person(personInfo[0], Integer.parseInt(personInfo[1]));
            people.add(person);
        }


        String command = scan.nextLine();
        int ageBorder = Integer.parseInt(scan.nextLine());
        String howToPrint = scan.nextLine();
        Function<Person, String> function = formatter(howToPrint);

        if (command.equals("younger")) {
            String output=people
                    .stream()
                    .filter(e->e.getAge()<=ageBorder)
                    .map(function)
                    .collect(Collectors.joining(System.lineSeparator()));
            System.out.println(output);
        } else if (command.equals("older")) {
            String output=people
                    .stream()
                    .filter(e->e.getAge()>=ageBorder)
                    .map(function)
                    .collect(Collectors.joining(System.lineSeparator()));
            System.out.println(output);
        }


    }

    private static Function<Person, String> formatter(String howToPrint) {
        if (howToPrint.equals("name")) {
            return p -> p.getName();
        } else if (howToPrint.equals("age")) {
            return p -> String.valueOf(p.getAge());
        }
        return p -> p.getName() + " - " + p.getAge();
    }


}
