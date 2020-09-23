import java.util.Scanner;

public class MaxSumOf2x2Matrix {
    public static void main(String[] args) {
        Scanner scan=new Scanner(java.lang.System.in);

        String [] input=scan.nextLine().split(",\\s+");
        int rows= Integer.parseInt(input[0]);
        int columns= Integer.parseInt(input[1]);

        int [][] matrix= readMatrix(scan,rows,columns);

        int maxSum=Integer.MIN_VALUE;
        int [][] bestMatrix=new int[2][2];
        for (int i = 0; i <rows-1 ; i++) {
            for (int j = 0; j <columns-1 ; j++) {
                int sum=matrix[i][j]+matrix[i][j+1]+matrix[i+1][j]+matrix[i+1][j+1];
                if (sum>maxSum) {
                    maxSum=sum;
                    bestMatrix[0][0]=matrix[i][j];
                    bestMatrix[0][1]=matrix[i][j+1];
                    bestMatrix[1][0]=matrix[i+1][j];
                    bestMatrix[1][1]=matrix[i+1][j+1];
                }
            }
        }
        printMatrixAndSum(bestMatrix,maxSum);
    }

    public static void printMatrixAndSum(int [][] matrix,int sum) {
        for (int i = 0; i <2 ; i++) {
            for (int j = 0; j <2 ; j++) {
                System.out.println(matrix[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(sum);
    }

    public static int[][] readMatrix (Scanner scan, int rows, int columns) {
        int [][] matrix=new int [rows][columns];
        for (int i = 0; i <rows ; i++) {
            String [] currentRow=scan.nextLine().split(",\\s+");
            for (int j = 0; j <columns ; j++) {
                matrix[i][j]= Integer.parseInt(currentRow[j]);
            }
        }
        return matrix;
    }
}