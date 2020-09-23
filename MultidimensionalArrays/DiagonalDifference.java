import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int size= Integer.parseInt(scan.nextLine());

        int [][] matrix=readMatrix(scan,size);

        int difference=findDifference(matrix);
        System.out.println(difference);
    }

    public static int findDifference (int [][] matrix) {
        int row=0;
        int col=0;
        int diff=0;
        int diagonalOne=0;
        int diagonalTwo=0;
        for (int r = 0; r <matrix.length ; r++) {
                diagonalOne+=matrix[row][col];
                row++;
                col++;
        }
        row=0;
        col=matrix.length-1;
        for (int i = 0; i <matrix.length ; i++) {
                diagonalTwo+=matrix[row][col];
                row++;
                col--;
        }
       return diff=Math.abs(diagonalOne-diagonalTwo);
    }

    public static int [][] readMatrix (Scanner scan,int size ) {
        int [][] matrix=new int [size][size];
        for (int i = 0; i <size ; i++) {
            matrix[i]= Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return matrix;
    }
}
