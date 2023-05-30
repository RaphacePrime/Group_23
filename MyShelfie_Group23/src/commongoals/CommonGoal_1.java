package commongoals;

import board.Card;
import player.Player;

public class CommonGoal_1 extends CommonGoal{
	
	public CommonGoal_1(int id) {
		super(id);
		 
	}

	@Override
	public void output() {
		System.out.println("Six separate groups each consisting of two adjacent tiles of the same type.");
		
	}
	public static int contaCoppie(Card[][] matrix,boolean [][] used, int i , int j) {
       	if (i == matrix[j].length) {
            return 0;
        }
        
        if (j == matrix[i].length) {
            return contaCoppie(matrix,used,i +1 ,0);
        }
        int coppie = contaCoppie(matrix,used,i , j +1);
        if (j +1 < matrix[i].length && matrix[i][j].getColor().equals(matrix[i][j +1].getColor()) && !used[i][j] && !used[i][j +1]&&matrix[i][j]!=null) {
            used[i][j] = true;
            used[i][j +1] = true;
            coppie = Math.max(coppie , contaCoppie(matrix,used,i , j +1) +1);
            used[i][j] = false;
            used[i][j +1] = false;
        }
        if (i +1 < matrix.length && matrix[i][j].getColor().equals(matrix[i +1][j].getColor())  && !used[i][j] && !used[i +1][j]&&matrix[i][j]!=null) {
        	used[i][j] = true;
        	used[i +1][j] = true;
            coppie = Math.max(coppie , contaCoppie(matrix,used,i , j +1) +1);
            used[i][j] = false;
            used[i +1][j] = false;
        }
        return coppie;
    }
	@Override
	public boolean checkGoal(Player player) {
		Card[][] matrix = player.getLibrary().getMatrix();
		boolean used[][] = new boolean[5][6];
		int coppie;
		coppie = contaCoppie(matrix,used,0,0);
		if(coppie >= 6) {
			return true;
		}
		return false;
	}
}



