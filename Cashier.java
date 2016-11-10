package maman11;


public class Cashier {
	
	private float m_fCurrentSum = 0;
	private PurchaseList m_currentPurchaseList = new PurchaseList();
	
	
	public Cashier()
	{
		this(0);
	}
	
	public Cashier(float fInitValue)
	{
		if(fInitValue >= 0 )
			m_fCurrentSum = fInitValue;				
	}
	
	public float GetCurrentCashierSum()
	{
		return m_fCurrentSum;
	}
	
	public void adddNewPurchaseItem( PurchaseItem newPurchaseItem)
	{
		m_currentPurchaseList.addPurchaseItem(newPurchaseItem);
	}
	

}
