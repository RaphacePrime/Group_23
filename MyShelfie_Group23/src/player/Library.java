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
	
	
	public boolean checkFullness()
	{
		return true;
	}
	
	
	public void insertInLibrary(ArrayList<Card> chosen, int cloumn)
	{	
		Scanner sc;
		int Column;
		int EmptySpace=0;
		do {	
			int row;
			do {
					System.out.println("insert the COLUMN in which you want to put the card. positions go from 1 to 5");
					sc = new Scanner(System.in);
					Column = sc.nextInt();
			}while(Column<1 && Column > 5); 
			
			for (row = 5; row > 0; row--) 
			{
				
				if(matrix[Column][row]!=null) 
				{ 
					break;
				}
				else 
				{
					EmptySpace++;
				}
				
			}
	
		}while(chosen.size() > EmptySpace);{
			System.out.print("the chosen COLUMN is currently full");
		}
		
		int SelectedCard=0;
		for (int row = 5; row > 0; row--) 
		{
			
			if(matrix[Column][row]!=null) 
			{ 
				break;
			}else 
			{
				matrix[Column][row]= chosen.get(SelectedCard);
				chosen.remove(SelectedCard);
				sc.close();
				SelectedCard++;
			}
			
		}
		
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
