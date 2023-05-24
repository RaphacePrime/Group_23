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
	/*public boolean isLegalTile() 
	{
		return legalTile;
	}*/
	
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
	
	public boolean insertInLibrary(ArrayList<Card> chosen, int cloumn)
	{		
		System.out.println("insert a position in which you want to put the card. positions go from 1 to 5");
		Scanner sc = new Scanner(System.in);
		int Column = sc.nextInt();
		/*for (row = 6; row > 0; row--) 
		{
			if(matrix[Column][row]==null) {
				//matrix[Column][row]= "ArrayList<Card> chosen";  //non so quale sia la funzione che va a prendere le carte dalla board 			
			} 
			
		}*/
		
		
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
			
		
		/**
		 * String tileColor = new String();
		tileColor = tile.getCard().getColor();
		if(tileColor.equals("yellow")) {
			System.out.print("\u001B[33m" + "*\t" + "\u001B[0m");
		}else if(tileColor.equals("pink")) {
			System.out.print("\u001B[31m" + "*\t" + "\u001B[0m");
		}else if(tileColor.equals("blue")) {
			System.out.print("\u001B[34m" + "*\t" + "\u001B[0m");
		}else if(tileColor.equals("green")) {
			System.out.print("\u001B[32m" + "*\t" + "\u001B[0m");
		}else if(tileColor.equals("cyan")) {
			System.out.print("\u001B[36m" + "*\t" + "\u001B[0m");
		}else if(tileColor.equals("white")) {
			System.out.print("\u001B[37m" + "*\t" + "\u001B[0m");
		*/
		return false;
			
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
