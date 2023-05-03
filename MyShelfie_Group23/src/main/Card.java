package main;

public class Card {
	
	private final String color;
	
	private int id;
	
	boolean used;
	
	public Card(String color, int id) {
		
		this.color = color;
		this.id=id;
		this.used = false;
		
	}
	
	public void output() 
	{
		
	}
	
	public String getColor() 
	{
		return this.color;
	}
	
	public int getID() {
		return this.id;
	}
	
	public boolean getUsed() 
	{
		return this.used;
	}
	
	public void setUsed() {
		
		if(this.used == false) {
			
			this.used = true;
		
		}
	}

}
