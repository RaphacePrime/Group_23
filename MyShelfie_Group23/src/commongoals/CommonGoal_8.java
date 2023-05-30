package commongoals;

import board.Card;
import player.Player;

public class CommonGoal_8 extends CommonGoal{

	public CommonGoal_8(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean checkGoal(Player player) {
		int i , k = 0, count = 0;
		Card[][] matrix = player.getLibrary().getMatrix();
		String row[] = new String[6];
		
		for(k=0;k<6;k++) {
			for(i = 0; i<5;i++) {
				row[i]=matrix[k][i].getColor();
			}
			if(checkRow(row)) {
				count++;
			}
			if(count >= 2) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void output() {
		System.out.println("Two lines each made up of 5 different types of tiles.");
		
	}
	public boolean checkRow(String  row[]) {
		int i,k;
		for(i=0;i<5;i++) {
			for(k=0;k<6;k++) {
				if((row[i]==row[k])&&(i!=k)) {
					return false;
				}
			}
		}
		return true;
	}
	
}
