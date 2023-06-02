package commongoals;

import board.Card;
import player.Player;

/**
 * CommonGoal_11: check if the player has eight
 * cards of the same type in any positions. It extends the CommonGoal class.
 */
public class CommonGoal_11 extends CommonGoal
{

	/**
	 * Constructs a CommonGoal_11 object with the specified ID.
	 *
	 * @param id the ID of the common goal
	 */
	public CommonGoal_11(int id)
	{
		super(id);
	}

	/**
	 * Checks if the player has achieved the goal.
	 *
	 * @param player the player to check the goal for
	 * @return true if the player has eight cards of the same type, false otherwise
	 */
	@Override
	public boolean checkGoal(Player player)
	{
		int pink = 0;
		int blue = 0;
		int white = 0;
		int yellow = 0;
		int green = 0;
		int cyan = 0;

		Card[][] matrix = player.getLibrary().getMatrix();
		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[i].length; j++)
			{
				if (matrix[i][j].getColor() != null)
				{
					switch (matrix[i][j].getColor())
					{
					case "white":
						white++;
						break;
					case "cyan":
						cyan++;
						break;
					case "yellow":
						yellow++;
						break;
					case "blue":
						blue++;
						break;
					case "pink":
						pink++;
						break;
					case "green":
						green++;
						break;
					default:
						break;
					}
				}
			}
		}

		if (blue >= 8 || white >= 8 || pink >= 8 || cyan >= 8 || green >= 8 || yellow >= 8)
		{
			return true;
		}
		return false;
	}

	/**
	 * Outputs the description of the common goal.
	 */
	@Override
	public void output()
	{
		System.out.println("Eight cards of the same type in any positions");
	}
}
