package JarOfT;

public class Main {

    public static void main(String[] args) {
        Jar <Integer> jar=new Jar();
        Jar <String> jar1=new Jar<>();

        jar.add(12);
        jar1.add("sd");

        jar.remove();
        jar1.remove();
    }
}
