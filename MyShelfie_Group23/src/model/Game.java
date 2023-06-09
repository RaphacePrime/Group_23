package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import board.*;
import commongoals.*;
import player.*;

public class Game
{
	private ArrayList<Card> cards;

	private int number_of_players;

	private int index_players;

	private ArrayList<Player> players;

	private Player active_player;

	private CommonGoal common_goals[];

	private LivingRoom living_room;

	/**
	 * Constructs a new Game object with the specified number of players.
	 *
	 * @param n the number of players in the game
	 */
	public Game(int n)
	{
		players = new ArrayList<Player>();
		cards = new ArrayList<Card>();
		number_of_players = n;
		common_goals = new CommonGoal[2];
		generateCards();// calling function to generate the 122 cards
		createPlayers();
		setPersonalGoal();// calling the function to pick the personal goals
		System.out.println("");
		System.out.print("Press ENTER to randomly decide who get the chair and starts to play....");
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		Random random = new Random();// deciding who starts
		this.index_players = random.nextInt(this.number_of_players + 0) + 0;
		this.players.get(this.index_players).setChair();// setting the chair to the player extracted randomly
		System.out.println("The player that recive the chair is " + players.get(this.index_players).getName() + "!!!");
		this.active_player = this.players.get(index_players);// setting the active player
		System.out.println("");
		System.out.print("Press ENTER to extract 2 Common Goals....");
		sc.reset();
		sc.nextLine();
		setCommonGoals();
		System.out.println("The Common Goals have been extracted :");
		System.out.print("1) ");
		this.common_goals[0].output();
		System.out.print("2) ");
		this.common_goals[1].output();
		System.out.println("");
		this.living_room = new LivingRoom(this.number_of_players, cards);
	}

