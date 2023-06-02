package commongoals;

import board.Card;
import player.Player;

/**
 * Common Goal 7: Checks if there are two 2x2 squares of the same color.
 *
 * @param id the ID of the common goal
 */
public class CommonGoal_7 extends CommonGoal
{
	/**
	 * Constructs a CommonGoal_11 object with the specified ID.
	 *
	 * @param id the ID of the common goal
	 */
	public CommonGoal_7(int id)
	{
		super(id);
	}

	/**
	 * Checks if the player has achieved the common goal.
	 *
	 * @param player the player to check for the goal
	 * @return true if the player has achieved the goal, false otherwise
	 */
	@Override
	public boolean checkGoal(Player player)
	{
		Card[][] matrix = player.getLibrary().getMatrix();
		int count = 0;

		for (int i = 0; i < matrix.length - 1; i++)
		{
			for (int j = 0; j < matrix[i].length - 1; j++)
			{
				if (matrix[i][j].getColor() != null && matrix[i][j + 1].getColor() != null
						&& matrix[i + 1][j + 1].getColor() != null)
				{
					if (matrix[i][j].getColor().equals(matrix[i + 1][j].getColor())
							&& matrix[i][j + 1].getColor().equals(matrix[i][j].getColor())
							&& matrix[i + 1][j + 1].getColor().equals(matrix[i][j].getColor()))
					{
						count++;
						j++;
					}
				}
			}
		}

		if (count >= 2)
		{
			return true;
		} else
		{
			return false;
		}
	}

	/**
	 * Outputs the description of the common goal.
	 */
	@Override
	public void output()
	{
		System.out.println("Two groups each containing 4 titles of the same type in a 2x2 square. "
				+ "The tiles of one square can be different from those of the other square.");
	}
}
