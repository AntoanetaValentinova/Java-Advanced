import java.util.Arrays;
import java.util.Scanner;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = scan.nextInt();
        int columns = scan.nextInt();
        scan.nextLine();

        int[][] matrix = fillMatrix(scan, rows, columns);
        printReversedDiagonals(matrix, rows, columns);
    }

    private static void printReversedDiagonals(int[][] matrix, int rows, int cols) {

        int counterRow = matrix[0].length - 1;
        for (int col = cols - 1; col >= 0; col--) {
            int counter = col + 1;
            System.out.print(matrix[matrix.length - 1][col] + " ");
            for (int row = rows - 2; row >= 0; row--) {
                if (counter < matrix[0].length) {
                    System.out.print(matrix[row][counter] + " ");
                }
                counter++;
            }
            System.out.println();
        }
        for (int row = rows - 2; row >= 0; row--) {
            System.out.print(matrix[row][0] + " ");
            int counter = 1;
            for (int col = 1; col < cols; col++) {
                if (row - counter >= 0) {
                    System.out.print(matrix[row - counter][col] + " ");
                }
                counter++;
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int[][] fillMatrix(Scanner scan, int rows, int columns) {
        int matrix[][] = new int[rows][columns];
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return matrix;
    }
}
