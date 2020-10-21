import java.util.Scanner;

public class Bee {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        char[][] beeTerritory = new char[n][n];

        int beeRow = 0;
        int beeCol = 0;
        for (int i = 0; i < n; i++) {
            String[] currentRow = scan.nextLine().split("");
            for (int j = 0; j < currentRow.length; j++) {
                beeTerritory[i][j] = currentRow[j].charAt(0);
                if (currentRow[j].charAt(0) == 'B') {
                    beeRow = i;
                    beeCol = j;
                }
            }
        }
        int pollinatedFlowers = 0;
        String command = scan.nextLine();

        while (!command.equals("End")) {
            beeTerritory[beeRow][beeCol]='.';
            if (command.equals("up")) {
                if (beeRow - 1 >= 0) {
                    if (beeTerritory[beeRow-1][beeCol]=='f') {
                        pollinatedFlowers+=1;
                    } else if (beeTerritory[beeRow-1][beeCol]=='O') {
                        beeTerritory[beeRow-1][beeCol]='.';
                        beeRow-=1;
                        if (beeTerritory[beeRow-1][beeCol]=='f') {
                            pollinatedFlowers+=1;
                        }
                    }
                    beeRow-= 1;
                    beeTerritory[beeRow][beeCol]='B';
                } else {
                    System.out.println("The bee got lost!");
                    break;
                }
            } else if (command.equals("down")) {
                if (beeRow + 1 < n) {
                    if (beeTerritory[beeRow+1][beeCol]=='f') {
                        pollinatedFlowers+=1;
                    } else if (beeTerritory[beeRow+1][beeCol]=='O'){
                        beeTerritory[beeRow+1][beeCol]='.';
                        beeRow+=1;
                        if (beeTerritory[beeRow+1][beeCol]=='f') {
                            pollinatedFlowers+=1;
                        }
                    }
                    beeRow+= 1;
                    beeTerritory[beeRow][beeCol]='B';
                } else {
                    System.out.println("The bee got lost!");
                    break;
                }

            } else if (command.equals("left")) {
                if (beeCol - 1 >= 0) {
                    if (beeTerritory[beeRow][beeCol-1]=='f') {
                        pollinatedFlowers+=1;
                    } else if (beeTerritory[beeRow][beeCol-1]=='O'){
                        beeTerritory[beeRow][beeCol-1]='.';
                        beeCol-=1;
                        if (beeTerritory[beeRow][beeCol-1]=='f') {
                            pollinatedFlowers+=1;
                        }
                    }
                    beeCol-= 1;
                    beeTerritory[beeRow][beeCol]='B';
                } else {
                    System.out.println("The bee got lost!");
                    break;
                }
            } else if (command.equals("right")) {
                if (beeCol + 1 < n) {
                    if (beeTerritory[beeRow][beeCol+1]=='f') {
                        pollinatedFlowers+=1;
                    } else if (beeTerritory[beeRow][beeCol+1]=='O'){
                        beeTerritory[beeRow][beeCol+1]='.';
                        beeCol+=1;
                        if (beeTerritory[beeRow][beeCol+1]=='f') {
                            pollinatedFlowers+=1;
                        }
                    }
                    beeCol+= 1;
                    beeTerritory[beeRow][beeCol]='B';
                } else {
                    System.out.println("The bee got lost!");
                    break;
                }
            }
            command=scan.nextLine();
        }
        if (pollinatedFlowers<5) {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n",5-pollinatedFlowers);
        } else {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n",pollinatedFlowers);
        }

        for (int row = 0; row <beeTerritory.length ; row++) {
            for (int col = 0; col <beeTerritory[row].length ; col++) {
                System.out.print(beeTerritory[row][col]);
            }
            System.out.println();
        }
    }
}
