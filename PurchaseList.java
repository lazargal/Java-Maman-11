package maman11;

import java.util.ArrayList;

/*
 * This class acts as a purchased item list manager. the class represent a shopper single purchase in the cashier
 */
public class PurchaseList {
	
	private ArrayList<PurchaseItem> m_purechaseList = new ArrayList<PurchaseItem>();
	
	
	// add a single purchase item to the purchase list. the function returns true if the purchase list was updated 
	public boolean addPurchaseItem( PurchaseItem purchaseItemToAdd)
	{
		return m_purechaseList.add(purchaseItemToAdd);
	}
	
	// returns the number of purchased items in the list
	public int getPurchasedListCount()
	{
		return m_purechaseList.size();
	}
	
	// returns the current sum of the purchased item list
	public float getPurchasedListSum()
	{
		float fTempSum = 0;
		for(int i = 0 ; i < m_purechaseList.size() ; i++)
		{
			fTempSum += m_purechaseList.get(i).getPurchasItemCost();
		}
		return fTempSum;		
	}
	
	// clear the current purchase list
	public void clearPurchaseList()
	{
		m_purechaseList.clear();
	}
	
	// returns an array containing all the purchased item in the list
	public PurchaseItem[] getPurchaseListAsArray()
	{
		return m_purechaseList.toArray(new PurchaseItem[0]);
	}
	
	public String toString()
	{
		StringBuilder strTempBuilder = new StringBuilder();
		for(int i = 0 ; i < m_purechaseList.size() ; i++)
		{
			strTempBuilder.append( m_purechaseList.get(i).toString() + "\n");
		}
		return strTempBuilder.toString();		
	}
	
}
