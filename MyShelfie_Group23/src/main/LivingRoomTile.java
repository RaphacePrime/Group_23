package main;

public class LivingRoomTile {
	
	private Card card;
	
	private boolean legalTile;
	
	public LivingRoomTile () 
	{
		
	}

	public LivingRoomTile (boolean legalTile) 
	{
		this.legalTile = legalTile;
	}
	
	public boolean isLegalTile() 
	{
		return legalTile;
	}

	public void setLegalTile(boolean legalTile) 
	{
		this.legalTile = legalTile;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

}
