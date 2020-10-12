package CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input=scan.nextLine();

        Box <String> box=new Box<>();
        while (!input.equals("END")) {
            String [] tokens=input.split("\\s+");
            String command=tokens[0];
            switch (command) {
                case "Add":
                    String element=tokens[1];
                    box.addElement(element);
                    break;
                case "Remove":
                    int index= Integer.parseInt(tokens[1]);
                    box.remove(index);
                    break;
                case "Contains":
                    String e=tokens[1];
                    System.out.println(box.contains(e));
                    break;
                case "Swap":
                    int indexOne= Integer.parseInt(tokens[1]);
                    int indexTwo=Integer.parseInt(tokens[2]);
                    box.swap(indexOne,indexTwo);
                    break;
                case "Greater":
                    String elementToCompare=tokens[1];
                    System.out.println(box.countGreaterThan(elementToCompare));
                    break;
                case "Max":
                    System.out.println(box.getMax());
                    break;
                case "Min":
                    System.out.println(box.getMin());
                    break;
                case "Print":
                    for (String current : box.getElements()) {
                        System.out.println(current);
                    }
                    break;
            }

            input=scan.nextLine();
        }
    }
}
