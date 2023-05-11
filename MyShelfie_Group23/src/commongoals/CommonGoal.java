package commongoals;

import java.util.ArrayList;

import main.Player;

public abstract class CommonGoal 
{
	protected int id;
	
	protected ArrayList<Integer> points;
	
	protected String description;
	
	public CommonGoal(int id)
	{
		points.add(8); points.add(6); points.add(4);
		this.id=id;
	}
	
	public abstract boolean checkGoal(Player player);
	
	public abstract void output();
	
	public boolean assignPoints(Player player)
	{
		if(points.isEmpty())//if the list is empty, i don't need to assign points
			//this control is better to do in the checkGoal(player) method, 
		{
			System.out.println("The points have already been assigned to the players!");
		}
		else
		{
			//player.addPoints();//adding points to the player
			int points_to_assign=points.remove(0);
		}
		return false;
	}
	
	
}
