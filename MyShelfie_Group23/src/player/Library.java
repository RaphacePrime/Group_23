package player;

import java.util.ArrayList;

import board.Card;

public class Library {
	
	private int  prova;
	
	
	private Card matrix[][];
	
	int initialization_matrix [][] ={ 	{0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0},	};
	
	public Library()
	{
		
	}
	
	public boolean checkFullness()
	{
		return true;
	}
	
	public boolean insertInLibrary(ArrayList<Card> chosen, int column)
	{
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