	/**
	 * Creates the players for the game by taking user input for their names.
	 */
	public void createPlayers()
	{
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < this.number_of_players; i++)// creating players
		{
			System.out.print("Insert Player " + (i + 1) + " name: ");
			String name = sc.nextLine();
			while(name.equals(""))
			{
				System.out.print("You should have a name!: ");
				name = sc.nextLine();
			}
			Player p = new Player(name, i);
			this.players.add(p);// adding the player created in the arrayList
		}

	}

	/**
	 * Executes a turn in the game where the active player can perform actions.
	 */
	public void turn()
	{
		int index_players = 0;// variable to manage the turns
		boolean point_assigned = false;
		Scanner sc = new Scanner(System.in);
		boolean control = true;
		boolean exit = false;// variable for the last turns of players
		while (control)
		{
			System.out.println("");
			System.out.println(this.active_player.getName() + "'s turn");
			System.out.println("\tSelect a option in the MENU': ");
			System.out.println("\t1)Show the LIVING ROOM");
			System.out.println("\t2)Show your LIBRARY");
			System.out.println("\t3)Show the COMMON GOALS");
			System.out.println("\t4)Show your PERSONAL GOALS");
			System.out.println("\t5)Choose the cards from the LIVING ROOM and insert in LIBRARY");
			int choice;
			do
			{
				System.out.print("Insert your choice (1 to 5): ");
				String string_choice = sc.nextLine();
				try
				{
					choice = Integer.parseInt(string_choice);
				} catch (NumberFormatException e)
				{
					choice = 0;
				}
			} while (choice <= 0 || choice >= 6);
			switch (choice)
			{
			case 1:
				this.living_room.output();
				break;
			case 2:
				this.active_player.getLibrary().output();
				break;
			case 3:
				System.out.println("The Common Goals are :");
				System.out.print("1) ");
				this.common_goals[0].output();// output common goal 1
				if (this.active_player.getCheckCommonGoals(0)) // checking if player completed goal 1
				{
					System.out.println("- COMPLETED");
				} else
				{
					System.out.println("- IN PROGRESS");
				}
				System.out.print("2) ");
				this.common_goals[1].output();// output common goal 2
				if (this.active_player.getCheckCommonGoals(1)) // checking if player completed goal 2
				{
					System.out.println("- COMPLETED");
				} else
				{
					System.out.println("- IN PROGRESS");
				}
				System.out.println("");
				break;
			case 4:
				this.active_player.getPersonalGoal().output();
				break;
			case 5:
				this.chooseCard();// entering the method where the player choose the cards
				if (this.active_player.getCheckCommonGoals(0) == false)// if the player hasn't completed the goal yet,
																		// control the library
				{
					if (this.common_goals[0].checkGoal(active_player))// if the goal is completed, assign the points to
																		// the player
					{
						int points_gained = this.common_goals[0].assignPoints();
						System.out.println(this.active_player.getName() + " has completed the Common Goal 1 and gained "
								+ points_gained);
						this.active_player.addPoints(points_gained);
						this.active_player.setCheckCommonGoals(0);
					}
				}
				if (this.active_player.getCheckCommonGoals(1) == false)// if the player hasn't completed the goal yet,
																		// control the library
				{
					if (this.common_goals[1].checkGoal(active_player))// if the goal is completed, assign the points to
																		// the player
					{
						int points_gained = this.common_goals[1].assignPoints();
						System.out.println(this.active_player.getName() + " has completed the Common Goal 2 and gained "
								+ points_gained);
						this.active_player.addPoints(points_gained);
						this.active_player.setCheckCommonGoals(1);
					}
				}
				if (this.active_player.getLibrary().checkFullness())// check if the library is full for end the game
				{
					exit = true;
					if (!point_assigned)
					{
						this.active_player.addPoints(1);
						point_assigned = true;
					}
				}
				System.out.println("");
				savePlayer();// saving the modification added to active_player
				System.out.println(this.active_player.getName() + " has ended his turn...");
				nextPlayer();// switching active_player to next Player in array player
				System.out.println("The next player is " + this.active_player.getName());
				if (this.active_player.getChair() == true && exit == true)
				{
					control = false;// exit the game if the next player has the chair and someone completed the
									// library
				}

				this.living_room.reset();// if the living room is nearly empty, it resets
				break;
			/*case 6: //SUDO MODE, for enable it, you need to eliminate the comment on case 6, and on line 118 you need to put 7 in the while instead of 6
				System.out.println("SUDO mode:");
				Card[][] matrix2 = new Card[6][5];
				for (int i = 0; i < 6; i++)
				{
					for (int y = 0; y < 5; y++)
					{
						String color;
						System.out.print("Insert " + i + ", " + y + " :");
						color = sc.nextLine();
						while (!color.equals("green") && !color.equals("white") && !color.equals("pink")
								&& !color.equals("cyan") && !color.equals("blue") && !color.equals("yellow")
								&& !color.equals("null") && color != null)
						{
							System.out.print("Insert " + i + ", " + y + " :");
							color = sc.nextLine();
						}
						if (color.equals("null") || color == null)
						{
							matrix2[i][y] = new Card();
						} else
						{
							matrix2[i][y] = new Card(color, 1);
						}
					}
				}
				this.active_player.getLibrary().setMatrix(matrix2);
				break;*/  
			default:
				System.out.println("Choose one of the options in the menù!");
				break;
			}
			System.out.println("");
			System.out.println("Press ENTER key to continue...");
			sc.nextLine();
		}
		endGame();// end the game
		// switch player
		// end game only to player before the chair
	}

	/**
	 * Saves the modifications made to the active player and updates the player
	 * array.
	 */
	public void savePlayer()// function to save in players array the modify added to active_player
	{
		this.players.set(index_players, active_player);
	}

	/**
	 * Switches the active player to the next player in the player array.
	 */
	public void nextPlayer()// switching active player to the next player
	{
		if (this.index_players == this.number_of_players - 1)
		{
			this.index_players = 0;
		} else
		{
			this.index_players += 1;
		}
		this.active_player = this.players.get(index_players);
	}

	/**
	 * Allows the active player to choose cards from the living room and insert them
	 * into their library.
	 */
	public void chooseCard()
	{
		System.out.println("");
		System.out.println("" + this.active_player.getName() + "'s library: ");
		this.active_player.getLibrary().output();
		System.out.println("");
		System.out.println("" + this.active_player.getName() + "'s Personal Goal: ");
		this.active_player.getPersonalGoal().output();
		System.out.println("");
		System.out.println("The living room: ");
		this.living_room.output();
		// coordinates, direction, number of cards
		ArrayList<Card> chosen = new ArrayList<Card>();// list for the chosen cards
		Scanner sc = new Scanner(System.in);
		Scanner scint = new Scanner(System.in);
		boolean control = false;
		while (control == false)
		{
			// asking the coordinates of the first card

			int x;
			do
			{
				System.out.println("Insert x coordinate of first card: ");
				String sx = sc.nextLine();
				try
				{
					x = Integer.parseInt(sx);
				} catch (NumberFormatException e)
				{
					x = 0;
				}
			} while (x <= 0 || x >= 10);

			int y;
			do
			{
				System.out.println("Insert y coordinate of first card: ");
				String sy = sc.nextLine();
				try
				{
					y = Integer.parseInt(sy);
				} catch (NumberFormatException e)
				{
					y = 0;
				}
			} while (y <= 0 || y >= 10);
			int max = countMaxCardToImport(this.active_player.getLibrary());
			if (max > 3)
			{
				max = 3;
			}
			System.out.print(
					this.active_player.getName() + ", insert the amount of cards you want to pick(max. " + max + ") :");
			int n_ofcards;// asking the player how many cards he want to pick
			String string_choice = sc.nextLine();
			try
			{
				n_ofcards = Integer.parseInt(string_choice);
			} catch (NumberFormatException e)
			{
				n_ofcards = 0;
			}
			while (n_ofcards < 1 || n_ofcards > max)
			{
				if (max == 1)
				{
					System.out.print("Sorry, you can select only one card!");
					n_ofcards = 1;
				} else
				{
					System.out.print("You must select a number between 1 and " + max + ": ");
					string_choice = sc.nextLine();
					try
					{
						n_ofcards = Integer.parseInt(string_choice);
					} catch (NumberFormatException e)
					{
						n_ofcards = 0;
					}
				}
			}
			String direction;
			if (n_ofcards == 1)
			{
				direction = "N";
			} else
			{
				System.out.println("Insert the direction of the next cards(N-E-S-W): ");
				direction = sc.nextLine().toUpperCase();
				while (!direction.equals("N") && !direction.equals("S") && !direction.equals("W")
						&& !direction.equals("E"))
				{
					System.out.println("You must choose N or E or S or W");
					direction = sc.nextLine().toUpperCase();

				}
			}
			// this.living_room.controlChosenCards(x,y,direction, n_ofcards)
			if (this.living_room.controlChosenCards(x, y, direction, n_ofcards))// if the control in livingroom permits
																				// picking the cards, they get removed
																				// from the table
			{
				control = true;
				chosen = this.living_room.getCards(x, y, direction, n_ofcards);// getting the cards from the living
																				// where
				this.active_player.getLibrary().output();// output the player's library
				System.out.print("Insert in which column you want to insert your " + chosen.size() + " new cards: ");
				String string_column = sc.nextLine();// asking the player in which column he want to put the cards
				int column;
				try
				{
					column = Integer.parseInt(string_column);
				} catch (NumberFormatException e)
				{
					column = 0;
				}
				while (column <= 0 || column > 5)
				{
					System.out.print("The column you chose doesn't exist, choose another one: ");
					string_column = sc.nextLine();
					try
					{
						column = Integer.parseInt(string_column);
					} catch (NumberFormatException e)
					{
						column = 0;
					}
				}
				while (this.active_player.getLibrary().insertInLibrary(chosen, column) == false)// while the player
																								// can't insert, the
																								// game ask another
																								// column
				{
					System.out.println("You can't insert in column " + column + ", choose another one: ");
					column = scint.nextInt();
				}
			} else// user have to input again
			{
				System.out.println("You can't select these cards, try again!");
			}
		}
	}

	/**
	 * Generates the cards for the game.
	 */
	public void generateCards()
	{
		String colors[] =
		{ "pink", "blue", "green", "cyan", "yellow", "white" };
		for (int j = 0; j < 6; j++)
		{
			for (int i = 0; i < 22; i++)
			{
				Card t = new Card(colors[j], i);
				this.cards.add(t);
				// System.out.println(t.getColor()+t.getID());
			}
		}
		Collections.shuffle(cards);
		;// mixing the bags
		/*
		 * for(int i=0; i<cards.size(); i++) {
		 * System.out.println(cards.get(i).getColor()+cards.get(i).getID()); }
		 */
	}

	/**
	 * Sets the personal goals for each player in the game.
	 */
	public void setPersonalGoal()// set 1 personal goal for each player
	{
		System.out.println("");
		System.out.println("Press ENTER to extract Personal Goals...");
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		boolean control;
		Random random = new Random();
		ArrayList<Integer> generated_ids = new ArrayList<Integer>();// creating an ArrayList for checking duplicates
																	// extractions
		for (int i = 0; i < this.number_of_players; i++)
		{
			int a = random.nextInt(12 + 0) + 1;// generating the number of PersonalGoal
			control = true;
			while (control)
			{
				if (generated_ids.contains(a))// control if the generated numbers have already been picked
				{
					a = random.nextInt(12 + 0) + 1;
				} else
				{
					generated_ids.add(a);// adding the number to the ArrayList
					control = false;// stop the cycle to generate the next number
				}
			}
		}
		for (int y = 0; y < this.number_of_players; y++)
		{
			players.get(y).setPersonalGoal(generated_ids.get(y));// setting the personal goal to each player
			System.out.println(players.get(y).getName() + "'s Personal Goal :");
			players.get(y).getPersonalGoal().output();
			System.out.println("");
			System.out.print("Press ENTER key to continue....");
			sc.nextLine();
		}
		// System.out.print("Press ENTER key to continue....");
		// sc.nextLine();
	}

	/**
	 * Ends the game and displays the winner and their points.
	 */
	public void endGame()
	{
		int max = 0;
		int id = 0;
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < this.number_of_players; i++)
		{
			this.players.get(i).getPersonalGoal().controlGoal(this.players.get(i).getLibrary());
			int personalgoal_point = this.players.get(i).getPersonalGoal().GetPoints();
			int end_points = AdjacentItemTiles.CheckAdjacentItemTiles(this.players.get(i).getLibrary().getMatrix());
			this.players.get(i).addPoints(personalgoal_point);
			this.players.get(i).addPoints(end_points);
			System.out.println("PG points: " + personalgoal_point + ", End points: " + end_points);
			System.out.println(players.get(i).getName() + " totalized " + players.get(i).getPoints() + " points");
			if (i == 0)
			{
				max = players.get(i).getPoints();
			}
			if (max < players.get(i).getPoints())
			{
				max = players.get(i).getPoints();
				id = i;
			}
		}
		System.out.println("");
		System.out.print("Press ENTER to continue");
		sc.nextLine();
		System.out.println("The WINNER is " + players.get(id).getName() + "!!!");
	}

	/**
	 * Sets the common goals for the game by randomly selecting two common goals.
	 */
	private void setCommonGoals()
	{
		Random random = new Random();// deciding who starts
		int c2;
		int c1;
		do
		{
			c1 = random.nextInt(12 + 0) + 1; // extracting number between 1-12 to decide which common goals are
												// extracted
			c2 = random.nextInt(12 + 0) + 1;
		} while (c1 == c2);
		// System.out.println("CG extracted are: Goal number "+c1+" and Goal number
		// "+c2);
		int index_commongoals = 0;
		if (c1 == 1 || c2 == 1) // creating 2 different commongoals and
		{
			CommonGoal c = new CommonGoal_1(1);
			this.common_goals[index_commongoals] = c;
			index_commongoals++;
		}
		if (c1 == 2 || c2 == 2)
		{
			CommonGoal c = new CommonGoal_2(2);
			this.common_goals[index_commongoals] = c;
			index_commongoals++;
		}
		if (c1 == 3 || c2 == 3)
		{
			CommonGoal c = new CommonGoal_3(3);
			this.common_goals[index_commongoals] = c;
			index_commongoals++;
		}
		if (c1 == 4 || c2 == 4)
		{
			CommonGoal c = new CommonGoal_4(4);
			this.common_goals[index_commongoals] = c;
			index_commongoals++;
		}
		if (c1 == 5 || c2 == 5)
		{
			CommonGoal c = new CommonGoal_5(5);
			this.common_goals[index_commongoals] = c;
			index_commongoals++;
		}
		if (c1 == 6 || c2 == 6)
		{
			CommonGoal c = new CommonGoal_6(6);
			this.common_goals[index_commongoals] = c;
			index_commongoals++;
		}
		if (c1 == 7 || c2 == 7)
		{
			CommonGoal c = new CommonGoal_7(7);
			this.common_goals[index_commongoals] = c;
			index_commongoals++;
		}
		if (c1 == 8 || c2 == 8)
		{
			CommonGoal c = new CommonGoal_8(8);
			this.common_goals[index_commongoals] = c;
			index_commongoals++;
		}
		if (c1 == 9 || c2 == 9)
		{
			CommonGoal c = new CommonGoal_9(9);
			this.common_goals[index_commongoals] = c;
			index_commongoals++;
		}
		if (c1 == 10 || c2 == 10)
		{
			CommonGoal c = new CommonGoal_10(10);
			this.common_goals[index_commongoals] = c;
			index_commongoals++;
		}
		if (c1 == 11 || c2 == 11)
		{
			CommonGoal c = new CommonGoal_11(11);
			this.common_goals[index_commongoals] = c;
			index_commongoals++;
		}
		if (c1 == 12 || c2 == 12)
		{
			CommonGoal c = new CommonGoal_12(12);
			this.common_goals[index_commongoals] = c;
			index_commongoals++;
		}
	}
	
	/**
	 * Sets the common goals for the game by randomly selecting two common goals.
	 * @param lib the library that you want to control
	 */
	public int countMaxCardToImport(Library lib)
	{
		int max = 0;
		Card[][] c = lib.getMatrix();
		for (int ncol = 0; ncol < 5; ncol++)
		{
			int count = 0;
			for (int nrig = 0; nrig < 6; nrig++)
			{
				if (c[nrig][ncol].getColor() == null)
				{
					count++;
				}
			}
			if (ncol == 0)
			{
				max = count;
			} else if (count > max)
			{
				max = count;
			}
		}
		return max;

	}
}
