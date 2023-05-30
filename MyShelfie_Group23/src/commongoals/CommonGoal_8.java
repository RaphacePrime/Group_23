package commongoals;

import board.Card;
import player.Player;

public class CommonGoal_8 extends CommonGoal
{

	public CommonGoal_8(int id)
	{
		super(id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean checkGoal(Player player)
	{
		Card[][] matrix = player.getLibrary().getMatrix();
		int count = 0; boolean null_control;
		String row[] = new String[5];
		for (int k = 0; k < 6; k++)
		{
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
					row[i] = matrix[k][i].getColor();
				}
			}
			if (null_control)
			{
				if(this.arrayCheck(row))
				{
					count++;
				}
				
			}

		}
		if (count >= 2)
		{
			return true;
		}
		return false;
	}

	@Override
	public void output()
	{
		System.out.println("Two lines each made up of 5 different types of tiles.");

	}

	public boolean arrayCheck(String[] array)
	{
		if (array != null)
		{
			for (int i = 0; i < array.length; i++)
			{
				for (int j = i + 1; j < array.length; j++)
				{
					if (array[i].equals(array[j]))
					{
						return false;
					}
				}
			}
			return true;
		}
		return false;
	}

}
