package board;

public class Card {
	
	private String color;
	
	private int id;
	
	boolean used;
	
	public Card()
	{
		this.color=null;
		this.id=0;
		this.used=false;
	}
	
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

	public boolean setColor(String string) {
		this.color=string;
		return false;
	}

}
