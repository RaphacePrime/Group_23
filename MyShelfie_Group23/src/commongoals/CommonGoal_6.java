package commongoals;

import board.Card;
import player.Player;

public class CommonGoal_6 extends CommonGoal{

	public CommonGoal_6(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean checkGoal(Player player) {
		Card[][] matrix = player.getLibrary().getMatrix();
		int count=0;
		for(int col=0; col<5; col++)
		{
			 //variable for line count, when i swap column it resets
			String colors[]= new String[6];
			System.out.print("Colonna "+col+": ");
			for(int lin=0; lin<6; lin++)
			{
				System.out.print(matrix[lin][col].getColor());
				colors[lin]=matrix[lin][col].getColor();
				//System.out.print(colors[lin]);
			}
			System.out.println();
			if(this.arrayCheck(colors))
			{
				count++;
			}
		}
		System.out.print("CONTA: "+ count);
		if(count>=2)
		{
			
			return true;
		}
		return false;
	}
	
	public boolean arrayCheck(String[] array) {
	    for (int i = 0; i < array.length; i++) {
	        for (int j = i + 1; j < array.length; j++) {
	            if (array[i].equals(array[j])) {
	                return false;
	            }
	        }
	    }
	    return true;
	}

	@Override
	public void output() {
		System.out.println("Two column made by six cards of the same color");
		
	}

}
