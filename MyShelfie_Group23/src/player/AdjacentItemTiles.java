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
						output();
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
		
		if(x-1 >= 0 && matrixObj[x-1][y] != null) {
			
			if(referenceCardColor.equals(matrixObj[x-1][y].getColor())) {
				matrixObj[x-1][y]= null;
				output();
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
				output();
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
				output();
				series++;
				checkNextRight(x,y+1,referenceCardColor);
				checkNextDown(x,y+1,referenceCardColor);
				checkNextUp(x,y+1,referenceCardColor);
				checkNextLeft(x,y+1,referenceCardColor);
			}
		}
		
		
	}
	
	private static void checkNextLeft(int x, int y, String referenceCardColor) {
		
		if(y-1 >= 0 && matrixObj[x][y-1] != null ) {
			
			if(referenceCardColor.equals(matrixObj[x][y-1].getColor())) {
				matrixObj[x][y-1]= null;
				output();
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
			 if(p>6) {
				 p = 6;
			 }
			 points += pointsArray[p-1];
		}
		seriesArr.clear();
		return points;
	}
	
	public static void output()
	{
		System.out.println("\n\t   Columns\n\t1  2  3  4  5");
		for (int i = 0; i < matrixObj.length; i++) {
			System.out.print("\t");
            for (int j = 0; j < matrixObj[i].length; j++) {
            	if(matrixObj[i][j] == null) {
            		System.out.print("\u001B[30m" + "*  " + "\u001B[0m");
            	}else {
            		
            		 String tileColor = matrixObj[i][j].getColor();
 	                if(tileColor.equals("giallo")) {
 						System.out.print("\u001B[33m" + "#  " + "\u001B[0m");
 					}else if(tileColor.equals("rosso")) {
 						System.out.print("\u001B[31m" + "#  " + "\u001B[0m");
 					}else if(tileColor.equals("blu")) {
 						System.out.print("\u001B[34m" + "#  " + "\u001B[0m");
 					}else if(tileColor.equals("verde")) {
 						System.out.print("\u001B[32m" + "#  " + "\u001B[0m");
 					}else if(tileColor.equals("azzurro")) {
 						System.out.print("\u001B[36m" + "#  " + "\u001B[0m");
 					}else if(tileColor.equals("bianco")) {
 						System.out.print("\u001B[37m" + "#  " + "\u001B[0m");
 					}
            		
            	}
	               
            }
            System.out.println();
        }
		System.out.println();
	}


}
