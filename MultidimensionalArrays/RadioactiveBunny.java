import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RadioactiveBunny {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = scan.nextInt();
        int cols = scan.nextInt();
        scan.nextLine();

        char[][] matrix = readMatrix(scan, rows, cols);
        String[] commands = scan.nextLine().split("");

        int rowPlayer = 0;
        int colPlayer = 0;
        boolean isDead = false;
        boolean isSurvive = false;
        for (int command = 0; command < commands.length; command++) {
            List<List<Integer>> bunniesInitialPositionsForTheTurn = new ArrayList<>();
            String currentCommand = commands[command];
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    if (matrix[r][c] == 'B') {
                        List<Integer> currentBunny = new ArrayList<>();
                        currentBunny.add(r);
                        currentBunny.add(c);
                        bunniesInitialPositionsForTheTurn.add(currentBunny);
                    }
                    if (matrix[r][c] == 'P') {
                        rowPlayer = r;
                        colPlayer = c;
                    }
                }
            }


            for (int i = 0; i < bunniesInitialPositionsForTheTurn.size(); i++) {
                int rowCurrentBunny = bunniesInitialPositionsForTheTurn.get(i).get(0);
                int colCurrentBunny = bunniesInitialPositionsForTheTurn.get(i).get(1);
                if (rowCurrentBunny - 1 >= 0 && rowCurrentBunny - 1 < matrix.length) { //go up
                    matrix[rowCurrentBunny - 1][colCurrentBunny] = 'B';
                }
                if (rowCurrentBunny + 1 >= 0 && rowCurrentBunny + 1 < matrix.length) { //go down
                    matrix[rowCurrentBunny + 1][colCurrentBunny] = 'B';
                }
                if (colCurrentBunny + 1 >= 0 && colCurrentBunny + 1 < matrix[rowCurrentBunny].length) { //go right
                    matrix[rowCurrentBunny][colCurrentBunny + 1] = 'B';
                }
                if (colCurrentBunny - 1 >= 0 && colCurrentBunny - 1 < matrix[rowCurrentBunny].length) { //go left
                    matrix[rowCurrentBunny][colCurrentBunny - 1] = 'B';
                }
            }

            if (matrix[rowPlayer][colPlayer] != 'B') {
                matrix[rowPlayer][colPlayer] = '.';
            }
            if (currentCommand.equals("U")) { //go up
                if (rowPlayer - 1 >= 0 && rowPlayer - 1 < matrix.length && matrix[rowPlayer - 1][colPlayer] == '.') {
                    matrix[rowPlayer - 1][colPlayer] = 'P';
                    rowPlayer--;
                } else if (rowPlayer - 1 >= 0 && rowPlayer - 1 < matrix.length && matrix[rowPlayer - 1][colPlayer] == 'B') {
                    isDead = true;
                    rowPlayer--;
                } else if (rowPlayer-1<0) {
                    isSurvive=true;
                }
            } else if (currentCommand.equals("D")) { //go down
                if (rowPlayer + 1 >= 0 && rowPlayer + 1 < matrix.length && matrix[rowPlayer + 1][colPlayer] == '.') {
                    matrix[rowPlayer + 1][colPlayer] = 'P';
                    rowPlayer++;
                } else if (rowPlayer + 1 >= 0 && rowPlayer + 1 < matrix.length && matrix[rowPlayer + 1][colPlayer] == 'B') {
                    isDead = true;
                    rowPlayer++;
                } else if (rowPlayer+1>=matrix.length) {
                    isSurvive=true;
                }
            } else if (currentCommand.equals("R")) { // go right
                if (colPlayer + 1 >= 0 && colPlayer + 1 < matrix[rowPlayer].length && matrix[rowPlayer][colPlayer + 1] == '.') {
                    matrix[rowPlayer][colPlayer + 1] = 'P';
                    colPlayer++;
                } else if (colPlayer + 1 >= 0 && colPlayer + 1 < matrix[rowPlayer].length && matrix[rowPlayer][colPlayer + 1] == 'B') {
                    isDead = true;
                    colPlayer++;
                } else if (colPlayer+1>=matrix[rowPlayer].length) {
                    isSurvive=true;
                }
            } else if (currentCommand.equals("L")) { //goLeft
                if (colPlayer - 1 >= 0 && colPlayer - 1 < matrix[rowPlayer].length && matrix[rowPlayer][colPlayer - 1] == '.') {
                    matrix[rowPlayer][colPlayer - 1] = 'P';
                    colPlayer--;
                } else if (colPlayer - 1 >= 0 && colPlayer - 1 < matrix[rowPlayer].length && matrix[rowPlayer][colPlayer - 1] == 'B') {
                    isDead = true;
                    colPlayer--;
                } else if (colPlayer-1<0) {
                    isSurvive=true;
                }
            }
            if (isDead||isSurvive) {
                break;
            }
        }
        if (isDead) {
            printMatrix(matrix);
            System.out.println("dead: " + rowPlayer + " " + colPlayer);
        } else if (!isDead||isSurvive){
            printMatrix(matrix);
            System.out.println("won: " + rowPlayer + " " + colPlayer);
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }

    private static char[][] readMatrix(Scanner scan, int rows, int cols) {
        char matrix[][] = new char[rows][cols];
        for (int r = 0; r < rows; r++) {
            String[] currentRow = scan.nextLine().split("");
            for (int c = 0; c < cols; c++) {
                matrix[r][c] = currentRow[c].charAt(0);
            }
        }
        return matrix;
    }
}
