package main;

public class Card {
	
	private final String color;
	
	private int id;
	
	boolean used;
	
	public Card(int id,String color) {
		
		this id = id;
		this.color = color;
		used = false;
		
	}
	
	public boolean getImage() {
		
		boolean img = false;
		
		return img;
		
	}
	
	public String getColor() {
		return this.color;
	}
	
	public int getID() {
		return this.id;
	}
	
	public boolean getUsed() {
		return this.used;
	}
	
	public boolean setUsed() {
		
		if(this.used == false) {
			
			this.used = true;
		
		}
		
		return this.used;
		
	}

}
