package player;

import java.io.FileNotFoundException;

public class Player {
	
	private String name;
	
	private final int id;
	
	private boolean chair;
	
	private Library library;
	
	private PersonalGoal personalGoal; 
	
	private boolean check_commonGoals[];//check if goal 1 and goal 2 are completed
	
	private int points;
	
	public Player(String name, int id) 
	{
		this.name = name;
		this.id = id;
		this.chair=false;
		this.points = 0;	
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setChair()
	{
		this.chair=true;
	}
	
	public boolean getChair()
	{
		return this.chair;
	}
	
	public Library getLibrary()
	{
		return this.library;
	}
	
	public int getPoints()
	{
		return this.points;
	}
	
	public void setPersonalGoal(int id)
	{
		try {
			this.personalGoal= new PersonalGoal(id);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public PersonalGoal getPersonalGoal()
	{
		return this.personalGoal;
	}
	
	public void addPoints(int n) 
	{
		this.points+=n;
	}
	
	public void setCheckCommonGoals(int n) //set check_commongoals[0] or check_commongoals[1] to true
	{
		this.check_commonGoals[n]=true;
	}
	
	public boolean getCheckCommonGoals(int n)
	{
		return this.check_commonGoals[n];
	}

}
