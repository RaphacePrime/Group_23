package board;

import java.util.ArrayList;

public class LivingRoom 
{
	private LivingRoomTile matrix [][];
	
	private ArrayList<Card> cards;
	
	/**
	 * This constructor decides whether each tile of the board 
	 * is legal or illegal depending on the number of players in the game.
	 * Then it calls the method LivingRoom.Reset to fill the board with cards.
	 * @param numberOfPlayers the number of players in the current game
	 * @param cards the randomized list of cards which will be used in the current game
	 */
	public LivingRoom(int numberOfPlayers, ArrayList<Card> cards)
	{
		this.cards = cards;
		
		this.matrix = new LivingRoomTile[9][9];
		
		int initializationMatrix [][] = 	{	{5, 5, 5, 3, 4, 5, 5, 5, 5},
												{5, 5, 5, 2, 2, 4, 5, 5, 5},
												{5, 5, 3, 2, 2, 2, 3, 5, 5},
												{5, 4, 2, 2, 2, 2, 2, 2, 3},
												{4, 2, 2, 2, 2, 2, 2, 2, 4},
												{3, 2, 2, 2, 2, 2, 2, 4, 5},
												{5, 5, 3, 2, 2, 2, 3, 5, 5},
												{5, 5, 5, 4, 2, 2, 5, 5, 5},
												{5, 5, 5, 5, 4, 3, 5, 5, 5},	};
		
		for (int x = 0; x < 9; x++)
		{
			for (int y = 0; y < 9; y++)
			{
				if (initializationMatrix[x][y] <= numberOfPlayers)
					matrix[x][y] = new LivingRoomTile(true);
				else 
					matrix[x][y] = new LivingRoomTile(false);
			}
		}
		this.reset();
	}
	
	/**
	 * This method checks if the board needs resetting 
	 * (no card on the board has an adjacent card in any direction) 
	 * if the condition is met, it then fills the legal tiles of the board 
	 * with cards which were not yet used.
	 */
	public void reset () 
	{
		if (!this.checkReset()) {
			return;
		}
		System.out.println("The board is being resetted...");
		for (int x = 0; x < 9; x++)
		{
			for (LivingRoomTile tile : matrix[x])
			{
				if (tile.isLegalTile())
				{
					tile.setCard(cards.remove(0));	
				}
			}
		}
	}
	
	private boolean checkReset()
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
	/**
	 * This method shows the current state of the board
	 * on the console. Cards are shown as a color-coded "*".
	 */
	public void output()
	{
		System.out.println("\t\t  y\n\t  1 2 3 4 5 6 7 8 9");
		for (int x = 0; x < 9; x++)
		{
			if(x==4) {
				System.out.print("      x");
			}
			System.out.print("\t" + (x+1) + " ");
			for (LivingRoomTile tile : matrix[x])
			{
				if (!tile.isLegalTile()) {
					System.out.print("\u001B[30m" + "x " + "\u001B[0m");
				}
				else if(!tile.isOccupied()) {	
					System.out.print("\u001B[30m" + "* " + "\u001B[0m");
				}
				else {
					String tileColor = new String();
					tileColor = tile.getCard().getColor();
					if(tileColor.equals("yellow")) {
						System.out.print("\u001B[33m" + "# " + "\u001B[0m");
					}else if(tileColor.equals("pink")) {
						System.out.print("\u001B[31m" + "# " + "\u001B[0m");
					}else if(tileColor.equals("blue")) {
						System.out.print("\u001B[34m" + "# " + "\u001B[0m");
					}else if(tileColor.equals("green")) {
						System.out.print("\u001B[32m" + "# " + "\u001B[0m");
					}else if(tileColor.equals("cyan")) {
						System.out.print("\u001B[36m" + "# " + "\u001B[0m");
					}else if(tileColor.equals("white")) {
						System.out.print("\u001B[37m" + "# " + "\u001B[0m");
					}
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
	/**
	 * This method checks if the cards that the player wants to remove 
	 * are actually removable.
	 * @param x the x-coordinate of the first card that the player wants to remove
	 * @param y the y-coordinate of the first card that the player wants to remove
	 * @param direction the cardinal direction in which the array of cards continues
	 * @param numberOfCards how many cards the player has selected (1 to 3)
	 * @return true if the cards are removable, false otherwise
	 */
	public boolean controlChosenCards(int x, int y, String direction, int numberOfCards)
	{
		--x;
		--y;
		int xAxisShift = 0;
		int yAxisShift = 0;
		switch (direction)
		{
		case "N":
			xAxisShift = -1;
			break;
		case "S":
			xAxisShift = 1;
			break;
		case "W":
			yAxisShift = -1;
			break;
		case "E":
			yAxisShift = 1;
			break;
		}
		for (int i=0; i < numberOfCards; i++)
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
	
	/**
	 * This method creates an ArrayList which contains 1 to 3 cards selected by the player,
	 * these cards get removed from the board and will be later put in the player's library
	 * @param startX the x-coordinate of the first card that the player wants to remove
	 * @param startY the y-coordinate of the first card that the player wants to remove
	 * @param direction direction the cardinal direction in which the array of cards continues
	 * @param numberOfCards how many cards the player has selected (1 to 3)
	 * @return an ArrayList which contains the cards removed from the board by the player
	 */
	public ArrayList<Card> getCards(int startX, int startY, String direction, int numberOfCards) {
		--startX;
		--startY;
		int xAxisShift = 0;
		int yAxisShift = 0;
		ArrayList<Card> chosenCards = new ArrayList<Card>();
		switch (direction)
		{
		case "N":
			xAxisShift = -1;
			break;
		case "S":
			xAxisShift = 1;
			break;
		case "W":
			yAxisShift = -1;
			break;
		case "E":
			yAxisShift = 1;
		}
		for (int i=0; i < numberOfCards; i++)
		{
			int x = startX + i*xAxisShift;
			int y = startY + i*yAxisShift;
			chosenCards.add(matrix[x][y].getCard());
			matrix[x][y].setCard(null);
		}
		return chosenCards;
	}
}