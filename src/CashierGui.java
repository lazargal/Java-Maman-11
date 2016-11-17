import java.util.Scanner;

/*
 * This class acts as the GUI for the cashier class.
 */

public class CashierGui 
{
	// user selection options 
	private final int ADD_ITEM_ID = 1;
	private final int GET_ITEMS_LIST = 2;
	private final int GET_CURRENT_PURCHASE_SUM = 3;
	private final int PERFORM_PAYMENT = 4;
	private final int GET_CAHSIER_SUM = 5;
	private final int EXIT_PROGRAM  = 6 ; // this option should always be the last
	
	private Cashier m_myCashier = new Cashier();	// the actual cashier object
	private static boolean m_bExitProgram = false;	// indication that we should leave the program
	private int m_nUserSelection = 0;				// current user selection
	private static Scanner m_myScanner;				// input scanner for user interface
			
	
	public static void main(String[] args) 
	{
		m_myScanner = new Scanner(System.in);
		CashierGui myApp = new CashierGui();
		while(! m_bExitProgram)
		{
			myApp.printMainOptionMenu();
			myApp.processUserMainMenuInput(myApp.m_nUserSelection);
		}	
		System.out.println("Program Exited");
		m_myScanner.close();
	}

	// prints a menu for the user to select an option
	private void printMainOptionMenu()
	{
		int nSelection = 0;
		System.out.println("Cahsier Main Option Menu :");
		System.out.println("	" + ADD_ITEM_ID +": Add new purchase item");
		System.out.println("	" + GET_ITEMS_LIST +": Get current purchase list of items");
		System.out.println("	" + GET_CURRENT_PURCHASE_SUM +": Get current purchase sum");
		System.out.println("	" + PERFORM_PAYMENT +": Perfom payment");
		System.out.println("	" + GET_CAHSIER_SUM +": Get current sum in the cashier");
		System.out.println("	" + EXIT_PROGRAM +": Exit the program");
		System.out.println("Please select an option");
		
		nSelection = m_myScanner.nextInt();
		m_myScanner.nextLine();
		while(nSelection < 0 || nSelection > EXIT_PROGRAM)
		{
			System.out.println("Selected input is not valid. please eneter a number from 1 to" + EXIT_PROGRAM);
			nSelection = m_myScanner.nextInt();
			m_myScanner.nextLine();
		}
		m_nUserSelection = nSelection;
		
	}
	
	
	// process the user selection from the main menu
	private void processUserMainMenuInput(int nSelection)
	{	
		switch (nSelection) 
		{
		case ADD_ITEM_ID:
			addSingleItem();
			printCurrentPurchaseList();
			break;
		case GET_ITEMS_LIST:
			printCurrentPurchaseList();
			break;
		case GET_CURRENT_PURCHASE_SUM:
			printCurrentPurchaseSum();
			break;
		case PERFORM_PAYMENT:
			printCurrentPurchaseSum();
			performPayment();
			break;
		case GET_CAHSIER_SUM:
			printCashierSum();
			break;
		case EXIT_PROGRAM:
			m_bExitProgram = true;
			break;			
		}
		
	}

	// prints the cashier sum
	private void printCashierSum() 
	{
		System.out.println("Current cahsier sum = " + m_myCashier.getCurrentCashierSum());
	}

	// perform a payment process
	private void performPayment() 
	{
		float fTemp = 0;
		PurchaseItem[] currPurchasedItemArray = m_myCashier.getPurchasedItemArray();
		
		System.out.println("Enter the amount of cash paied");
		fTemp = m_myScanner.nextFloat();
		m_myScanner.nextLine();
		fTemp = m_myCashier.performPayment(fTemp);
		System.out.println("Change for the purchase = " + fTemp);
				
		System.out.println("Purchased item :");
		for(PurchaseItem currItem : currPurchasedItemArray)
		{
			System.out.println("	" + currItem.toString());			
		}
		
	}

	// prints the current purchase sum
	private void printCurrentPurchaseSum() 
	{
		System.out.println("Current purchase sum = " + m_myCashier.getCurrentPurchaseSum());
	}

	// prints the current purchased items list  
	private void printCurrentPurchaseList() 
	{
		PurchaseItem[] currPurchasedItemArray = m_myCashier.getPurchasedItemArray();
		System.out.println("Current purchase item :");
		for(PurchaseItem currItem : currPurchasedItemArray)
		{
			System.out.println("	" + currItem.toString());			
		}		
	}

	// adds a single purchase item to the list
	private void addSingleItem() 
	{
		String strItemName = "";
		float fItemPrice = 0;
		int nAmountOfItems = 0;
		
		System.out.println("Enter the purchased item name");
		strItemName = m_myScanner.nextLine();
		
		System.out.println("Enter the purchased item price");
		fItemPrice = m_myScanner.nextFloat();
		m_myScanner.nextLine();
		
		System.out.println("Enter the amount of purchased items");
		nAmountOfItems = m_myScanner.nextInt();
		m_myScanner.nextLine();
		
		m_myCashier.addNewPurchaseItem(new PurchaseItem(strItemName , nAmountOfItems , fItemPrice));

	}
}
