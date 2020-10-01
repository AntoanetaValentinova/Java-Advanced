import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeTwoFiles {
    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader docOne=new BufferedReader(new FileReader("C:\\Users\\Antoaneta\\Desktop\\new\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt"));
        BufferedReader docTwo=new BufferedReader(new FileReader("C:\\Users\\Antoaneta\\Desktop\\new\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt"));
        PrintWriter output=new PrintWriter("merge.txt");

        Stream<String> lines = docOne.lines();
        List<String> collect = lines.collect(Collectors.toList());
        for (String s : collect) {
            output.write(s+"\n");
        }

        Stream<String> docTwoLines = docTwo.lines();
        List<String> collect1 = docTwoLines.collect(Collectors.toList());
        for (String s : collect1) {
            output.write(s+"\n");
        }

        output.close();



    }
}
