package main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game 
{
	private ArrayList<Card> cards;
	
	private int number_of_players;
	
	private int index_players;
	
	private Player players[];
	
	private Player active_player;
	
	//private CommonGoal common_goals[];
	
	private LivingRoom living_room;
	
	public Game(int n)
	{
		Scanner sc= new Scanner(System.in);
		this.cards= new ArrayList<Card>(); 
		generateCards();//calling function to generate the 122 cards
		this.cards.sort(null);//mixing the bag
		this.number_of_players=n;
		for(int i=0; i<this.number_of_players; i++)//creating players
		{
			System.out.print("Insert Player "+i+1+" name: ");
			String name=sc.nextLine();
			Player p= new Player(name, i);
			this.players[i]=p;
		}
		this.setPersonalGoal();//calling the funtion to pick the personal goals
		System.out.println("Press enter to randomly decide who get the chair and starts to play....");
		sc.next();
		Random random = new Random();//deciding who starts
		this.index_players = random.nextInt(this.number_of_players + 0) + 0;
		this.players[this.index_players].setChair();//setting the chair to the player extracted randomly
		System.out.println("The player that recive the chair is "+this.players[this.index_players].getName()+"!!!");
		this.players[this.index_players]=this.active_player;//setting the active player
		System.out.print("Press enter to extract 2 Common Goals....");sc.next();
		int c2; int c1;
		do 
		{
			c1 = random.nextInt(12+0)+1; //extrating number between 1-12 to decide which common goals are extracted
			c2 = random.nextInt(12+0)+1;
		}while(c1==c2);
		//insert in common_goals[] the goals extracted
		this.living_room= new LivingRoom(this.number_of_players);
		sc.close();
	}
	
	public void turn()
	{
		int index_players=0;//varible to manage the turns
		Scanner sc=new Scanner(System.in);
		boolean control=true;
		boolean exit=false;//variable for the last turns of players
		while(control)
		{
			System.out.println("It's "+this.active_player.getName()+"'s turn!");
			System.out.println("Select a option in the MENU': ");
			System.out.println("1)Show the LIVING ROOM");
			System.out.println("2)Show your LIBRARY");
			System.out.println("3)Show the COMMON GOALS");
			System.out.println("4)Show your PERSONAL GOALS");
			System.out.println("5)Choose the cards from the LIVING ROOM and insert in LIBRARY");
			System.out.print("Insert your choice: ");
			int choice=sc.nextInt();
			switch(choice)
			{
				case 1:
					this.living_room.output();
					break;
				case 2:
					this.active_player.getLibrary().output();
					break;
				case 3:
					//show common goals
					break;
				case 4:
					this.active_player.getPersonalGoal().output();
					break;
				case 5:
					this.chooseCard();//entering the method where the player choose the cards
					if(this.active_player.getLibrary().checkFullness())//check if the library is full for end the game
					{
						exit=true;
					}
					savePlayer();//saving the modification added to active_player
					index_players++;//incrementing the index of array players
					if(index_players==this.number_of_players)//when the player is the last player in the array, the next one will be in position 0 of the array
					{
						index_players=0;
					}
					nextPlayer();//switching active_player to next Player in array player
					if(this.active_player.getChair()==true && exit==true)
					{
						control=false;//exit the game if the next player has the chair and someone completed the library
					}
					break;
				default:
					System.out.println("Choose one of the options in the menù!");
					break;
			}
			System.out.println("Press ENTER key to continue...");
			sc.next();
		}
		endGame();
		sc.close();
		//switch player
		//end game only to player before the chair
	}
	public void savePlayer()//function to save in players array the modify added to active_player
	{
		this.players[index_players]=this.active_player;
	}
	
	public void nextPlayer()//switching active player to the next player
	{
		this.active_player=this.players[index_players];
	}
	
	public void chooseCard()
	{
		// coordinates, direction, number of cards
		ArrayList<Card> chosen = new ArrayList<Card>();//list for the choosen cards
		Scanner sc=new Scanner(System.in);
		boolean control=false;
		while(control==false)
		{
			//asking the cooredinates of the first card
			System.out.println("Insert x coordinate of first card: ");
			String sx=sc.nextLine(); int x=Integer.parseInt(sx);
			System.out.println("Insert y coordinate of first card: ");
			String sy=sc.nextLine(); int y=Integer.parseInt(sy);
			System.out.println("Insert the direction of the next cards(N-E-S-W): ");
			String direction=sc.nextLine();
			while(direction!="N"&&direction!="S"&&direction!="W"&&direction!="E")
			{
				System.out.println("You must choose N or E or S or W");
				direction=sc.nextLine();						
			}
			System.out.print(this.active_player.getName()+", insert the amount of cards you want to pick(1,2,3) :");
			int n_ofcards=sc.nextInt();//asking the player how many cards he want to pick
			while(n_ofcards<1 || n_ofcards>3)
			{
				System.out.print("You must select a number between 1 and 3: ");
				n_ofcards=sc.nextInt();
			}
			if(this.living_room.controlChosenCards(x,y,direction, n_ofcards))//if the control in livingroom permits picking the cards, they get removed from the table
			{
				control=true;
				chosen=this.living_room.getCards(x,y,direction, n_ofcards);//getting the cards from the living where
				this.active_player.getLibrary().output();//output the player's library
				System.out.print("Insert in which column you want to insert your "+chosen.size()+" new cards: ");
				int column=sc.nextInt();//asking the player in which column he want to put the cards
				while(this.active_player.getLibrary().insertInLibrary(chosen, column)==false)//while the player can't insert, the game ask another column
				{
					System.out.println("You can't insert in column "+column+", choose another one: ");
					column=sc.nextInt();
				}
			}
			else//user have to input again
			{
				System.out.println("Cards must be in order! Enter again the coordinates");
			}
		}
		sc.close();
	}
	
	public void generateCards()
	{
		String colors[]= {"pink", "blue", "green", "cyan", "yellow", "white"};
		for(int j=0; j<6; j++)
		{
			for(int i=0; i<22; i++)
			{
				Card t= new Card(colors[j], i);
				this.cards.add(t);
			}
		}
	}
	
	public void setPersonalGoal()//set 1 personal goal for each player
	{
		Scanner sc= new Scanner(System.in);
		boolean control;
		Random random= new Random();
		ArrayList<Integer> generated_ids= new ArrayList<Integer>();//creating an ArrayList for checking duplicates extractions
		for(int i=0; i<this.number_of_players; i++)
		{
			int a = random.nextInt(12+0)+1;//generating the number of PersonalGoal
			control=true;
			while(control)
			{
				if(generated_ids.contains(a))//control if the generated numbers have already been picked
				{
					a = random.nextInt(12+0)+1;
				}
				else
				{
					generated_ids.add(a);//adding the number to the ArrayList
					control=false;//stop the cycle to generate the next number
				}
			}
		}
		for(int y=0; y<this.number_of_players; y++)
		{
			players[y].setPersonalGoal(generated_ids.get(y));//setting the personal goal to each player
			System.out.println(players[y].getName()+"'s Personal Goal :");
			players[y].getLibrary().output();
			System.out.print("Press enter key to continue....");
			sc.next();
		}
		sc.close();
	}
	
	public boolean getCard()
	{
		return true;
	}
	
	public void endGame()
	{
		int max=0; int id=0;
		Scanner sc= new Scanner(System.in);
		for(int i=0; i<this.number_of_players; i++)
		{
			System.out.println(players[i].getName()+" totalized "+players[i].getPoints()+" points");
			if(i==0) {max=players[i].getPoints();}
			if(max<players[i].getPoints())
			{
				max=players[i].getPoints();
				id=i;
			}
		}
		System.out.print("Press enter to continue"); sc.next();
		System.out.println("The WINNER is "+players[id].getName()+"!!!");
		sc.close();
	}
	
	

}
