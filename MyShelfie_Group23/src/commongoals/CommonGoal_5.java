package commongoals;

import board.Card;
import player.Player;

/**
 * Common Goal 5: Checks if there are at least four groups of four cards of the same type.
 */
public class CommonGoal_5 extends CommonGoal {

    /**
     * Constructs a CommonGoal_5 object with the specified ID.
     *
     * @param id The ID of the common goal.
     */
    public CommonGoal_5(int id) {
        super(id);
        // TODO Auto-generated constructor stub
    }

    /**
     * Prints the description of the common goal.
     */
    @Override
    public void output() {
        System.out.println("4 groups made by 4 cards of the same type");
    }

    /**
     * Checks if the common goal is met by the player.
     *
     * @param player The player to check the common goal for.
     * @return True if there are at least four groups of four cards of the same type, false otherwise.
     */
    @Override
    public boolean checkGoal(Player player) {
        Card[][] matrix = player.getLibrary().getMatrix();
        int count = 0; // Counter for the found groups

        // Scan the rows
        for (int i = 0; i < matrix.length; i++) {
            // Scan the columns
            for (int j = 0; j < matrix[i].length; j++) {
                String current = matrix[i][j].getColor();

                // Check if there are four equal strings in the same row
                if (j + 3 < matrix[i].length && !current.equals("N") && current.equals(matrix[i][j + 1].getColor()) && current.equals(matrix[i][j + 2].getColor()) && current.equals(matrix[i][j + 3].getColor())) {
                    count++;
                    // Set the strings in the group to "N"
                    matrix[i][j].setColor("N");
                    matrix[i][j + 1].setColor("N");
                    matrix[i][j + 2].setColor("N");
                    matrix[i][j + 3].setColor("N");
                }

                // Check if there are four equal strings in the same column
                if (i + 3 < matrix.length && !current.equals("N") && current.equals(matrix[i + 1][j].getColor()) && current.equals(matrix[i + 2][j].getColor()) && current.equals(matrix[i + 3][j].getColor())) {
                    count++;
                    // Set the strings in the group to "N"
                    matrix[i][j].setColor("N");
                    matrix[i + 1][j].setColor("N");
                    matrix[i + 2][j].setColor("N");
                    matrix[i + 3][j].setColor("N");
                }
            }
        }
        System.out.println("Number of groups: " + count);
        return count >= 4;
    }
}
