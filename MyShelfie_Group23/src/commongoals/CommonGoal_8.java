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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void output() {
		// TODO Auto-generated method stub
		
	}
	public boolean checkRow(String  row[]) {
		int i,k;
		
		for(i=0;i<5;i++) {
			for(k=0;k<5;k++) {
				if((row[i]==row[k])&&(i!=k)) {
					return false;
				}
			}
		}
		return true;
	}
	public boolean checkGoal(Card matrix[][]) {
		int i , k = 0, count = 0;
		String row[] = null;
		for(i = 0; i<6;i++) {
				row[k]=matrix[k][i].getColor();
			}
			if(checkRow(row)) {
				count++;
			}
			if(count == 2) {
				return true;
		}
	

		return false;
}
}
