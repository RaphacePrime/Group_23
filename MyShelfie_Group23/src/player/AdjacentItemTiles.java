package player;

import java.util.ArrayList;
import java.util.List;

import board.Card;

public class AdjacentItemTiles {
	
	private static Card matrixObj[][];
	private static int series;
	private static List<Integer> seriesArr = new ArrayList<Integer>(0);
	
	public static int CheckAdjacentItemTiles(Card matrix[][]) {
		
		int points = 0;
		matrixObj = matrix;
		
		for(int x = 0; x < 6; x++) {
			
			for(int y = 0; y < 5; y++) {
				
				if(matrixObj[x][y] != null && matrixObj[x][y].getColor() != null) {
					
						series = 1;
						String referenceCardColor = matrixObj[x][y].getColor();
						matrixObj[x][y]= null;
						checkNextRight(x,y,referenceCardColor);
						checkNextDown(x,y,referenceCardColor);
						seriesArr.add(series);
						
					}
						
				}
				
			}
		
		points = SumPoints();
		
		return points;
	}
	
	private static void checkNextUp(int x, int y, String referenceCardColor) {
		
		if(x-1 > 0 && matrixObj[x-1][y] != null) {
			
			if(referenceCardColor.equals(matrixObj[x-1][y].getColor())) {
				matrixObj[x-1][y]= null;
				series++;
				checkNextLeft(x-1,y,referenceCardColor);
				checkNextUp(x-1,y,referenceCardColor);
				checkNextRight(x-1,y,referenceCardColor);
			}
		}
		
	}
	
	private static void checkNextDown(int x, int y, String referenceCardColor) {
		
		if(x+1 < 6 && matrixObj[x+1][y] != null){
			
			if(referenceCardColor.equals(matrixObj[x+1][y].getColor())) {
				matrixObj[x+1][y]= null;
				series++;
				checkNextRight(x+1,y,referenceCardColor);
				checkNextDown(x+1,y,referenceCardColor);
				checkNextLeft(x+1,y,referenceCardColor);
			}
		}
		
	}
	
	private static void checkNextRight(int x, int y, String referenceCardColor) {
		
		if(y+1 < 5  && matrixObj[x][y+1] != null) {
		
			if(referenceCardColor.equals(matrixObj[x][y+1].getColor())) {
				matrixObj[x][y+1]= null;
				series++;
				checkNextRight(x,y+1,referenceCardColor);
				checkNextDown(x,y+1,referenceCardColor);
				checkNextUp(x,y+1,referenceCardColor);
				checkNextLeft(x,y+1,referenceCardColor);
			}
		}
		
		
	}
	
	private static void checkNextLeft(int x, int y, String referenceCardColor) {
		
		if(y-1 > 0 && matrixObj[x][y-1] != null ) {
			
			if(referenceCardColor.equals(matrixObj[x][y-1].getColor())) {
				matrixObj[x][y-1]= null;
				series++;
				checkNextLeft(x,y-1,referenceCardColor);
				checkNextDown(x,y-1,referenceCardColor);
				checkNextUp(x,y-1,referenceCardColor);
			}
			
		}
		
	}
	
	private static int SumPoints() {
		
		int points = 0;
		Integer[] pointsArray = {0,0,2,3,5,8};
		
		int p;
		for(int i = 0; i < seriesArr.size(); i++) {
			 p = seriesArr.get(i);
			 if(p>7) {
				 p = 6;
			 }
			 points += pointsArray[p-1];
		}
		return points;
	}

}
