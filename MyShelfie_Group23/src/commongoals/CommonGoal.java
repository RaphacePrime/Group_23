package commongoals;

import java.util.ArrayList;
import player.Player;

/**
 * The CommonGoal class represents a common goal in a game. It is an abstract
 * class that provides common functionality and structure for specific goal
 * implementations.
 */
public abstract class CommonGoal
{

	protected int id;
	protected ArrayList<Integer> points;

	/**
	 * Constructs a CommonGoal object with the specified ID. Initializes the points
	 * list with default values.
	 *
	 * @param id The ID of the common goal.
	 */
	public CommonGoal(int id)
	{
		points = new ArrayList<>();
		points.add(8);
		points.add(6);
		points.add(4);
		this.id = id;
	}

	/**
	 * Checks if the specified player has achieved the goal.
	 *
	 * @param player The player to check the goal for.
	 * @return true if the player has achieved the goal, false otherwise.
	 */
	public abstract boolean checkGoal(Player player);

	/**
	 * Outputs information about the common goal. The specific implementation
	 * determines how the output is displayed.
	 */
	public abstract void output();

	/**
	 * Assigns points to a player for achieving the common goal.
	 *
	 * @return The number of points assigned to the player. Returns 0 if there are
	 *         no more points to assign.
	 */
	public int assignPoints()
	{
		if (points.isEmpty())
		{
			System.out.println("The points have already been assigned to the players!");
		} else
		{
			int pointsToAssign = points.remove(0);
			return pointsToAssign;
		}
		return 0;
	}
}
