import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        int degrees = Integer.parseInt(input.substring(input.indexOf("(") + 1, input.indexOf(")"))) % 360;

        input = scan.nextLine();
        ArrayList<String> strings = new ArrayList<>();
        int maxLength = 0;

        while (!input.equals("END")) {
            strings.add(input);
            if (input.length() > maxLength) {
                maxLength = input.length();
            }
            input = scan.nextLine();
        }

        char[][] matrix = fillMatrix(strings, maxLength);
        printMatrix(matrix,degrees);

    }

    private static void printMatrix(char[][] matrix, int degrees) {
        if (degrees==90) {
            for (int col = 0; col <matrix[0].length ; col++) {
                for (int row = matrix.length-1; row >=0 ; row--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else if (degrees==180) {
            for (int row = matrix.length-1; row >=0 ; row--) {
                for (int col = matrix[0].length-1; col >=0 ; col--) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else if (degrees==270) {
            for (int col = matrix[0].length-1; col >=0 ; col--) {
                for (int row = 0; row <matrix.length ; row++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        } else {
            for (int row = 0; row <matrix.length ; row++) {
                for (int col = 0; col <matrix[0].length ; col++) {
                    System.out.print(matrix[row][col]);
                }
                System.out.println();
            }
        }
    }

    private static char[][] fillMatrix(ArrayList<String> strings, int maxLength) {
        char[][] matrix = new char[strings.size()][maxLength];
        for (int row = 0; row < strings.size(); row++) {
            for (int col = 0; col < maxLength; col++) {
                if (col < strings.get(row).length()) {
                    matrix[row][col] = strings.get(row).charAt(col);
                } else {
                    matrix[row][col] = ' ';
                }
            }
        }
        return matrix;
    }
}
