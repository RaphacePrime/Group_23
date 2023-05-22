package player;

import java.io.FileNotFoundException;

public class Player {
	
	private String name;
	
	private final int id;
	
	private boolean chair;
	
	private Library library;
	
	private PersonalGoal personalGoal; 
	
	private boolean check_commonGoals[]={false, false};//check if goal 1 and goal 2 are completed
	
	private int points;
	
	/**
	 * Constructor for Player class
	 * 
	 * @param name the name of the player
	 * @param id the id of the player
	 */
	public Player(String name, int id) 
	{
		this.name = name;
		this.id = id;
		this.chair=false;
		this.points = 0;	
		this.library= new Library();
	}
	
	/**
	 * Returns the name of the player
	 * 
	 * @return the name of the player
	 */
	public String getName()
	{
		return this.name;
	}
	
	/**
	 * Sets the chair of the player to true
	 */
	public void setChair()
	{
		this.chair=true;
	}
	
	/**
	 * Returns whether or not the player is sitting in a chair
	 * 
	 * @return true if the player is sitting in a chair, false otherwise
	 */
	public boolean getChair()
	{
		return this.chair;
	}
	
	/**
	 * Returns the library of the player
	 * 
	 * @return the library of the player
	 */
	public Library getLibrary()
	{
		return this.library;
	}
	
	/**
	 * Returns the points of the player
	 * 
	 * @return the points of the player
	 */
	public int getPoints()
	{
		return this.points;
	}
	
	/**
	 * Sets the personal goal of the player
	 * 
	 * @param id the id of the personal goal to be set
	 */
	public void setPersonalGoal(int id)
	{
		try {
			this.personalGoal= new PersonalGoal(id);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns the personal goal of the player
	 * 
	 * @return the personal goal of the player
	 */
	public PersonalGoal getPersonalGoal()
	{
		return this.personalGoal;
	}
	
	/**
	 * Adds the specified number of points to the player's score
	 * 
	 * @param n the number of points to add
	 */
	public void addPoints(int n) 
	{
		this.points+=n;
	}
	
	/**
	 * Sets the specified element of check_commonGoals to true
	 * 
	 * @param n the index of the element to be set to true
	 */
	public void setCheckCommonGoals(int n) //set check_commongoals[0] or check_commongoals[1] to true
	{
		this.check_commonGoals[n]=true;
	}
	
	/**
	 * Returns the specified element of check_commonGoals
	 * 
	 * @param n the index of the element to be returned
	 * @return the specified element of check_commonGoals
	 */
	public boolean getCheckCommonGoals(int n)
	{
		return this.check_commonGoals[n];
	}

	/**
	 * Returns the id of the player
	 * 
	 * @return the id of the player
	 */
	public int getId() 
	{
		return id;
	}

}