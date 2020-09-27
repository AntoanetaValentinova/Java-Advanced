import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numberOfStudents = scan.nextInt();
        scan.nextLine();

        Map<String, List<Double>> students = new TreeMap<>();
        for (int i = 0; i < numberOfStudents; i++) {
            String[] currentStudent = scan.nextLine().split("\\s+");
            String studentName = currentStudent[0];
            double grade = Double.parseDouble(currentStudent[1]);
            students.putIfAbsent(studentName, new ArrayList<>());
            students.get(studentName).add(grade);
        }

        students
                .entrySet()
                .stream()
                .forEach(s -> {
                    System.out.printf("%s -> ", s.getKey());
                    s.getValue()
                            .stream()
                            .forEach(g -> System.out.printf("%.2f ",g));

                    double avg = s.getValue()
                            .stream()
                            .mapToDouble(e->e)
                            .average()
                            .getAsDouble();
                    System.out.printf("(avg: %.2f)%n",avg );
                });


    }

}

