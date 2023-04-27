package main;

import java.util.ArrayList;

public class LivingRoom 
{
	
	//private Card matrix [][];
	private LivingRoomTile matrix [][];

	private boolean end_card;
	
	//private boolean illegal_tile;
	
	//private int number_of_players;
	
	
/* This constructor sets end_card as true and decides
 * whether each tile of the board is legal or illegal
 * depending on the number of players.
 * This constructor does not fill the board.
 */
	public LivingRoom(int number_of_players)
	{
		this.end_card = true;
		
		this.matrix = new LivingRoomTile[9][9];
		
	/* the value of each element in initialization_matrix
	 * represents the number of players required for that 
	 * element to be a legal tile.
	 * Elements with a value of 5 will never be legal tiles.
	 */
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
	}
	
	void reset () 
	{
		
	}
	
	void output()
	{
		for (int row = 0; row < 9; row++)
		{
			for (int column = 0; column < 9; column++)
			{
				//matrix[row][column].getLetter;
				System.out.print("[ " + " ]  ");
			}
		}
	}

	public boolean getEnd_card() 
	{
		return end_card;
	}

	public void setEnd_card(boolean end_card) 
	{
		this.end_card = end_card;
	}

	public Card getCard(int x, int y) {
		// una funzione che date due coordinate mi ritorna una Card
		return null;
	}

	public void removeCards(ArrayList<Card> chosen) {
		// rimuove le carte detnro chosen dalla living room
		
	}

	public boolean controlChosenCards(int x, int y, String direction, int n_ofcards) {
		// prende una carta, data la direzione scelta dall'utente (N-E-S-W) e il numero dic carte, restituisce true
		// se l'utente può prenderle, false se non può
		return false;
	}

	public ArrayList<Card> getCards(int x, int y, String direction, int n_ofcards) {
		ArrayList<Card> chosen= new ArrayList<Card>();
		// prende una carta, data la direzione scelta dall'utente (N-E-S-W) e il numero dic carte, restituisce una ArrayList<Card>
		// contenente le Card scelte dall'utente, e le rimuove chiamando la funzione
		this.removeCards(chosen);
		return chosen;
	}
}
