import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split(",\\s+");
        int size = Integer.parseInt(input[0]);
        String type = input[1];

        int[][] matrix=new int [size][size];
        if (type.equals("A")) {
            matrix = readMatrixA(size);
        } else if (type.equals("B")) {
            matrix = readMatrixB(size);
        }
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <matrix[i].length ; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static int[][] readMatrixB(int size) {
        int[][] matrix = new int[size][size];
        int number = 1;
        int row = 1;
        for (int i = 0; i <size; i++) {
            if (row % 2 != 0) {
                for (int c = 0; c < size; c++) {
                        matrix[c][row-1] = number;
                        number++;
                }
                row++;
            } else {
                int remember=row*size;
                number = row * size;
                for (int c = 0; c < size; c++) {
                        matrix[c][row-1] = number;
                        number--;
                }
                row++;
                number=remember+1;
            }
        }
        return matrix;
    }

    public static int[][] readMatrixA(int size) {
        int[][] matrix = new int[size][size];
        int number = 1;
        for (int c = 0; c < size; c++) {
            for (int r = 0; r < size; r++) {
                matrix[r][c] = number;
                number++;
            }
        }
        return matrix;
    }


}
