package commongoals;

import player.*;
import board.*;

/**
 * Common Goal 3: Checks if the cards in the four corners of the library all have the same color.
 */
public class CommonGoal_3 extends CommonGoal{

	/**
	 * Constructs a CommonGoal_3 object with the specified ID.
	 * @param id The ID of the common goal.
	 */
	public CommonGoal_3(int id) {
		super(id);
	}

	/**
	 * Checks if the conditions of the goal are met by the player.
	 */
	@Override
	public boolean checkGoal(Player player) {
		Card[][] matrix = player.getLibrary().getMatrix();
		if (matrix[0][0].getColor() == null || matrix[0][4].getColor() == null || 
			matrix[5][0].getColor() == null || matrix[5][4].getColor() == null) {
			return false;
		}
		if (!matrix[0][0].getColor().equals(matrix[0][4].getColor())) {
			return false;
		}
		else if (!matrix[0][4].getColor().equals(matrix[5][0].getColor())) {
			return false;
		}
		else if (!matrix[5][0].getColor().equals(matrix[5][4].getColor())) {
			return false;
		}
		else {
			return true;
		}
	}

	/**
	 * Prints the description of the common goal.
	 */
	@Override
	public void output() {
		System.out.println("Four cards of the same colour in the four corners of the bookshelf");
	}

}