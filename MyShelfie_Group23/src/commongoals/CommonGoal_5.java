package commongoals;

import board.Card;
import player.Player;

public class CommonGoal_5 extends CommonGoal{

	public CommonGoal_5(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void output() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean checkGoal(Player player) {
		System.out.println("4 groups made by 4 cards of the same type.");
		return false;
	}

}
