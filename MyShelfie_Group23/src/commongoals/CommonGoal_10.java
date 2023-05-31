package commongoals;

import board.Card;
import player.Player;

public class CommonGoal_10 extends CommonGoal{

	public CommonGoal_10(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

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
					
					if(matrix[x][y+2].getColor() != colorFirstCard || matrix[x+1][y+1].getColor() != colorFirstCard 
							|| matrix[x+2][y].getColor() != colorFirstCard || matrix[x+2][y+2].getColor() != colorFirstCard)
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

	@Override
	public void output() {
		System.out.println("Five cards of the same colour forming an X");
	}

}
