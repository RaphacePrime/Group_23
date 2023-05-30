package commongoals;

import board.Card;
import player.Player;

/**
 * Common Goal 12: Checks if there is a "staircase" 5x5 shape in the library, this shape can be mirrored horizontally, but not vertically.  
 */
public class CommonGoal_12 extends CommonGoal{

	/**
	 * Constructs a CommonGoal_12 object with the specified ID.
	 * @param id The ID of the common goal.
	 */
	public CommonGoal_12(int id) {
		super(id);
	}

	/**
	 * Checks if the conditions of the goal are met by the player.
	 */
	@Override
	public boolean checkGoal(Player player) {
		Card[][] matrix = player.getLibrary().getMatrix();
		boolean flag;
		if (matrix[1][0].getColor() != null) {
			flag = true;
			for (int i = 0; i<=4; i++) {
				if (matrix[1+i][i].getColor() == null) {
					flag = false;
				}
			}
			if (flag) {
				return flag;
			}
		}
		else if (matrix[1][4].getColor() != null) {
			flag = true;
			for (int i = 0; i<=4; i++) {
				if (matrix[1+i][4-i].getColor() == null) {
					flag = false;
				}
			}
			if (flag) {
				return flag;
			}
		}
		return false;
	}

	/**
	 * Prints the description of the common goal.
	 */
	@Override
	public void output() {
		System.out.println("Five columns of increasing or decreasing \r\n"
				+ "height. Starting from the first column on \r\n"
				+ "the left or on the right, each next column \r\n"
				+ "must be made of exactly one more card. \r\n"
				+ "Cards can be of any colour.");		
	}

}
