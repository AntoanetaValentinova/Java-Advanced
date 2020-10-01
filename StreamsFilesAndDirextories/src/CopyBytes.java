import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) throws IOException {
        String path="C:\\Users\\Antoaneta\\Desktop\\new\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream input=new FileInputStream(path);

        int nextByte=input.read();

        FileOutputStream outputStream=new FileOutputStream("copyBytes");

        while (nextByte>=0) {
            if ((char)nextByte!=' '&&(char) nextByte!='\n') {
                outputStream.write(String.valueOf(nextByte).getBytes());
            } else {
                outputStream.write(nextByte);
            }

            nextByte=input.read();
        }
    }
}
