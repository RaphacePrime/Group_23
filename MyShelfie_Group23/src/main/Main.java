package main;

import java.util.Scanner;
import model.Game;

/**
 * The Main class is the entry point for the game. It allows the user to input
 * the number of players, creates a Game instance, and starts the game by
 * calling the turn() method.
 */
public class Main
{

	/**
	 * The main method is the entry point of the program. It prompts the user to
	 * input the number of players, validates the input, and starts the game.
	 * 
	 * @param args The command-line arguments passed to the program (unused).
	 */
	public static void main(String[] args)
	{
		System.out.print("Insert number of players: ");
		Scanner sc = new Scanner(System.in);
		sc.reset();

		String string_number_of_players = sc.nextLine();
		int number_of_players;

		try
		{
			// Convert the user input to an integer
			number_of_players = Integer.parseInt(string_number_of_players);
		} catch (NumberFormatException e)
		{
			// If the input is not a valid integer, set the number of players to 0
			number_of_players = 0;
		}

		// Validate the number of players
		while (number_of_players < 2 || number_of_players > 4)
		{
			System.out.print("Insert a number between 2 and 4: ");
			string_number_of_players = sc.nextLine();

			try
			{
				number_of_players = Integer.parseInt(string_number_of_players);
			} catch (NumberFormatException e)
			{
				number_of_players = 0;
			}
		}

		System.out.println("Press ENTER key to start...");
		sc.nextLine();
		sc.reset();

		// Create a Game instance with the specified number of players
		Game game = new Game(number_of_players);

		// Start the game
		game.turn();

		sc.close();
	}
}
