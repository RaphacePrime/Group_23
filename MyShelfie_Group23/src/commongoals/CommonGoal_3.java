package commongoals;

import player.*;
import board.*;

public class CommonGoal_3 extends CommonGoal{

	public CommonGoal_3(int id) {
		super(id);
	}

	@Override
	public boolean checkGoal(Player player) {
		Card[][] matrix = player.getLibrary().getMatrix();
		if (matrix[0][0].getColor() != matrix[0][5].getColor()) {
			return false;
		}
		else if (matrix[6][0].getColor() != matrix[6][5].getColor()) {
			return false;
		}
		else if (matrix[0][0].getColor() != matrix[6][0].getColor()) {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public void output() {
		System.out.println("Four cards of the same colour in the four corners of your library");
	}

}