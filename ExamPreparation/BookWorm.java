import java.util.Scanner;

public class BookWorm {
    public static int playerRow;
    public static int playerCol;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String initialString=scan.nextLine();
        int n= Integer.parseInt(scan.nextLine());
        char [][] matrix=new char[n][n];

        playerRow=0;
        playerCol=0;
        for (int r = 0; r <n ; r++) {
            String [] currentRow=scan.nextLine().split("");
            for (int c = 0; c <currentRow.length ; c++) {
                matrix[r][c]=currentRow[c].charAt(0);
                if (currentRow[c].charAt(0)=='P') {
                    playerRow=r;
                    playerCol=c;
                }
            }
        }

        matrix[playerRow][playerCol]='-';

        String command=scan.nextLine();
        while (!command.equals("end")) {
            if (command.equals("up")) {
                if (playerRow-1>=0) {
                   initialString= checkNextPosition(initialString,matrix,playerRow-1,playerCol);
                   playerRow--;
                } else {
                    initialString=getPunished(initialString);
                }
            } else if (command.equals("down")) {
                if (playerRow+1<matrix.length) {
                    initialString= checkNextPosition(initialString,matrix,playerRow+1,playerCol);
                    playerRow++;
                } else {
                    initialString=getPunished(initialString);
                }
            } else if (command.equals("right")) {
                if (playerCol+1<matrix[playerRow].length) {
                    initialString= checkNextPosition(initialString,matrix,playerRow,playerCol+1);
                    playerCol++;
                } else {
                    initialString=getPunished(initialString);
                }
            } else if (command.equals("left")) {
                if (playerCol-1>=0) {
                    initialString= checkNextPosition(initialString,matrix,playerRow,playerCol-1);
                    playerCol--;
                } else {
                    initialString=getPunished(initialString);
                }
            }
            command=scan.nextLine();
        }

        matrix[playerRow][playerCol]='P';
        System.out.println(initialString);
        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (int r = 0; r <matrix.length ; r++) {
            for (int c = 0; c <matrix[r].length ; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }

    private static String getPunished(String initialString) {
        if (initialString.length()>0) {
            initialString=initialString.substring(0,initialString.length()-1);
        }
        return initialString;
    }

    private static String checkNextPosition(String initialString, char[][] matrix, int playerRow, int playerCol) {
        if (matrix[playerRow][playerCol]!='-') {
            initialString=initialString+matrix[playerRow][playerCol];
            matrix[playerRow][playerCol]='-';
        }
        return  initialString;
    }
}
