package commongoals;

import player.Player;

public class CommonGoal_3 extends CommonGoal{

	public CommonGoal_3(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean checkGoal(Player player) {
		Library library = player.getLibrary();
		return false;
	}

	@Override
	public void output() {
		System.out.println("Four cards of the same colour in the four corners of your library");
	}

}