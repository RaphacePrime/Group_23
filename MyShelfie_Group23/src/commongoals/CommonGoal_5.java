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
        System.out.println("Four groups made by four cards of the same type");
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
                if (j + 3 < matrix[i].length && current!=null && current.equals(matrix[i][j + 1].getColor()) && current.equals(matrix[i][j + 2].getColor()) && current.equals(matrix[i][j + 3].getColor())) {
                    count++;
                    // Set the strings in the group to null
                    matrix[i][j].setColor(null);
                    matrix[i][j + 1].setColor(null);
                    matrix[i][j + 2].setColor(null);
                    matrix[i][j + 3].setColor(null);
                }

                // Check if there are four equal strings in the same column
                if (i + 3 < matrix.length && current!=null && current.equals(matrix[i + 1][j].getColor()) && current.equals(matrix[i + 2][j].getColor()) && current.equals(matrix[i + 3][j].getColor())) {
                    count++;
                    // Set the strings in the group to null
                    matrix[i][j].setColor(null);
                    matrix[i + 1][j].setColor(null);
                    matrix[i + 2][j].setColor(null);
                    matrix[i + 3][j].setColor(null);
                }
            }
        }
        //System.out.println("Number of groups: " + count);
        return count >= 4;
    }
    /**
     * Sets any null elements in the matrix to the string null.
     *
     * @param matrix The matrix of cards.
     * @return The updated matrix with null elements replaced by null.
     */
	/*private Card[][] setNullToString(Card[][] matrix) 
	{
		for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].getColor() == null) {
                    matrix[i][j].setColor(null);
                }
            }
        }
		/*
        // Print the updated matrix
        for (Card[] row : matrix) {
            for (Card element : row) {
                System.out.print(element.getColor() + " ");
            }
            System.out.println();
        }
        
		return matrix;		
	}*/
}
