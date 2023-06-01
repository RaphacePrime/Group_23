package commongoals;

import board.Card;
import player.Player;

/**
 * Common goal 10: Checks if there are five cards of the same colour forming an X
 *
 */
public class CommonGoal_10 extends CommonGoal{

	/**
	 * Constructor of CommonGoal_10 
	 * @param id
	 */
	public CommonGoal_10(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param player The player to check
	 * @return returns true if the common goal is completed 
	 */
	@Override
	public boolean checkGoal(Player player) {
		
		Card[][] matrix = player.getLibrary().getMatrix();	//Matrix of the library of the player
		
		int x; 		//counter x axes
		int y = 0; 	//counter y axes
		boolean completed = false; 
		
		String colorFirstCard; 	//color of the first card
		
		while(!completed && y<3){
			
			x=0;
			
			while(!completed && x<4) {
				
				if(matrix[x][y].getColor() != null && matrix[x][y+2].getColor() != null && matrix[x+1][y+1].getColor() != null 
						&& matrix[x+2][y].getColor() != null && matrix[x+2][y+2].getColor() != null) {
				
					completed = true;
					colorFirstCard = matrix[x][y].getColor();
					
					if(!matrix[x][y+2].getColor().equals(colorFirstCard) || !matrix[x+1][y+1].getColor().equals(colorFirstCard)
							|| !matrix[x+2][y].getColor().equals(colorFirstCard)|| !matrix[x+2][y+2].getColor().equals(colorFirstCard))
					{
						completed = false;
					}
				
				}
				
				x++;
			}
			
			y++;
		}
		
		return completed;
	}

	/**
	 * Prints in the console the description of the common goal
	 */
	@Override
	public void output() {
		System.out.println("Five cards of the same colour forming an X");
	}

}
