package commongoals;

import board.Card;
import player.Player;

public class CommonGoal_11 extends CommonGoal{

	public CommonGoal_11(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean checkGoal(Player player) {
		int pink=0; int blue=0; int white=0; int yellow=0; int green=0; int cyan=0;
		Card[][] matrix = player.getLibrary().getMatrix();
		for (int i = 0; i < matrix.length; i++) 
		{
            for (int j = 0; j < matrix[i].length; j++) 
            {
                if(matrix[i][j].getColor()!=null)
                {
                	switch(matrix[i][j].getColor())
                	{
                		case "white": white++;
                			break;
                		case "cyan": cyan++;
                			break;
                		case "yellow": yellow++;
                			break;
                		case "blue": blue++;
                			break;
                		case "pink": pink++;
                			break;
                		case "green": green++;
                			break;
                		default:
                			break;
                	}
                }
            }
        }
		if(blue>=8 || white>=8 || pink>=8 || cyan>=8 || green>=8 || yellow>=8)
		{
			return true;
		}
		return false;
	}

	@Override
	public void output() {
		System.out.println("Eight cards of the same type in any positions");
		
	}

}
