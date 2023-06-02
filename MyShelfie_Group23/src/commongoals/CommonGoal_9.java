package commongoals;

import java.util.ArrayList;

import board.Card;
import player.Player;

/**
 * Common Goal 9: Checks if there are three columns each formed by 6 tiles of
 * maximum three different types.
 *
 * @param id the ID of the common goal
 */
public class CommonGoal_9 extends CommonGoal
{

	/**
	 * Constructs a CommonGoal_9 object with the specified ID.
	 * 
	 * @param id the ID of the common goal
	 */
	public CommonGoal_9(int id)
	{
		super(id);
	}

	/**
	 * Checks whether the player has achieved the common goal.
	 * 
	 * @param player the player to check
	 * @return true if the player has achieved the goal, false otherwise
	 */
	@Override
	public boolean checkGoal(Player player)
	{
		Card[][] matrix = player.getLibrary().getMatrix();
		int count = 0;
		boolean null_control;
		ArrayList<String> list = new ArrayList<String>();
		for (int k = 0; k < 5; k++)
		{
			list.clear();
			null_control = true;
			for (int i = 0; i < 6; i++)
			{
				if (matrix[i][k].getColor() == null)
				{
					null_control = false;
					break;
				} else
				{
					if (!list.contains(matrix[i][k].getColor()))
					{
						list.add(matrix[i][k].getColor());
					}
				}
			}
			if (null_control)
			{
				if (list.size() <= 3)
				{
					count++;
				}
			}
		}
		if (count >= 3)
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
		System.out.println(
				"Three columns each formed by 6 tiles of maximum three different types. One column can show the same or a different combination of another column.");
	}

}