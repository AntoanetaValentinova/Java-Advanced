import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

       int [][] matrixOne=readMatrix(scan);
       int [][] matrixTwo=readMatrix(scan);

       if (isEqual(matrixOne,matrixTwo)) {
           System.out.println("equal");
       } else {
           System.out.println("not equal");
       }
    }

    public static boolean isEqual (int [][] matrixOne, int[][] matrixTwo) {
        if (matrixOne.length!=matrixTwo.length) {
            return false;
        }
        for (int rows = 0; rows <matrixOne.length ; rows++) {
            if (matrixOne[rows].length!=matrixTwo[rows].length) {
                return false;
            }
        }
        for (int rows = 0; rows <matrixOne.length ; rows++) {
            for (int columns = 0; columns <matrixOne[rows].length ; columns++) {
                if (matrixOne[rows][columns]!=matrixTwo[rows][columns]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int[][] readMatrix (Scanner scan) {
        String [] input=scan.nextLine().split("\\s+");
        int rows= Integer.parseInt(input[0]);
        int columns = Integer.parseInt(input[1]);

        int [][] matrix=new int [rows][columns];

        for (int i = 0; i <rows ; i++) {
            String [] currentRow=scan.nextLine().split("\\s+");
            for (int j = 0; j <columns ; j++) {
                matrix[i][j]= Integer.parseInt(currentRow[j]);
            }
        }
        return matrix;
    }
}
