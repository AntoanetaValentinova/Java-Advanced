import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new FileReader("C:\\Users\\Antoaneta\\Desktop\\new\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt"));
        Stream<String> lines=reader.lines();
        List<String> linesList=lines.collect(Collectors.toList());

        BufferedWriter writer=new BufferedWriter(new FileWriter("everyThird.txt"));

        for (int i = 0; i <linesList.size() ; i++) {
            if ((i+1)%3==0) {
                writer.write(linesList.get(i));
                writer.newLine();
            }
        }

        writer.close();
    }
}
