package commongoals;

import board.Card;
import player.Player;

public class CommonGoal_6 extends CommonGoal{

	public CommonGoal_6(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean checkGoal(Player player) {
		Card[][] matrix = player.getLibrary().getMatrix();
		int count=0;
		for(int col=0; col<5; col++)
		{
			int line=0; //variable for line count, when i swap column it resets
			boolean control=true;//while the color is the same is true
			String color=matrix[line][col].getColor();
			while(control==true && line!=5)
			{
				line++;
				if(!matrix[line][col].getColor().equals(color))
				{
					control=false;
				}
			}
			if(control)
			{
				count++;
			}
		}
		if(count>=2)
		{
			return true;
		}
		return false;
	}

	@Override
	public void output() {
		System.out.println("Two column made by six cards of the same color");
		
	}

}
