import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double playerHitPoints = 18500;
        double HeiganHitPoints = 3000000;

        double damageToHeigan = Double.parseDouble(scan.nextLine());

        int playerRow = 7;
        int playerCol = 7;
        String lastSpell = "";
        boolean isLastSpellCloud=false;
        while (playerHitPoints > 0 && HeiganHitPoints > 0) {
            HeiganHitPoints -= damageToHeigan;
            if (isLastSpellCloud) {
                playerHitPoints-=3500;
                isLastSpellCloud=false;
                if (playerHitPoints<0) {
                    break;
                }
            }
            if (HeiganHitPoints < 0) {
                break;
            }
            String[] input = scan.nextLine().split("\\s+");
            String typeSpell = input[0];
            int rowToHit = Integer.parseInt(input[1]);
            int colToHit = Integer.parseInt(input[2]);
            boolean[][] matrix = new boolean[15][15];

            boolean isPlayerMoves = false;
            for (int r = rowToHit - 1; r <= rowToHit + 1; r++) { //hits
                if (r >= 0 && r < matrix.length) {
                    for (int c = colToHit - 1; c <= colToHit + 1; c++) {
                        if (c >= 0 && c < matrix[r].length) {
                            matrix[r][c] = true;
                        }
                    }
                }
            }

            if (matrix[playerRow][playerCol]) { //playerTryToMove
                if (playerRow - 1 >= 0 && playerRow - 1 < matrix.length && matrix[playerRow - 1][playerCol] == false) { //player try to move up
                    playerRow --;
                    isPlayerMoves = true;
                }else if (playerCol + 1 >= 0 && playerCol + 1 < matrix[playerRow].length && matrix[playerRow][playerCol + 1] == false) { //player try to move right
                    playerCol ++;
                    isPlayerMoves = true;
                } else if (playerRow + 1 >= 0 && playerRow + 1 < matrix.length && matrix[playerRow + 1][playerCol] == false) { //player try to move down
                    playerRow ++;
                    isPlayerMoves = true;
                } else if (playerCol - 1 >= 0 && playerCol - 1 < matrix[playerRow].length && matrix[playerRow][playerCol - 1] == false) { //player try to move left
                    playerCol --;
                    isPlayerMoves = true;
                }
                if (matrix[playerRow][playerCol]) {
                    switch (typeSpell) {
                        case "Cloud":
                            playerHitPoints -= 3500;
                            isLastSpellCloud = true;
                            lastSpell="Plague Cloud";
                            break;
                        case "Eruption":
                            playerHitPoints -= 6000;
                            lastSpell="Eruption";
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid spell: " + typeSpell);
                    }
                }
            }
        }

        if (HeiganHitPoints > 0) {
            System.out.printf("Heigan: %.2f%n", HeiganHitPoints);
        } else {
            System.out.println("Heigan: Defeated!");
        }
        if (playerHitPoints > 0) {
            System.out.printf("Player: %.0f%n", playerHitPoints);
        } else {
            System.out.println("Player: Killed by " + lastSpell);
        }
        System.out.printf("Final position: %d, %d",playerRow,playerCol);
    }
}
