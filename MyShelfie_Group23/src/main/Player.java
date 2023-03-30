package main;

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
	
	public void calculatePoints() {
		
	}
	
	public void setCommonGoals() {
		
	}
	
	public void insertInLibrary(Card c) {
		
	}

}
