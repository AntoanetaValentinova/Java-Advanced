import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] input = scan.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        String[][] matrix = readMatrix(scan, rows, cols);
        String inputLineTwo = scan.nextLine();

        while (!inputLineTwo.equals("END")) {
            String[] command = inputLineTwo.split("\\s+");
            if (command[0].equals("swap")) {
                if (command.length != 5) {
                    System.out.println("Invalid input!");
                } else {
                    int rowOne = Integer.parseInt(command[1]);
                    int colOne = Integer.parseInt(command[2]);
                    int rowTwo = Integer.parseInt(command[3]);
                    int colTwo = Integer.parseInt(command[4]);
                    if (isValid(rowOne,colOne,rowTwo,colTwo,matrix)) {
                        String positionOne=matrix[rowOne][colOne];
                        String positionTwo=matrix[rowTwo][colTwo];
                        matrix[rowOne][colOne]=positionTwo;
                        matrix[rowTwo][colTwo]=positionOne;
                        for (int i = 0; i <matrix.length ; i++) {
                            for (int j = 0; j <matrix[i].length ; j++) {
                                System.out.print(matrix[i][j]+" ");
                            }
                            System.out.println();
                        }
                    } else {
                        System.out.println("Invalid input!");
                    }
                }
            } else {
                System.out.println("Invalid input!");
            }
            inputLineTwo=scan.nextLine();
        }
        System.out.println();
    }

    public static boolean isValid (int r1,int c1, int r2, int c2, String [][]matrix) {
        if (r1>=0&&r1<matrix.length&&r2>=0&&r2<matrix.length&&c1>=0&&c1<matrix[0].length&&c2>=0&&c2<matrix[0].length) {
            return true;
        }
        return false;
    }

    public static String[][] readMatrix(Scanner scanner, int rows, int cols) {
        String[][] matrix = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            String[] currentRow = scanner.nextLine().split("\\s+");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = currentRow[j];
            }
        }
        return matrix;
    }
}
