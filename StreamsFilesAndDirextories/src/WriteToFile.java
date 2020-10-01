import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteToFile {
    public static void main(String[] args) throws IOException {

        String path = "C:\\Users\\Antoaneta\\Desktop\\new\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        FileInputStream input = new FileInputStream(path);

        String punctuation = ",.!?";
        int nextByte = input.read();

        FileOutputStream output = new FileOutputStream("output");

        while (nextByte >= 0) {
            if (!punctuation.contains(String.valueOf((char)nextByte))) {
                output.write((char) nextByte);
            }
            nextByte = input.read();
        }
    }
}
