package commongoals;

import java.util.ArrayList;

import board.Card;

import player.Player;

/**
 * This class represents the Common Goal 4. The goal is to check if the player
 * has formed four lines, each consisting of five tiles with a maximum of three
 * different types. A line can display the same combination or a different
 * combination compared to another line.
 */

public class CommonGoal_4 extends CommonGoal
{

	/**
	 * Constructor for the CommonGoal_4 class.
	 *
	 * @param id the ID of the common goal
	 */

	public CommonGoal_4(int id)
	{
		super(id);
// TODO Auto-generated constructor stub
	}

	/**
	 * Checks if the player has achieved the common goal.
	 * 
	 * @param player the player to check
	 * @return true if the goal has been achieved, false otherwise
	 */

	@Override
	public boolean checkGoal(Player player)
	{
		Card[][] matrix = player.getLibrary().getMatrix();
		int count = 0; boolean null_control;
		ArrayList<String> list= new ArrayList<String>();
		for (int k = 0; k < 6; k++)
		{
			list.clear();
			null_control=true;
			for (int i = 0; i < 5; i++)
			{
				
				if (matrix[k][i].getColor() == null)
				{
					null_control=false;
					break;
				} 
				else
				{
					if(!list.contains(matrix[k][i].getColor()))
					{
						list.add(matrix[k][i].getColor());
					}					
				}
			}
			if (list.size()<=3 && null_control)
			{
				count++;
			}

		}
		if (count >= 4)
		{
			return true;
		}
		return false;
	}

	// Prints a message describing the common goal.

	@Override
	public void output()
	{
		System.out.println(
				"Four lines each formed by 5 tiles of maximum three different types. One line can show the same or a different combination of another line.");

	}

}