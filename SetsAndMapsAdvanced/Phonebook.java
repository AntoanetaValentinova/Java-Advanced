import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input=scan.nextLine();

        Map<String,String> phonebook=new LinkedHashMap<>();
        while (!input.equals("search")) {
            String []tokens=input.split("\\-");
            String name=tokens[0];
            String phoneNumber=tokens[1];
            phonebook.put(name,phoneNumber);
            input=scan.nextLine();
        }

        input=scan.nextLine();

        while (!input.equals("stop")) {
            if (phonebook.containsKey(input)) {
                System.out.printf("%s -> %s%n",input,phonebook.get(input));
            } else {
                System.out.printf("Contact %s does not exist.%n",input);
            }
            input=scan.nextLine();
        }
    }
}
