import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SumLines {

    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader input=new BufferedReader(new FileReader("C:\\Users\\Antoaneta\\Desktop\\new\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));

        Stream<String> lines = input.lines();

        List<String> collect = lines.collect(Collectors.toList());

        for (String line:collect) {
            String currentLine=line;
            int sumLine=0;
            for (int i = 0; i <currentLine.length() ; i++) {
                char currentSymbol=currentLine.charAt(i);
                sumLine=sumLine+currentSymbol;
            }
            System.out.println(sumLine);
        }
    }
}
