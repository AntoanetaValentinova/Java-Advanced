import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input=scan.nextLine();

        Map<String,String> emails=new LinkedHashMap<>();
        while (!input.equals("stop")) {
            String name=input;
            String email=scan.nextLine();
            String ends=email.substring(email.lastIndexOf(".")+1);
            if (!ends.equals("us")&&!ends.equals("uk")&&!ends.equals("com")) {
                emails.put(name,email);
            }
            input=scan.nextLine();
        }

        emails
                .entrySet()
                .stream()
                .forEach(e-> System.out.printf("%s -> %s%n",e.getKey(),e.getValue()));
    }
}
