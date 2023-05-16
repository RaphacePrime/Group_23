package commongoals;

import board.Card;
import player.Player;

public class CommonGoal_12 extends CommonGoal{

	public CommonGoal_12(int id) {
		super(id);
	}

	@Override
	public boolean checkGoal(Player player) {
		Card[][] matrix = player.getLibrary().getMatrix();
		boolean flag;
		if (matrix[1][0].getColor() != null) {
			flag = true;
			for (int i = 0; i<=4; i++) {
				if (matrix[1+i][i].getColor() == null) {
					flag = false;
				}
			}
			if (flag) {
				return flag;
			}
		}
		else if (matrix[1][4].getColor() != null) {
			flag = true;
			for (int i = 0; i<=4; i++) {
				if (matrix[1+i][4-i].getColor() == null) {
					flag = false;
				}
			}
			if (flag) {
				return flag;
			}
		}
		return false;
	}

	@Override
	public void output() {
		System.out.println("Five columns of increasing or decreasing \r\n"
				+ "height. Starting from the first column on \r\n"
				+ "the left or on the right, each next column \r\n"
				+ "must be made of exactly one more card. \r\n"
				+ "Cards can be of any colour.");		
	}

}
