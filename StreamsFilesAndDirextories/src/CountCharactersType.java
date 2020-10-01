import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountCharactersType {
    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader input=new BufferedReader(new FileReader("C:\\Users\\Antoaneta\\Desktop\\new\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));

        Stream<String> lines = input.lines();
        List<String> collect = lines.collect(Collectors.toList());

        int vowels=0;
        int consonants=0;
        int punctuation=0;
        for (String s : collect) {
            for (int i = 0; i <s.length() ; i++) {
                char current=s.charAt(i);
                if (current=='a'||current=='e'||current=='i'||current=='o'||current=='u') {
                    vowels++;
                } else if (current=='.'||current==','||current=='?'||current=='!') {
                    punctuation++;
                } else if (current!=' ') {
                    consonants++;
                }
            }
        }
        PrintWriter output=new PrintWriter("count-chars.txt");
        output.write(String.format("Vowels: %d%nConsonants: %d%nPunctuation: %d%n",vowels,consonants,punctuation));
        output.close();


    }
}
