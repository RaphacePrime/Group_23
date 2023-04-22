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
		}
		System.out.println("Press enter to randomly decide who get the chair and starts to play....");
		Random random = new Random();//deciding who starts
		int value = random.nextInt(this.number_of_players + 0) + 0;
		this.players[value].setChair();//setting the chair to the player extracted randomly
		System.out.println("The player that recive the chair is "+this.players[value].getName()+"!!!");
		this.players[value]=this.active_player;//setting the active player
		System.out.print("Press enter to extract 2 COMMON GOALS....");
		int c1 = random.nextInt(12+0)+1; //extrating number between 1-12 to decide which common goals are extracted
		int c2= random.nextInt(12+0)+1;
	}
	
	public void turn()
	{
		
	}
	
	public void chooseCard(int x, int y)
	{
		
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
	
	public void setPersonalGoal()
	{
		
	}
	
	public boolean getCard()
	{
		return true;
	}
	
	

}
