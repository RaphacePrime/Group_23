package player;

import java.util.ArrayList;
import java.util.Scanner;
import board.Card;
import board.LivingRoomTile;

public class Library {
	
	private Card matrix[][];
	private Card card;
	//private final boolean legalTile;
	
	public Library()
	{
		//this.legalTile = legalTile;
		this.card = null;
		this.matrix = new Card[6][5];
				
	}

/**	public boolean isOccupied()
	{
		if (!this.isLegalTile())
		{
			return false;
		}
		else if (this.card != null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	*/
	public boolean checkFullness()
	{
		return true;
	}
	
	public void insertInLibrary(ArrayList<Card> chosen, int cloumn, int row)
	{		
		System.out.println("insert a position in which you want to put the card. positions go from 1 to 5");
		Scanner sc = new Scanner(System.in);
		int Column = sc.nextInt();
		for (row = 6; row > 0; row--) 
		{a
			if(matrix[Column][row]==null) {
				matrix[Column][row]= "ArrayList<Card> chosen";  //non so quale sia la funzione che va a prendere le carte dalla board 			
			} 
			
		}
		
		
		/**for (int row = 0; row < 6;row++) {
			for (Card tile : matrix[row])
			{
				if(!tile.isOccupied())
				{	
					return false;
				}else
					Card[row]= card.chosen; //non so quale sia la funzione che va a prendere le carte dalla board
				row++;
		}
		*/
			
	
	}

	public void output()
	{
		
	}

	public Card[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(Card matrix[][]) {
		this.matrix = matrix;
	}
}
