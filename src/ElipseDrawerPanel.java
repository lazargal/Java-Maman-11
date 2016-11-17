

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.JPanel;

public class ElipseDrawerPanel extends JPanel 
{
	private static final long serialVersionUID = 1L;

	private enum EllipseColors{BLACK , WHITE , GRAY};	// an Enum to represent the colors available for drawing
	private EllipseColors[][] m_ellipseColorsArray;		// an array of EllipseColors to hold the data for the currently drawn ellipses colors
	private int m_nNumOfEllipses = 0;					// number of ellipses in each direction (X, and Y)
	

	// paints the ellipses on the screen
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		if(m_nNumOfEllipses <= 0)
			return;			
			
		int nWidth = getWidth();
		int nHeight = getHeight();
		int nEllipseWidth = nWidth/m_nNumOfEllipses;
		int nEllipseHeight = nHeight/m_nNumOfEllipses;
		double dWidthReminder = 1.0*nWidth/m_nNumOfEllipses - nEllipseWidth;
		double dHeightReminder = 1.0*nHeight/m_nNumOfEllipses - nEllipseHeight;
		double dWidthReminderSum = 0;
		double dHeightReminderSum = 0;
		Rectangle ellipseRect = new Rectangle(0, 0, nEllipseWidth, nEllipseHeight);
		
		for(int i = 0 ; i < m_nNumOfEllipses ; i++)
		{
			ellipseRect.y = 0;
			dHeightReminderSum = 0;
			for(int j = 0 ; j < m_nNumOfEllipses ; j++)
			{				
				switch(m_ellipseColorsArray[i][j])
				{
				case BLACK:
					g.setColor(Color.black);
					break;
				case WHITE:
					g.setColor(Color.white);
					break;
				case GRAY:
					g.setColor(Color.gray);
					break;
				default:
					g.setColor(Color.black);						
				}
				g.fillOval(ellipseRect.x, ellipseRect.y, ellipseRect.width, ellipseRect.height);
				
				ellipseRect.y += ellipseRect.height;
				dHeightReminderSum += dHeightReminder;
				if(dHeightReminderSum > 1)
				{
					ellipseRect.height = nEllipseHeight+1;
					dHeightReminderSum -= 1;
				}
				else
					ellipseRect.height = nEllipseHeight;
			}
			ellipseRect.x += ellipseRect.width;
			dWidthReminderSum += dWidthReminder;
			if(dWidthReminderSum > 1)
			{
				ellipseRect.width = nEllipseWidth+1;
				dWidthReminderSum -= 1;
			}
			else
				ellipseRect.width = nEllipseWidth;			
		}		
	}
	
	// set number of ellipses to draw in each direction X and Y
	public void setNumOfEllipsesInEachDirection(int nNewNumOfEllipses)
	{
		if(nNewNumOfEllipses > 0)
		{
			m_nNumOfEllipses = nNewNumOfEllipses;
			m_ellipseColorsArray = new EllipseColors[m_nNumOfEllipses][m_nNumOfEllipses];
			fillEllipseColorArray();
		}
	}
	
	// fills the m_ellipseColorsArray array with random EllipsesColors
	public void fillEllipseColorArray()
	{
		Random myRandomGenerator = new Random();
		int nMaxRandNum = EllipseColors.values().length;
		for(int i = 0 ; i < m_nNumOfEllipses ; i++)
		{
			for(int j = 0 ; j < m_nNumOfEllipses ; j++)
			{
				m_ellipseColorsArray[i][j] = EllipseColors.values()[myRandomGenerator.nextInt(nMaxRandNum)];
			}			
		}
		repaint();
	}

}
