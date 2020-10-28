import java.util.Scanner;

public class Snake {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        char[][] territory = new char[n][n];

        int snakeRow = 0;
        int snakeCol = 0;
        int burrowOneRow = 0;
        int burrowOneCol = 0;
        int burrowTwoRow = 0;
        int burrowTwoCol = 0;
        boolean isBurrowOneFound = false;
        for (int row = 0; row < n; row++) {
            String[] currentRow = scan.nextLine().split("");
            for (int col = 0; col < currentRow.length; col++) {
                territory[row][col] = currentRow[col].charAt(0);
                if (currentRow[col].charAt(0) == 'S') {
                    snakeRow = row;
                    snakeCol = col;
                }
                if (currentRow[col].charAt(0) == 'B' && !isBurrowOneFound) {
                    burrowOneRow = row;
                    burrowOneCol = col;
                    isBurrowOneFound = true;
                } else if (currentRow[col].charAt(0) == 'B' && isBurrowOneFound) {
                    burrowTwoRow = row;
                    burrowTwoCol = col;
                }
            }
        }
        int food = 0;
        while (food < 10) {
            String command = scan.nextLine();
            territory[snakeRow][snakeCol] = '.';
            if (command.equals("up")) {
                if (snakeRow - 1 >= 0) {
                    if (territory[snakeRow - 1][snakeCol] == '*') {
                        food += 1;
                        territory[snakeRow - 1][snakeCol] = 'S';
                        snakeRow = snakeRow - 1;
                    } else if (territory[snakeRow - 1][snakeCol] == 'B') {
                        if (burrowOneRow == snakeRow - 1 && burrowOneCol == snakeCol) {
                            territory[burrowOneRow][burrowOneCol]='.';
                            territory[burrowTwoRow][burrowTwoCol] = 'S';
                            snakeRow = burrowTwoRow;
                            snakeCol = burrowTwoCol;
                        } else if (burrowTwoRow == snakeRow - 1 && burrowTwoCol == snakeCol) {
                            territory[burrowTwoRow][burrowTwoCol]='.';
                            territory[burrowOneRow][burrowOneRow] = 'S';
                            snakeRow = burrowOneRow;
                            snakeCol = burrowOneCol;
                        }
                    } else {
                        territory[snakeRow - 1][snakeCol] = 'S';
                        snakeRow = snakeRow - 1;
                    }
                } else {
                    System.out.println("Game over!");
                    break;
                }
            } else if (command.equals("down")) {
                if (snakeRow + 1 < territory.length) {
                    if (territory[snakeRow + 1][snakeCol] == '*') {
                        food += 1;
                        territory[snakeRow + 1][snakeCol] = 'S';
                        snakeRow = snakeRow + 1;
                    } else if (territory[snakeRow + 1][snakeCol] == 'B') {
                        if (burrowOneRow == snakeRow + 1 && burrowOneCol == snakeCol) {
                            territory[burrowOneRow][burrowOneCol]='.';
                            territory[burrowTwoRow][burrowTwoCol] = 'S';
                            snakeRow = burrowTwoRow;
                            snakeCol = burrowTwoCol;
                        } else if (burrowTwoRow == snakeRow + 1 && burrowTwoCol == snakeCol) {
                            territory[burrowTwoRow][burrowTwoCol]='.';
                            territory[burrowOneRow][burrowOneRow] = 'S';
                            snakeRow = burrowOneRow;
                            snakeCol = burrowOneCol;
                        }
                    } else {
                        territory[snakeRow + 1][snakeCol] = 'S';
                        snakeRow = snakeRow + 1;
                    }
                } else {
                    System.out.println("Game over!");
                    break;
                }
            } else if (command.equals("right")) {
                if (snakeCol + 1 < territory[snakeRow].length) {
                    if (territory[snakeRow][snakeCol + 1] == '*') {
                        food += 1;
                        territory[snakeRow][snakeCol + 1] = 'S';
                        snakeCol = snakeCol + 1;
                    } else if (territory[snakeRow][snakeCol + 1] == 'B') {
                        if (burrowOneRow == snakeRow && burrowOneCol == snakeCol + 1) {
                            territory[burrowOneRow][burrowOneCol]='.';
                            territory[burrowTwoRow][burrowTwoCol] = 'S';
                            snakeRow = burrowTwoRow;
                            snakeCol = burrowTwoCol;
                        } else if (burrowTwoRow == snakeRow && burrowTwoCol == snakeCol + 1) {
                            territory[burrowTwoRow][burrowTwoCol]='.';
                            territory[burrowOneRow][burrowOneRow] = 'S';
                            snakeRow = burrowOneRow;
                            snakeCol = burrowOneCol;
                        }
                    } else {
                        territory[snakeRow][snakeCol + 1] = 'S';
                        snakeCol = snakeCol + 1;
                    }
                } else {
                    System.out.println("Game over!");
                    break;
                }
            } else if (command.equals("left")) {
                if (snakeCol - 1 >= 0) {
                    if (territory[snakeRow][snakeCol - 1] == '*') {
                        food += 1;
                        territory[snakeRow][snakeCol - 1] = 'S';
                        snakeCol = snakeCol - 1;
                    } else if (territory[snakeRow][snakeCol - 1] == 'B') {
                        if (burrowOneRow == snakeRow && burrowOneCol == snakeCol - 1) {
                            territory[burrowOneRow][burrowOneCol]='.';
                            territory[burrowTwoRow][burrowTwoCol] = 'S';
                            snakeRow = burrowTwoRow;
                            snakeCol = burrowTwoCol;
                        } else if (burrowTwoRow == snakeRow && burrowTwoCol == snakeCol - 1) {
                            territory[burrowTwoRow][burrowTwoCol]='.';
                            territory[burrowOneRow][burrowOneRow] = 'S';
                            snakeRow = burrowOneRow;
                            snakeCol = burrowOneCol;
                        }
                    } else {
                        territory[snakeRow][snakeCol - 1] = 'S';
                        snakeCol = snakeCol - 1;
                    }
                } else {
                    System.out.println("Game over!");
                    break;
                }
            }
        }

        if (food>=10) {
            System.out.println("You won! You fed the snake.");
        }
        System.out.println("Food eaten: "+food);

        for (int r = 0; r <territory.length ; r++) {
            for (int c = 0; c <territory[r].length ; c++) {
                System.out.print(territory[r][c]);
            }
            System.out.println();
        }
    }
}
