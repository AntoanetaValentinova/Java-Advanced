import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AllCapitals {
    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader input=new BufferedReader(new FileReader("C:\\Users\\Antoaneta\\Desktop\\new\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));

        Stream<String> lines = input.lines();

        List<String> collect = lines.collect(Collectors.toList());
        PrintWriter print=new PrintWriter("allCapitals.txt");
        for (String s : collect) {
            String newLine=s.toUpperCase();
            print.write(newLine);
            print.write("\n");
        }

        print.flush();
        print.close();
    }
}
