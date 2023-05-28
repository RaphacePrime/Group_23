package main;

import java.util.Scanner;

import model.Game;

public class Main {

	public static void main(String[] args) {
		System.out.print("Insert number of players: ");
		Scanner sc = new Scanner(System.in);
		sc.reset();
		String string_number_of_players=sc.nextLine();
		int number_of_players=Integer.parseInt(string_number_of_players);
		while(number_of_players<2||number_of_players>4)
		{
			System.out.print("Insert a number between 2 and 4: ");
			string_number_of_players=sc.nextLine();
			number_of_players=Integer.parseInt(string_number_of_players);
		}
		System.out.println("Press ENTER key to start...");
		sc.nextLine();
		sc.reset();
		
		Game game=new Game(number_of_players);
		game.turn();
		sc.close();
		
		
	}
}
