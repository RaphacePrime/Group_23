package commongoals;

import board.Card;
import player.Player;

/**
 * A subclass of CommonGoal representing CommonGoal_1.
 */
public class CommonGoal_1 extends CommonGoal {

    /**
     * Constructor for CommonGoal_1.
     *
     * @param id the ID of CommonGoal_1
     */
    public CommonGoal_1(int id) {
        super(id);
    }

    /**
     * Prints the specific output message for CommonGoal_1.
     */
    @Override
    public void output() {
        System.out.println("Six separate groups each consisting of two adjacent tiles of the same type.");
    }

    /**
     * Checks if the player satisfies CommonGoal_1.
     *
     * @param player the player to check
     * @return true if the player satisfies CommonGoal_1, false otherwise
     */
    @Override
    public boolean checkGoal(Player player) {
        Card[][] matrix1 = player.getLibrary().getMatrix();
        String[][] matrix = new String[6][5];

        int i, k;
        for (i = 0; i < 6; i++) {
            for (k = 0; k < 5; k++) {
                if (matrix1[i][k].getColor() == null) {
                    matrix[i][k] = "N";
                } else {
                    matrix[i][k] = matrix1[i][k].getColor();
                }
            }
        }

        boolean used[][] = new boolean[6][5];
        int coppie;
        coppie = countPairs(matrix, used, 0, 0);
        if (coppie >= 6) {
            return true;
        }
        return false;
    }

    /**
     * Counts the number of separate pairs of adjacent tiles of the same type in the matrix.
     *
     * @param matrix the matrix of tiles
     * @param used a boolean matrix to keep track of already used tiles
     * @param i the current row index
     * @param j the current column index
     * @return the number of separate pairs of adjacent tiles of the same type
     */
    public static int countPairs(String[][] matrix, boolean[][] used, int i, int j) {
        if (i == matrix[j].length) {
            return 0;
        }

        if (j == matrix[i].length) {
            return countPairs(matrix, used, i + 1, 0);
        }

        int pairs = countPairs(matrix, used, i, j + 1);

        if (j + 1 < matrix[i].length && matrix[i][j].equals(matrix[i][j + 1]) && !used[i][j] && !used[i][j + 1] && !matrix[i][j].equals("N")) {
            used[i][j] = true;
            used[i][j + 1] = true;
            pairs = Math.max(pairs, countPairs(matrix, used, i, j + 1) + 1);
            used[i][j] = false;
            used[i][j + 1] = false;
        }
        if (i + 1 < matrix.length && matrix[i][j].equals(matrix[i + 1][j]) && !used[i][j] && !used[i + 1][j] && !matrix[i][j].equals("N")) {
            used[i][j] = true;
            used[i + 1][j] = true;
            pairs = Math.max(pairs, countPairs(matrix, used, i, j + 1) + 1);
            used[i][j] = false;
            used[i + 1][j] = false;
        }
        return pairs;
    }
}