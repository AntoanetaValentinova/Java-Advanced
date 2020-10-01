import java.io.File;

public class List {
    public static void main(String[] args) {

        File file = new File ("C:\\Users\\Antoaneta\\Desktop\\new\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");
        File[] files = file.listFiles();

        for (File f: files) {
            if (!f.isDirectory()) {
                System.out.println(f.getName()+": ["+f.length()+"]");
            }
        }
    }
}
