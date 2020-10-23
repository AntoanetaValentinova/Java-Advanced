import java.util.Scanner;

public class ReVolt2 {

    public static int playerRow=0;
    public static int playerCol=0;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int countOfCommands = Integer.parseInt(scan.nextLine());

        char[][] field = new char[n][n];

        playerRow = 0;
        playerCol = 0;

        for (int r = 0; r < n; r++) {
            String[] currentRow = scan.nextLine().split("");
            for (int c = 0; c < n; c++) {
                field[r][c] = currentRow[c].charAt(0);
                if (currentRow[c].charAt(0) == 'f') {
                    playerRow = r;
                    playerCol = c;
                }
            }
        }

        field[playerRow][playerCol] = '-';

        boolean isWinning=false;
        for (int i = 0; i < countOfCommands; i++) {
            String command = scan.nextLine();
            int oldRow = playerRow;
            int oldCol = playerCol;
            if (command.equals("up")) {
                playerRow = moveUp(field, playerRow - 1);
                if (checkNextPosition(command,oldRow,oldCol,field)) {
                    System.out.println("Player won!");
                    isWinning=true;
                    break;
                }
            } else if (command.equals("down")) {
                playerRow = moveDown(field, playerRow + 1);
                if (checkNextPosition(command,oldRow,oldCol,field)) {
                    System.out.println("Player won!");
                    isWinning=true;
                    break;
                }
            } else if (command.equals("right")) {
                playerCol = moveRight(field, playerCol + 1);
                if (checkNextPosition(command,oldRow,oldCol,field)) {
                    System.out.println("Player won!");
                    isWinning=true;
                    break;
                }
            } else if (command.equals("left")) {
                playerCol = moveLeft(field, playerCol - 1);
                if (checkNextPosition(command,oldRow,oldCol,field)) {
                    System.out.println("Player won!");
                    isWinning=true;
                    break;
                }
            }
        }
        field[playerRow][playerCol]='f';
        if (!isWinning) {
            System.out.println("Player lost!");
        }
        printField(field);
    }

    private static boolean checkNextPosition(String command,int oldRow, int oldCol, char[][] field) {
        char currentPosition=field[playerRow][playerCol];
        if (currentPosition=='F') {
            return true;
        } else if (currentPosition=='T') {
            playerRow=oldRow;
            playerCol=oldCol;
        } else if (currentPosition=='B') {
            if (command.equals("up")) {
                playerRow = moveUp(field, playerRow - 1);
                if (checkNextPosition(command,oldRow,oldCol,field)) {
                    return true;
                }
            } else if (command.equals("down")) {
                playerRow = moveDown(field, playerRow + 1);
                if (checkNextPosition(command,oldRow,oldCol,field)) {
                    return true;
                }
            } else if (command.equals("right")) {
                playerCol = moveRight(field, playerCol + 1);
                if (checkNextPosition(command,oldRow,oldCol,field)) {
                    return true;
                }
            } else if (command.equals("left")) {
                playerCol = moveLeft(field, playerCol - 1);
                if (checkNextPosition(command,oldRow,oldCol,field)) {
                    return true;
                }
            }
        }
        return false ;
    }

    public static int moveUp(char[][] field, int playerRow) {
        if (playerRow < 0) {
            playerRow = field.length - 1;
        }
        return playerRow;
    }
    public static int moveDown(char[][] field, int playerRow) {
        if (playerRow > field.length-1) {
            playerRow = 0;
        }
        return playerRow;
    }

    public static int moveRight(char[][] field, int playerCol) {
        if (playerCol > field.length-1) {
            playerCol = 0;
        }
        return playerCol;
    }

    public static int moveLeft(char[][] field, int playerCol) {
        if (playerCol < 0) {
            playerCol = field.length-1;
        }
        return playerCol;
    }


    public static void printField(char[][] field) {
        for (int r = 0; r < field.length; r++) {
            for (int c = 0; c < field[r].length; c++) {
                System.out.print(field[r][c]);
            }
            System.out.println();
        }
    }
}
