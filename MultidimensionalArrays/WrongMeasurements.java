import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = Integer.parseInt(scan.nextLine());

        int[][] matrix = readMatrix(scan, rows);

        String[] positions = scan.nextLine().split("\\s+");
        int row = Integer.parseInt(positions[0]);
        int col = Integer.parseInt(positions[1]);

        int wrongNumber = matrix[row][col];

        int[][] newMatrix = findNewMatrix(matrix, wrongNumber);
        printMatrix(newMatrix);
    }

    public static void printMatrix (int [][] matrix) {
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <matrix[i].length ; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static int[][] findNewMatrix(int[][] matrix, int wrongNumber) {
        int [][] newMatrix=new int [matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == wrongNumber) {
                    int sumToReplace = 0;
                    if ((i-1) >= 0 && (i-1) < matrix.length&&matrix[i - 1][j]!=wrongNumber) {
                        sumToReplace += matrix[i - 1][j];
                    }
                    if ((i + 1) >= 0 && (i + 1)< matrix.length&&matrix[i + 1][j]!=wrongNumber) {
                        sumToReplace += matrix[i + 1][j];
                    }
                    if ((j - 1) >= 0 && (j - 1) < matrix[i].length&&matrix[i][j - 1]!=wrongNumber) {
                        sumToReplace += matrix[i][j - 1];
                    }
                    if ((j + 1) >= 0 && (j + 1) < matrix[i].length&&matrix[i][j + 1]!=wrongNumber) {
                        sumToReplace += matrix[i][j + 1];
                    }
                    newMatrix[i][j] = sumToReplace;
                } else {
                    newMatrix [i][j] =matrix[i][j];
                }
            }
        }
        return newMatrix;
    }

    public static int[][] readMatrix(Scanner scan, int rows) {
        int[][] matrix = new int[rows][];
        for (int i = 0; i < rows; i++) {
            int[] currentRow = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[i] = currentRow;
        }
        return matrix;
    }
}
