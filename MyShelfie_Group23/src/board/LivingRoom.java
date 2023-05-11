package board;

import java.util.ArrayList;

public class LivingRoom 
{
	
	//private Card matrix [][];
	private LivingRoomTile matrix [][];
	
	private ArrayList<Card> cards;
	
	/**
	 * This constructor decides whether each tile of the board 
	 * is legal or illegal depending on the number of players.
	 * Then it calls the method LivingRoom.Reset to fill the board with cards.
	 * @param number_of_players
	 * @param cards
	 */
	public LivingRoom(int number_of_players, ArrayList<Card> cards)
	{
		this.cards = cards;
		
		this.matrix = new LivingRoomTile[9][9];
		
		int initialization_matrix [][] = 	{	{5, 5, 5, 3, 4, 5, 5, 5, 5},
												{5, 5, 5, 2, 2, 4, 5, 5, 5},
												{5, 5, 3, 2, 2, 2, 3, 5, 5},
												{5, 4, 2, 2, 2, 2, 2, 2, 3},
												{4, 2, 2, 2, 2, 2, 2, 2, 4},
												{3, 2, 2, 2, 2, 2, 2, 4, 5},
												{5, 5, 3, 2, 2, 2, 3, 5, 5},
												{5, 5, 5, 4, 2, 2, 5, 5, 5},
												{5, 5, 5, 5, 4, 3, 5, 5, 5},	};
		
		for (int row = 0; row < 9; row++)
		{
			for (int column = 0; column < 9; column++)
			{
				if (initialization_matrix[row][column] <= number_of_players)
					matrix[row][column] = new LivingRoomTile(true);
				else 
					matrix[row][column] = new LivingRoomTile(false);
			}
		}
		this.reset();
	}
	
	public void reset () 
	{
		for (int row = 0; row < 9; row++)
		{
			for (LivingRoomTile tile : matrix[row])
			{
				if (tile.isLegalTile())
				{
					tile.setCard(cards.remove(0));	
				}
			}
		}
	}
	
	public boolean checkReset()
	{
		for (int x = 0; x < 9; x++) 
		{
			for (int y = 0; y < 9; y++)
			{
				if (matrix[x][y].isOccupied())
				{
					int neighbours = hasNeighbours(x,y);
					if (neighbours > 1)
					{
						return false;
					}
				}
			}
		}
		return true;		
	}
	
	public void output()
	{
		for (int row = 0; row < 9; row++)
		{
			for (LivingRoomTile tile : matrix[row])
			{
				if(!tile.isOccupied())
				{	
					System.out.print("\u001B[30m" + "*\t" + "\u001B[0m");
				}
				else {
					
					String tileColor = new String();
					tileColor = tile.getColor();
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
					}
				}
			}
		}
	}
	
	/**
	 * This function checks if the cards that the player wants to remove are actually removable.
	 * 
	 * @param x
	 * @param y
	 * @param direction
	 * @param n_of_cards
	 * @return
	 */
	public boolean controlChosenCards(int x, int y, String direction, int n_of_cards)
	{
		int xAxisShift = 0;
		int yAxisShift = 0;
		switch (direction)
		{
		case "N":
			yAxisShift = 1;
			break;
		case "S":
			yAxisShift = -1;
			break;
		case "W":
			xAxisShift = -1;
			break;
		case "E":
			xAxisShift = 1;
		}
		for (int i=0; i < n_of_cards; i++)
		{
			if(!isRemovable(x + i*xAxisShift,y + i*yAxisShift))
			{
				return false;
			}
		}
		return true;
	}
	
	private boolean isRemovable (int x, int y)
	{
		if (matrix[x][y].getCard()==null)
		{
			return false;
		}
		else 
		{
			int neighbours = hasNeighbours(x,y);
			if (neighbours > 0 && neighbours < 4)
			{
				return true;
			}
			else 
			{
				return false;
			}
		}
	}
	
	
	private int hasNeighbours (int x, int y)
	{
		int neighbours = 0;
		
		if (x != 0) 
		{
			if (matrix[x - 1][y].isOccupied()) 
			{
				neighbours++;
			}
		}
		if (x != 8) 
		{
			if (matrix[x + 1][y].isOccupied()) 
			{
				neighbours++;
			}
		}
		if (y != 0)
		{
			if (matrix[x][y - 1].isOccupied()) 
			{
				neighbours++;
			}
		}
		if (y != 8) 
		{
			if (matrix[x][y + 1].isOccupied())
			{
				neighbours++;
			}
		}
		return neighbours;
	}

	public void removeCard(int x, int y)
	{
		matrix[x][y].setCard(null);
	}

	public Card getCard(int x, int y) {
		// una funzione che date due coordinate mi ritorna una Card
		return null;
	}

	public void removeCards(ArrayList<Card> chosen) {
		// rimuove le carte detnro chosen dalla living room
		
	}

/*	public boolean controlChosenCards(int x, int y, String direction, int n_ofcards) {
		// prende una carta, data la direzione scelta dall'utente (N-E-S-W) e il numero dic carte, restituisce true
		// se l'utente può prenderle, false se non può
		return false;
	}
*/
	
	public ArrayList<Card> getCards(int x, int y, String direction, int n_ofcards) {
		ArrayList<Card> chosen= new ArrayList<Card>();
		// prende una carta, data la direzione scelta dall'utente (N-E-S-W) e il numero dic carte, restituisce una ArrayList<Card>
		// contenente le Card scelte dall'utente, e le rimuove chiamando la funzione
		this.removeCards(chosen);
		return chosen;
	}
}
