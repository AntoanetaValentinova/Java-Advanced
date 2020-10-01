import java.io.BufferedReader;
import java.io.File;

public class GetFolderSize {
    public static void main(String[] args) {
        File file =new File ("C:\\Users\\Antoaneta\\Desktop\\new\\04. Java-Advanced-Files-and-Streams-Exercises-Resources");

        long length=getFolderSize(file);
        System.out.printf("Folder size: %d",length);
    }
    public static long getFolderSize(File folder) {
        long length = 0;
        File[] files = folder.listFiles();

        int count = files.length;

        for (int i = 0; i < count; i++) {
            if (files[i].isFile()) {
                length += files[i].length();
            }
            else {
                length += getFolderSize(files[i]);
            }
        }
        return length;
    }
}
