package commongoals;

import board.Card;
import player.Player;

public class CommonGoal_9 extends CommonGoal{

	public CommonGoal_9(int id) {
		super(id);
	}

	@Override
	public boolean checkGoal(Player player) {
		Card[][] matrix = player.getLibrary().getMatrix();
		int count = 0;
		int countC = 0;
		
		for(int j = 0; j <matrix[0].length -1; j++) {

			for(int i = 0; i<matrix.length; i++) {
				if(matrix[i][j].getColor()!= null && matrix[i][j].getColor()!= matrix[0][j].getColor()) {
					count++;
				}
				
			}
			if(count<=3) {
				countC++;
			}
		}
		if(countC>=3) {
			return false;
			
		}else {
			
		return true;
	}
	}
	@Override
	public void output() {
		
		System.out.println("Three columns each formed by 6 tiles of maximum three different types. One column can show the same or a different combination of another column.");
		
	}

}