package player;

import java.util.ArrayList;
import java.util.Scanner;
import board.Card;

/**
 * The Library class represents the library in the game. It manages the
 * insertion of cards into the library and keeps track of its fullness.
 */
public class Library
{

	private Card matrix[][];

	/**
	 * Constructs a new Library object. Initializes the matrix to represent the
	 * library as a 2D array of Cards.
	 */
	public Library()
	{
		this.matrix = new Card[6][5];
		for (int i = 0; i < 6; i++)
		{
			for (int y = 0; y < 5; y++)
			{
				matrix[i][y] = new Card();
			}
		}

	}

	/**
	 * Checks if the library is full. The library is considered full if all
	 * positions in the matrix have a non-null color value.
	 * 
	 * @return true if the library is full, false otherwise.
	 */
	public boolean checkFullness()
	{
		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[i].length; j++)
			{
				if (matrix[i][j].getColor() == null)
				{
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Inserts a list of chosen cards into the library at the specified column. The
	 * cards are removed from the chosen list and placed into the library matrix.
	 * 
	 * @param chosen The list of cards to be inserted into the library.
	 * @param column The column number in which the cards should be inserted.
	 * @return true if the cards were successfully inserted, false if the column
	 *         doesn't have enough space.
	 */
	public boolean insertInLibrary(ArrayList<Card> chosen, int column)
	{
		int num_elements = chosen.size();
		column--;
		int count = 0;
		for (int i = 0; i < 6; i++)
		{
			if (matrix[i][column].getColor() == null)
			{
				count++;
			}
		}
		if (count < num_elements)
		{
			return false;
		}
		while (!chosen.isEmpty())
		{
			num_elements = chosen.size();
			if (num_elements == 1)
			{
				for (int y = 5; y >= 0; y--)
				{
					if (matrix[y][column].getColor() == null || matrix[y][column].getColor().equals("N"))
					{
						matrix[y][column] = chosen.remove(0);
						break;
					}
				}
			} else
			{
				System.out.print("Choose which card you want to insert: ");
				int i = 1;
				for (Card c : chosen)
				{
					System.out.print(i + ") " + c.getColor() + " ");
					i++;
				}
				int input;
				Scanner sc = new Scanner(System.in);
				do
				{
					String string_choice = sc.nextLine();
					try
					{
						input = Integer.parseInt(string_choice);
					} catch (NumberFormatException e)
					{
						input = 0;
					}
					if (input <= 0 || input > num_elements)
					{
						System.out.print("Error, insert again which card you want to insert: ");
					}
				} while (input <= 0 || input > num_elements);

				for (int y = 5; y >= 0; y--)
				{
					if (matrix[y][column].getColor() == null || matrix[y][column].getColor().equals("N"))
					{
						matrix[y][column] = chosen.remove(input - 1);
						break;
					}
				}
			}

		}
		System.out.println("Library updated: ");
		this.output();
		return true;
	}

	/**
	 * Outputs the current state of the library matrix. Each card in the matrix is
	 * represented by a color code.
	 */
	public void output()
	{
		System.out.println("\n\t   Columns\n\t1  2  3  4  5");
		for (int i = 0; i < matrix.length; i++)
		{
			System.out.print("\t");
			for (int j = 0; j < matrix[i].length; j++)
			{
				String tileColor = matrix[i][j].getColor();
				if (tileColor == null)
				{
					System.out.print("\u001B[30m" + "*  " + "\u001B[0m");
				} else if (tileColor.equals("yellow"))
				{
					System.out.print("\u001B[33m" + "#  " + "\u001B[0m");
				} else if (tileColor.equals("pink"))
				{
					System.out.print("\u001B[35m" + "#  " + "\u001B[0m");
				} else if (tileColor.equals("blue"))
				{
					System.out.print("\u001B[34m" + "#  " + "\u001B[0m");
				} else if (tileColor.equals("green"))
				{
					System.out.print("\u001B[32m" + "#  " + "\u001B[0m");
				} else if (tileColor.equals("cyan"))
				{
					System.out.print("\u001B[36m" + "#  " + "\u001B[0m");
				} else if (tileColor.equals("white"))
				{
					System.out.print("\u001B[37m" + "#  " + "\u001B[0m");
				}
			}
			System.out.println();
		}
		System.out.println();
	}

	/**
	 * Gets the matrix representing the library.
	 * 
	 * @return The matrix representing the library.
	 */
	public Card[][] getMatrix()
	{
		return matrix;
	}

	/**
	 * Sets the matrix representing the library.
	 * 
	 * @param matrix The matrix representing the library.
	 */
	public void setMatrix(Card matrix[][])
	{
		this.matrix = matrix;
	}

}
