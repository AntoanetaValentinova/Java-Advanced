import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LineNumbers {
    public static void main(String[] args) throws FileNotFoundException {

        BufferedReader input=new BufferedReader(new FileReader("C:\\Users\\Antoaneta\\Desktop\\new\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt"));
        Stream<String> lines = input.lines();
        List<String> collect = lines.collect(Collectors.toList());
        PrintWriter output=new PrintWriter("line-numbers.txt");

        int counter=1;
        for (String s : collect) {
             output.write(counter+". "+s+"\n");
             counter++;
        }
        output.close();
    }
}
