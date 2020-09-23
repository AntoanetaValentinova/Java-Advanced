import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[][] matrix = new String[8][8];
        for (int r = 0; r < 8; r++) {
            String[] currentRow = scan.nextLine().split("\\s+");
            for (int c = 0; c < 8; c++) {
                matrix[r][c] = currentRow[c];
            }
        }

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (matrix[row][col].equals("q")) {
                    boolean isUnique = true;
                    for (int up = 0; up < row; up++) {
                        if (matrix[up][col].equals("q")) {
                            isUnique = false;
                            break;
                        }
                    }
                    for (int down = row + 1; down < 8; down++) {
                        if (matrix[down][col].equals("q")) {
                            isUnique = false;
                            break;
                        }
                    }
                    for (int right = col + 1; right < 8; right++) {
                        if (matrix[row][right].equals("q")) {
                            isUnique = false;
                            break;
                        }
                    }
                    for (int left = 0; left < col; left++) {
                        if (matrix[row][left].equals("q")) {
                            isUnique = false;
                            break;
                        }
                    }
                    int counter = row;
                    for (int c = col + 1; c < 8; c++) {
                        counter++;
                        if (counter > 7) {
                            break;
                        }
                        if (matrix[counter][c].equals("q")) {
                            isUnique = false;
                            break;
                        }
                    }

                    counter = row;
                    for (int c = col - 1; c >= 0; c--) {
                        counter--;
                        if (counter < 0) {
                            break;
                        }
                        if (matrix[counter][c].equals("q")) {
                            isUnique = false;
                            break;
                        }
                    }

                    counter = row;
                    for (int c = col + 1; c < 8; c++) { //from q to Right Up
                        counter--;
                        if (counter < 0) {
                            break;
                        }
                        if (matrix[counter][c].equals("q")) {
                            isUnique = false;
                            break;
                        }
                    }

                    counter = row;
                    for (int c = col - 1; c >= 0; c--) { //from q to Left Down
                        counter++;
                        if (counter > 7) {
                            break;
                        }
                        if (matrix[counter][c].equals("q")) {
                            isUnique = false;
                            break;
                        }
                    }
                    if (isUnique) {
                        System.out.println(row + " " + col);
                    }
                }
            }
        }
        System.out.println();
    }
}
