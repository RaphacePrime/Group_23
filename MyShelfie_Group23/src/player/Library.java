package player;

import java.util.ArrayList;
import java.util.Scanner;
import board.Card;
import board.LivingRoomTile;

public class Library {
	
	private Card matrix[][];

	
	public Library()
	{
		this.matrix = new Card[6][5];
		
		int Card [][] ={ 	{1, 2, 3, 4, 5},
							{1, 2, 3, 4, 5},
							{1, 2, 3, 4, 5},
							{1, 2, 3, 4, 5},
							{1, 2, 3, 4, 5},
							{1, 2, 3, 4, 5},	};
	}
	
	public boolean checkFullness()
	{
		return true;
	}
	
	public boolean insertInLibrary(ArrayList<Card> chosen, int column)
	{		
		System.out.println("insert a position in which you want to put the card. positions go from 1 to 5");
		Scanner sc = new Scanner(System.in);
		int Column = sc.nextInt();
		for (int i = 0; i < Card.Lenght();i++) {
			if (i == Card[Column]) {
				Card[Column] = ArrayLinjst<Card> chosen;
			}
			else
				i++;
		}
		
			
		
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
		
		return true;
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
