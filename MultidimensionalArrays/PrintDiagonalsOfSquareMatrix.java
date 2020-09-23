import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int number= Integer.parseInt(scan.nextLine());

        int [][] matrix=readMatrix(scan,number);

        for (int i = 0; i <matrix.length; i++) {
            System.out.print(matrix[i][i]+" ");
        }
        System.out.println();
        for (int i = 0; i <matrix.length ; i++) {
            System.out.print(matrix[(number-1)-i][i]+" ");
        }

    }




    public static int [][] readMatrix (Scanner scan, int num) {
        int [][] matrix=new int[num][num];
        for (int i = 0; i <num; i++) {
            matrix [i]= Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return matrix;
    }
}
