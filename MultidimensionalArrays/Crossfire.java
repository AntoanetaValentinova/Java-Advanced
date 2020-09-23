import java.util.*;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int rows = scan.nextInt();
        int cols = scan.nextInt();
        scan.nextLine();

        List<List<Integer>> matrix = fillMatrixWithIncreasingIntegers(rows, cols);

        String input = scan.nextLine();
        while (!input.equals("Nuke it from orbit")) {
            String[] numbers = input.split("\\s+");
            int row = Integer.parseInt(numbers[0]);
            int col = Integer.parseInt(numbers[1]);
            int radius = Integer.parseInt(numbers[2]);
            if (row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size()) {
                matrix.get(row).set(col, 0);
            }
            int counterUp = row - 1;
            int counterDown = row + 1;
            int counterRight = col + 1;
            int counterLeft = col - 1;
            for (int r = 0; r < radius; r++) {
                if (counterUp >= 0&&counterUp<matrix.size()&&col>=0 && col < matrix.get(counterUp).size()) { //remove up
                    matrix.get(counterUp).set(col, 0);
                }
                counterUp--;
                if (counterDown >=0&&counterDown<matrix.size()&&col>=0&& col < matrix.get(counterDown).size()) { //remove down
                    matrix.get(counterDown).set(col, 0);
                }
                counterDown++;
                if (row>=0&&row<matrix.size()&&counterRight>=0&&counterRight < matrix.get(row).size()) { //remove right
                    matrix.get(row).set(counterRight, 0);
                }
                counterRight++;
                if (row>=0&&row<matrix.size()&&counterLeft >= 0&&counterLeft<matrix.get(row).size()) { //remove left
                    matrix.get(row).set(counterLeft, 0);
                }
                counterLeft--;
            }
            for (int r = 0; r < matrix.size(); r++) {
                while (matrix.get(r).contains(Integer.valueOf(0))) {
                    for (int c = 0; c < matrix.get(r).size(); c++) {
                        if (matrix.get(r).get(c) == 0) {
                            matrix.get(r).remove(c);
                            c--;
                        }
                    }
                }
            }
            for (int r = 0; r <matrix.size() ; r++) {
                if (matrix.get(r).isEmpty()) {
                    matrix.remove(r);
                }
            }
            input = scan.nextLine();
        }

        for (int r = 0; r < matrix.size(); r++) {
            for (int c = 0; c < matrix.get(r).size(); c++) {
                System.out.print(matrix.get(r).get(c) + " ");
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> fillMatrixWithIncreasingIntegers(int rows, int cols) {
        List<List<Integer>> matrix = new ArrayList<>();
        int number = 1;
        for (int row = 0; row < rows; row++) {
            List<Integer> currentRow = new ArrayList<>();
            for (int col = 0; col < cols; col++) {
                currentRow.add(number);
                number++;
            }
            matrix.add(currentRow);
        }
        return matrix;
    }
}
