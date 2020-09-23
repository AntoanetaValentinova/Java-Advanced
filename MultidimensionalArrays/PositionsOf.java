import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows=scan.nextInt();
        int columns=scan.nextInt();
        scan.nextLine();

        int [][] matrix=new int[rows][columns];

        for (int row = 0; row <rows ; row++) {
            int [] currentRow= Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int col = 0; col <currentRow.length ; col++) {
                matrix[row][col]=currentRow[col];
            }
        }

        int number= Integer.parseInt(scan.nextLine());

        boolean isFound=false;
        for (int r = 0; r <matrix.length ; r++) {
            for (int c = 0; c <matrix[0].length ; c++) {
                if (matrix[r][c]==number) {
                    System.out.println(r+" "+c);
                    isFound=true;
                }
            }
        }

        if (!isFound) {
            System.out.println("not found");
        }
    }
}
