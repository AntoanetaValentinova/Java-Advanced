import java.util.*;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();

        Map<String, Map<String, List<String>>> users = new TreeMap<>();
        while (!input.equals("end")) {
            String[] tokens = input.split("\\s+");
            String IP = tokens[0].substring(tokens[0].indexOf("=") + 1);
            String message = tokens[1].substring(tokens[1].indexOf("=") + 1);
            String user = tokens[2].substring(tokens[2].indexOf("=") + 1);
            users.putIfAbsent(user, new LinkedHashMap<>());
            users.get(user).putIfAbsent(IP, new ArrayList<>());
            users.get(user).get(IP).add(message);
            input = scan.nextLine();
        }

        Map<String, List<String>> map = new TreeMap<>();
        for (Map.Entry<String, Map<String, List<String>>> entry : users.entrySet()) {
            entry
                    .getValue()
                    .entrySet()
                    .forEach(IP -> {
                        map.putIfAbsent(entry.getKey(), new ArrayList<>());
                        map.get(entry.getKey()).add(IP.getKey()+" => "+IP.getValue().size());
                    });
        }
        map
                .entrySet()
                .stream()
                .forEach(u -> {
                    System.out.println(u.getKey() + ":");
                    System.out.printf(String.join(", ",u.getValue()));
                    System.out.println(".");
                });
    }
}
