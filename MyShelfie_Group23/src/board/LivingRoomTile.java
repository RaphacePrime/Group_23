package board;

public class LivingRoomTile 
{
	
	private Card card;
	
	private final boolean legalTile;
	
	public LivingRoomTile (boolean legalTile) 
	{
		this.legalTile = legalTile;
		this.card = null;
	}
	
	public boolean isLegalTile() 
	{
		return legalTile;
	}
	
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
}
