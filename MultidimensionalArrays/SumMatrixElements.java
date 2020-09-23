import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String [] input=scan.nextLine().split(", ");
        int rows= Integer.parseInt(input[0]);
        int cols= Integer.parseInt(input[1]);

        int [][] matrix=readMatrix(scan,rows,cols);

        int sum=findSum(matrix);
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);
    }

    public static int findSum (int [][] matrix) {
        int sum=0;
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <matrix[0].length ; j++) {
                sum+=matrix[i][j];
            }
        }
        return sum;
    }

    public static int [] [] readMatrix(Scanner scan, int rows,int cols) {
        int [][] matrix=new int [rows][cols];
        for (int i = 0; i <rows ; i++) {
            String [] currentRow=scan.nextLine().split(",\\s+");
            for (int j = 0; j <cols ; j++) {
                matrix[i][j]= Integer.parseInt(currentRow[j]);
            }
        }
        return matrix;
    }
}
