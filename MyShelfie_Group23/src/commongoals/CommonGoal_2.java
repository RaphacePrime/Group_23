package commongoals;

import board.Card;
import player.Player;

public class CommonGoal_2 extends CommonGoal{

	public CommonGoal_2(int id) {
		super(id);
	}

	@Override
	public boolean checkGoal(Player player) {
		
		Card[][] matrix = player.getLibrary().getMatrix();	//Matrix of the library of the player
		
		int x = 0; //counter x axes
		int y = 0; //counter y axes
		boolean completed = false; //true if the common goal is completed  
		boolean endCycle = false;
		int DiagonalCoeff = 1; //if DiagonalCoeff = 1 checks the diagonal else if DiagonalCoeff = -1 checks the reverse diagonal
		
		String colorFirstCard; //color of the first card
		
		do{
			if(matrix[x][y].getColor() != null) {
			
				completed = true;
				colorFirstCard = matrix[x][y].getColor();
				
				for(int i = 0; i < 5; i++) {	
					if(matrix[x+i][y+(i*DiagonalCoeff)].getColor() == null || matrix[x+i][y+(i*DiagonalCoeff)].getColor() != colorFirstCard){
						completed = false;
					}	
				}
			
			}
			
			if(x == 0) {
				x++;
			}else if(x == 1 && y == 4){
				endCycle = true;
			}else if(x == 1) {
				x = 0;
				y = 4;
				DiagonalCoeff = -1;
			}
			
		}while(!completed && !endCycle);
		
		return completed;
	}

	@Override
	public void output() {
		
		System.out.println("Five cards of the same colour forming a diagonal.");
		
	}

}
