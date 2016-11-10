package maman11;

/*
 * This class represent a single purchase item that a shopper may buy.
 * The purchase item is composed of the item name, amount of items purchased and a single item price.
 * the class calculates and returns the total cost for the purchased item in the getPurchasItemCost() function.
 */
public class PurchaseItem {
	
	private String m_strItemName = "";		// the current item name
	private int m_nItemAmount = 0;			// the current item amount
	private float m_fSingleItemPrice = 0;	// a single item price
	
	public PurchaseItem()
	{
		
	}
	
	public PurchaseItem( String strItemName , int nAmount , float fSingleItemPrice)
	{
		setItemName(strItemName);
		setItemAmount(nAmount);
		setSingleItemPrice(fSingleItemPrice);		
	}
	
	public void setItemName(String strItemName)
	{
		strItemName.trim();
		if(strItemName.isEmpty())
			m_strItemName = "No Item Name";
		else
			m_strItemName = strItemName;
	}
	
	public String getItemName()
	{
		return m_strItemName;
	}
	
	public void setItemAmount( int nAmount)
	{
		if(nAmount >= 1)
			m_nItemAmount = nAmount;
	}
	
	public int getItemAmount()
	{
		return m_nItemAmount;
	}
	
	public void setSingleItemPrice(float fItemPrice)
	{
		m_fSingleItemPrice = fItemPrice;
	}
	
	public float getSingleItemPrice()
	{
		return m_fSingleItemPrice;
	}
	
	
	// calculates and returns the total cost for the current purchased item
	public float getPurchasItemCost()
	{
		return m_fSingleItemPrice*m_nItemAmount;		
	}
	
	public String toString()
	{
		return "Purchas Item: " + m_strItemName + " " + m_nItemAmount + " X " + m_fSingleItemPrice + " = " +getPurchasItemCost();
	}

}
