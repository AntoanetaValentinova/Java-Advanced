import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input=scan.nextLine();

        TreeMap<Character,Integer> map=new TreeMap<>();

        for (int i = 0; i <input.length() ; i++) {
            char current=input.charAt(i);
            map.putIfAbsent(current,0);
            map.put(current,map.get(current)+1);
        }

        map
                .entrySet()
                .stream()
                .forEach(e-> System.out.printf("%s: %d time/s%n",e.getKey(),e.getValue()));
    }
}
