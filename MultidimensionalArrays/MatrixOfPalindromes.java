import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String [] input=scan.nextLine().split("\\s+");
        int rows= Integer.parseInt(input[0]);
        int columns= Integer.parseInt(input[1]);

        String [][] matrix=findPalindromeMatrix(rows,columns);

        printMatrix(matrix);
    }

    public static void printMatrix (String [][] matrix) {
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <matrix[i].length ; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static String[][] findPalindromeMatrix(int rows, int columns) {
        String [][] matrix=new String [rows][columns];
        char first=97;
        char second=97;
        char secondSec=97;
        char third=97;
        for (int r = 0; r <rows ; r++) {
            for (int c = 0; c <columns ; c++) {
                String current=first+""+second+""+third;
                matrix [r][c] = current;
                second++;
            }
           first++;
            secondSec++;
            third++;
            second=secondSec;
        }
        return matrix;
    }
}
