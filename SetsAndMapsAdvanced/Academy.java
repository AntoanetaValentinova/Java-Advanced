import java.text.DecimalFormat;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Academy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n= Integer.parseInt(scan.nextLine());

        Map<String,String> students=new TreeMap<>();
        for (int i = 0; i <n ; i++) {
            String studentName=scan.nextLine();
            String [] grades=scan.nextLine().split("\\s+");
            double average=0;
            for (int j = 0; j <grades.length ; j++) {
                average+=Double.parseDouble(grades[j]);
            }
            average=average/grades.length;
            DecimalFormat decimal=new DecimalFormat("0.#####################");
            String formated=decimal.format(average);
            students.put(studentName,formated);
        }


        students
                .entrySet()
                .stream()
                .forEach(s-> System.out.printf("%s is graduated with %s%n",s.getKey(),s.getValue()));
    }
}
