import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class NestedFolders {
    public static void main(String[] args) {
        File file = new File ("C:\\Users\\Antoaneta\\Desktop\\new\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        Deque<File> deque=new ArrayDeque<>();

        deque.add(file);

        int count=0;
        while (!deque.isEmpty()) {
            File f=deque.poll();
            count++;
            File[] files = f.listFiles();
            System.out.println(f.getName());
            for (File file1 : files) {
                if (file1.isDirectory()) {
                    deque.offer(file1);
                }
            }
        }
        System.out.println(count+" folders");
    }
}
