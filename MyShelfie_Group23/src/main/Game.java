package main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game 
{
	private ArrayList<Card> cards;
	
	private int number_of_players;
	
	private Player players[];
	
	private Player active_player;
	
	private CommonGoal common_goals[];
	
	private LivingRoom living_room;
	
	public Game(int n)
	{
		this.cards= new ArrayList<Card>(); 
		generateCards();//calling function to generate the 122 cards
		this.cards.sort(null);//mixing the bag
		this.number_of_players=n;
		for(int i=0; i<this.number_of_players; i++)//creating players
		{
			Scanner sc= new Scanner(System.in);
			System.out.print("Insert Player "+i+1+" name: ");
			String name=sc.nextLine();
			Player p= new Player(name, i);
			this.players[i]=p;
			sc.close();
		}
		this.setPersonalGoal();//calling the funtion to pick the personal goals
		System.out.println("Press enter to randomly decide who get the chair and starts to play....");
		Random random = new Random();//deciding who starts
		int value = random.nextInt(this.number_of_players + 0) + 0;
		this.players[value].setChair();//setting the chair to the player extracted randomly
		System.out.println("The player that recive the chair is "+this.players[value].getName()+"!!!");
		this.players[value]=this.active_player;//setting the active player
		System.out.print("Press enter to extract 2 COMMON GOALS....");
		int c2; int c1;
		do 
		{
			c1 = random.nextInt(12+0)+1; //extrating number between 1-12 to decide which common goals are extracted
			c2 = random.nextInt(12+0)+1;
		}while(c1==c2);
		//insert in common_goals[] the goals extracted
		this.living_room= new LivingRoom(this.number_of_players);
	}
	
	public void turn()
	{
		Scanner sc=new Scanner(System.in);
		boolean control=true;
		while(control)
		{
			this.chooseCard();
		}
		//control of points
		//switch player
		//end game only to player before the chair
	}
	
	public void chooseCard()
	{
		ArrayList<Card> chosen = new ArrayList<Card>();//list for the choosen cards
		System.out.print(this.active_player.getName()+", insert the amount of cards you want to pick(1,2,3) :");
		Scanner sc=new Scanner(System.in);
		int n_ofcards=sc.nextInt();//asking the player how many cards he want to pick
		boolean control=false;
		while(control==false)
		{
			while(n_ofcards<1 || n_ofcards>3)
			{
				System.out.print("You must select a number between 1 and 3: ");
				n_ofcards=sc.nextInt();
			}
			for(int i=0; i<n_ofcards; i++)//input from the user
			{
				System.out.println("Insert x coordinate of "+i+1+" card: ");
				int x=sc.nextInt();
				System.out.println("Insert y coordinate of "+i+1+" card: ");
				int y=sc.nextInt();
				//choosen.add(living_room.getCard(int x, int y));//adding to chosen the card selected
			}
			/*if(this.living_room.controlChosenCards())/if the control in livingroom permits picking the cards, they get removed from the table
			{
				control=true;
				this.living_room.removeCards(chosen);
			}
			else//user have to input again
			{
				System.out.println("Cards must be in order! Enter again the coordinates");
				chosen.clear();//remove all the elements from the list
			}*/
		}
		
		sc.close();
	}
	
	public void generateCards()
	{
		
	}
	
	public boolean controlCommonGoals()
	{
		return true;
	}
	
	public boolean controlPersonalGoal()
	{
		return true;
	}
	
	public void setPersonalGoal()//set 1 personal goal for each player
	{
		boolean control;
		Random random= new Random();
		ArrayList<Integer> generated_ids= new ArrayList<Integer>();
		for(int i=0; i<this.number_of_players; i++)
		{
			int a = random.nextInt(12+0)+1;
			control=true;
			while(true)
			{
				if(generated_ids.contains(a))//control if the generated numbers have already been picked
				{
					a = random.nextInt(12+0)+1;
				}
				else
				{
					generated_ids.add(a);
					control=false;
				}
			}
		}
		for(int y=0; y<this.number_of_players; y++)
		{
			players[y].setPersonalGoal(generated_ids.get(y));//setting the personal goal to each player
		}
	}
	
	public boolean getCard()
	{
		return true;
	}
	
	

}
