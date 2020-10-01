import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) throws IOException {

        String path="C:\\Users\\Antoaneta\\Desktop\\new\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream inputStream=new FileInputStream(path);

        int oneByte=inputStream.read();
        while (oneByte>=0) {
            System.out.print(Integer.toBinaryString(oneByte)+" ");
            oneByte=inputStream.read();
        }
    }
}
