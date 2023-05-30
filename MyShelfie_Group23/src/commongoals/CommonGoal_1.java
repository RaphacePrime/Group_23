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
	public static int contaCoppie(String[][] matrix,boolean [][] used, int i , int j) {
       	if (i == matrix[j].length) {
            return 0;
        }
        
        if (j == matrix[i].length) {
            return contaCoppie(matrix,used,i +1 ,0);
        }
        int coppie = contaCoppie(matrix,used,i , j +1);
        
        if (j +1 < matrix[i].length && matrix[i][j].equals(matrix[i][j +1]) && !used[i][j] && !used[i][j +1]&&!matrix[i][j].equals("N")) {
            used[i][j] = true;
            used[i][j +1] = true;
            coppie = Math.max(coppie , contaCoppie(matrix,used,i , j +1) +1);
            used[i][j] = false;
            used[i][j +1] = false;
        }
        if (i +1 < matrix.length && matrix[i][j].equals(matrix[i +1][j])  && !used[i][j] && !used[i +1][j]&&!matrix[i][j].equals("N")) {
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
		Card[][] matrix1 = player.getLibrary().getMatrix();
		String[][] matrix = new String[6][5];
		
		int i,k;
		for(i=0;i<6;i++) {
			for(k=0;k<5;k++) {
				if(matrix1[i][k].getColor()==null) {
					matrix[i][k]="N";
				}else {
					matrix[i][k]=matrix1[i][k].getColor();
				}
			}
		}
		
		boolean used[][] = new boolean[6][5];
		int coppie;
		coppie = contaCoppie(matrix,used,0,0);
		if(coppie >= 6) {
			return true;
		}
		return false;
	}
}



