import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Garden {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int [] dimensionsInfo= Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows=dimensionsInfo[0];
        int cols=dimensionsInfo[1];
        int [][] garden=new int[rows][cols];

        List<String> initialPositions=new ArrayList<>();
        String input=scan.nextLine();
        while (!input.equals("Bloom Bloom Plow")) {
            String [] currentPositionInfo=input.split("\\s+");
            int row = Integer.parseInt(currentPositionInfo[0]);
            int col = Integer.parseInt(currentPositionInfo[1]);
            if (row<0||row>garden.length-1||col<0||col>garden[row].length-1) {
                System.out.println("Invalid coordinates.");
            } else {
                bloomTheFlowers(row,col,garden);
            }
             input=scan.nextLine();
        }

        printGarden(garden);

    }

    private static void bloomTheFlowers(int row, int col, int[][] garden) {
        garden[row][col]=1;
        for (int r = 0; r <row ; r++) { //bloomUp
            garden[r][col]+=1;
        }
        for (int r = row+1; r <garden.length ; r++) { //bloomDown
            garden[r][col]+=1;
        }
        for (int c = col+1; c <garden[row].length ; c++) { //bloomRight
            garden[row][c]+=1;
        }
        for (int c = 0; c <row ; c++) { //bloomLeft
            garden[row][c]+=1;
        }
    }

    public static void printGarden(int[][] garden) {
        for (int r = 0; r < garden.length; r++) {
            for (int c = 0; c < garden[r].length; c++) {
                System.out.print(garden[r][c]+" ");
            }
            System.out.println();
        }
    }
}
