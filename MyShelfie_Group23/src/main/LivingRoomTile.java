package main;

public class LivingRoomTile 
{
	
	private Card card;
	
	private boolean legalTile;
	
//	private boolean occupied;
	
	public LivingRoomTile () 
	{
		
	}

	public LivingRoomTile (boolean legalTile) 
	{
		this.legalTile = legalTile;
		this.card = null;
	}
	
	public boolean isLegalTile() 
	{
		return legalTile;
	}

	public void setLegalTile(boolean legalTile) 
	{
		this.legalTile = legalTile;
	}

/*	public boolean isOccupied()
*	{
*		return occupied;
*	}
*/
	
	public boolean isOccupied()
	{
		if (!this.isLegalTile())
		{
			return false;
		}
		else if (this.card != null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public Card getCard()
	{
		return card;
	}

	public void setCard(Card card)
	{
		this.card = card;
	}
	
	public String getColor()
	{
		return this.card.getColor();
	}
	
/*	public void removeCard()
*	{
*		this.card = null;
*	}
*/
}
