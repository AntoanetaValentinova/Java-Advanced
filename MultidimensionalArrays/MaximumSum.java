import java.util.Arrays;
import java.util.Scanner;

public class MaximumSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String [] input=scan.nextLine().split("\\s+");
        int rows= Integer.parseInt(input[0]);
        int cols= Integer.parseInt(input[1]);

        int [][] matrix=readMatrix(scan,rows,cols);
        printMax(matrix);
        
    }
    
    public static void printMax (int [][]matrix) {
        int sum=0;
        int maxSum=Integer.MIN_VALUE;
        int [][] bestMatrix=new int[3][3];
        for (int r = 0; r <matrix.length-2 ; r++) {
            for (int c = 0; c <matrix[r].length-2 ; c++) {
                sum=matrix[r][c]+matrix[r][c+1]+matrix[r][c+2]
                        +matrix[r+1][c]+matrix[r+1][c+1]+matrix[r+1][c+2]
                        +matrix[r+2][c]+matrix[r+2][c+1]+matrix[r+2][c+2];
                if (sum>maxSum) {
                    maxSum=sum;
                    bestMatrix[0][0] = matrix[r][c];
                    bestMatrix[0][1] = matrix[r][c+1];
                    bestMatrix[0][2] =matrix[r][c+2];
                    bestMatrix[1][0] =matrix[r+1][c];
                    bestMatrix[1][1] =matrix[r+1][c+1];
                    bestMatrix[1][2] =matrix[r+1][c+2];
                    bestMatrix[2][0] =matrix[r+2][c];
                    bestMatrix[2][1] =matrix[r+2][c+1];
                    bestMatrix[2][2] =matrix[r+2][c+2];

                }
            }
        }
        System.out.println("Sum = "+maxSum);
        for (int i = 0; i <bestMatrix.length ; i++) {
            for (int j = 0; j <bestMatrix[i].length ; j++) {
                System.out.print(bestMatrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static int [][] readMatrix (Scanner scanner,int rows, int cols) {
        int [][] matrix=new int [rows][cols];
        for (int i = 0; i <rows ; i++) {
            matrix[i]= Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return matrix;
    }
}
