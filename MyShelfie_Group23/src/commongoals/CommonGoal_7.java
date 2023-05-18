package commongoals;
import board.Card;
import player.Player;

public class CommonGoal_7 extends CommonGoal{

public CommonGoal_7(int id) {
super(id);
}

@Override
public boolean checkGoal(Player player) {
Card[][] matrix = player.getLibrary().getMatrix();
int count = 0;

for(int i = 0; i<matrix.length -1; i++) {

for(int j = 0; j<matrix[i].length - 1; j++) {

if(matrix[i][j].getColor().equals(matrix[i+1][j].getColor())&&
		matrix[i][j+1].getColor().equals(matrix[i][j].getColor())&&
		matrix[i+1][j+1].getColor().equals(matrix[i][j].getColor())) {

	count++;
		}
	}
}
	if(count>=2) {

		return true;
	}else {

		return false;
	}


}

@Override
public void output() {
	
	System.out.println("Two groups each containing 4 titles of the same type in a 2x2 square. " +
							+ "The titles of one square can be different from those of the other square.");
	

}

}