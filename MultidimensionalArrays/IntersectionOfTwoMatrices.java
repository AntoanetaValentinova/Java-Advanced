import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows= Integer.parseInt(scan.nextLine());
        int columns= Integer.parseInt(scan.nextLine());

        String [][] first =readMatrix(scan,rows,columns);
        String [][] second=readMatrix(scan,rows,columns);

        String [][] matrix=newMatrix(first,second);

        printMatrix(matrix);

    }

    public static void printMatrix (String [][] matrix) {
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <matrix[0].length ; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static String[][] newMatrix(String [][] first,String [][] second) {
        String [][]matrix=new String [first.length][first[0].length];
        for (int i = 0; i <first.length ; i++) {
            for (int j = 0; j <first[0].length ; j++) {
                if (first[i][j].equals(second[i][j])) {
                    matrix[i][j]=first[i][j];
                } else {
                    matrix[i][j]="*";
                }
            }
        }
        return matrix;
    }

    public static String[][] readMatrix (Scanner scan,int rows, int columns) {
        String [][] matrix=new String[rows][columns];
        for (int i = 0; i <rows ; i++) {
            String [] currentRow= scan.nextLine().split("\\s+");
            for (int j = 0; j <columns ; j++) {
                matrix[i][j]=currentRow[j];
            }
        }
        return matrix;
    }
}
