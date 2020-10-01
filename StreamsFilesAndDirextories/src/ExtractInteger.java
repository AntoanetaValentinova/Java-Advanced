import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExtractInteger {
    public static void main(String[] args) throws FileNotFoundException {

        String path="C:\\Users\\Antoaneta\\Desktop\\new\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        Scanner scanner=new Scanner(new FileInputStream(path));

        PrintWriter writer=new PrintWriter("integers");

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int number=scanner.nextInt();
                writer.println(number);
            }
            scanner.next();
        }

        writer.flush();
        writer.close();
    }
}
