package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.print("Insert number of player: ");
		Scanner sc = new Scanner(System.in);
		int number_of_players=sc.nextInt();
		System.out.println("Press ENTER key to start...");
		sc.next();
		Game game=new Game(number_of_players);
		game.turn();
		sc.close();
	}

}
