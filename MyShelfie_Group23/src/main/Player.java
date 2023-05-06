package main;

import java.io.FileNotFoundException;

public class Player {
	
	private String name;
	
	private final int id;
	
	private boolean chair;
	
	private Library library;
	
	private PersonalGoal personalGoal; 
	
	private boolean CommonGoals[];
	
	private int points;
	
	public Player(String name, int id) {
		
		this.name = name;
		this.id = id;
		
		if(this.id == 1) {
			this.chair = true;
		}else {
			this.chair = false;
		}
		
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
	
	public Library getLibrary()
	{
		return this.library;
	}
	
	public boolean getChair()
	{
		return this.chair;
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
	
	public void calculatePoints() {
		
	}
	
	public void setCommonGoals() {
		
	}
	
	public void insertInLibrary(Card c) {
		
	}

}
