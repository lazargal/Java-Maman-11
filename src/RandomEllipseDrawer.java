
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class RandomEllipseDrawer 
{
	
	public static void main(String[] args)
	{
		JFrame myFrame = new JFrame();
		ElipseDrawerPanel myPanel = new ElipseDrawerPanel();
		myFrame.add(myPanel);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setSize(800, 600);
		myFrame.setVisible(true);
		
		String steUserInput;
		steUserInput = JOptionPane.showInputDialog("Enter number of ellipses for each direction (X and Y)");
		int nUserInput = Integer.parseInt(steUserInput);
		if(nUserInput < 1 || nUserInput > 100)
			nUserInput = 10;
		myPanel.setNumOfEllipsesInEachDirection(nUserInput);
		
		nUserInput = JOptionPane.showConfirmDialog(null, "Cahnge ellipses colors?");
		while(nUserInput == JOptionPane.YES_OPTION)
		{
			myPanel.fillEllipseColorArray();
			nUserInput = JOptionPane.showConfirmDialog(null, "Cahnge ellipses colors?");
		}		
	}
}
