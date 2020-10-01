import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordCount {
    public static void main(String[] args) throws FileNotFoundException {

        BufferedReader docOne=new BufferedReader(new FileReader("C:\\Users\\Antoaneta\\Desktop\\new\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt"));
        BufferedReader docTwo=new BufferedReader(new FileReader("C:\\Users\\Antoaneta\\Desktop\\new\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt"));

        Stream<String> lines = docOne.lines();
        List<String> collect = lines.collect(Collectors.toList());
        String[] words=collect.get(0).split("\\s+");
        Stream<String> docTwoLines = docTwo.lines();
        List<String> collect1 = docTwoLines.collect(Collectors.toList());
        PrintWriter output=new PrintWriter("word-count.txt");


        for (int i = 0; i <words.length ; i++) {
            String currentWord=words[i];
            int counter=0;
            for (int j = 0; j <collect1.size() ; j++) {
                String [] currentLine=collect1.get(j).split("\\s+");
                for (int k = 0; k <currentLine.length ; k++) {
                    String currentWordToCompare=currentLine[k];
                    if (currentWord.equals(currentWordToCompare)) {
                        counter++;
                    }
                }
            }
            output.write(String.format("%s - %d%n",currentWord,counter));
        }
        output.close();

    }
}
