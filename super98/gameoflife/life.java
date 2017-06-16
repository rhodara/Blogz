import java.awt.Graphics;
import java.applet.Applet;
import java.awt.*;
//written by Seabury Hall graphics class of 1998
public class life extends Applet 
{	private Choice choiceButton;  			
	Choice myChoice = new Choice();
	int arraySize = 10;
	int genlimit = 20;
	int genrow;
	int life[] [] = new int[arraySize] [arraySize];
	int originalGen[] [] = new int[arraySize] [arraySize];
	int nextGen [] [] = new int [arraySize] [arraySize];
	int generations [] = new int[genlimit];
	boolean first = true,colors = false;
	TextField input;
	Label inLabel;
	int xorigin=0,yorigin=100;
	int numberofGens=0;
	int lifeNum=3;
	Font	f = new Font("TimesRoman",Font.BOLD,12),
	f2 = new Font("TimesRoman",Font.PLAIN,10),
	f3 = new Font("TimesRoman",Font.PLAIN,12);
	public void init()
	{
		input = new TextField(3);
		inLabel = new Label("<--- Change number for life.");
		int row,col;
		for(row=0;row<arraySize;row++) 
		{
			for(col=0;col<arraySize;col++) 
			{
				life [row] [col] = (int)(2.0 * Math.random());
				nextGen[row] [col]=0;
				originalGen[row] [col] = life [row] [col];
			}
		}
	for(genrow=0;genrow<genlimit;genrow++) 
		generations [genrow] = 0;
		choiceButton = new Choice();
		choiceButton.addItem("3");
		choiceButton.addItem("2");
		choiceButton.addItem("4");
		choiceButton.addItem("5");
		choiceButton.addItem("6");
		add(choiceButton);
		add(inLabel);		
		first = true;
	}
	public void rules(int row2,int col2,int total)
	{
		if ((total < lifeNum-1) || (total > lifeNum))
		nextGen [row2] [col2] = 0;
		else
		if (total == lifeNum)
		nextGen [row2] [col2] = 1;
		else
		if (total == lifeNum-1)
		nextGen [row2] [col2] = life [row2] [col2] ;	
	}	
	public int sumNeighbors (int roworg,int colorg)
	{
		int total=0;
		int rowstart=0;
		//  if row is 0th row - special case, changes if roworg>0
		int colstart=0;
		//if col is 0th col - special case, changes below when colorg>0
		int rowend = roworg +1;	
		int colend = colorg +1 ;
		
		if (roworg > 0)   //  if row is 0th row - special case, changes if roworg>0
		rowstart=roworg-1;
		
		if (colorg >0)     //if col is 0th col - special case, changes below when colorg>0
		colstart=colorg-1;
		if (roworg == arraySize-1)  //if org at last row - special case
		rowend = roworg;
		if (colorg ==arraySize-1)  //if org at last column - special case
		colend = colorg;
		for (int rows=rowstart;rows<=rowend;rows++)	
		{
			for (int cols=colstart;cols<=colend;cols++)
			{
				total=total + life[rows][cols];
			}
		}
		total = total - life[roworg][colorg];
		//subtract value - 0 or 1 - of guy in the middle
		return(total);
	}
	public void processNext ()
	{
		int col,row;
		for(row=0;row < arraySize;row++) 
		{
			for(col=0;col < arraySize;col++) 
			{
				rules(row,col,(sumNeighbors(row,col)));
			}
		}
		for(row=0;row < arraySize;row++) 
		{
			for(col=0;col < arraySize;col++) 
			{				
				life[row] [col] = nextGen[row] [col];
			}
		}
	}
	public void update( Graphics g) 
	{
		paint(g);
	} 
	public void paint(Graphics g) 
	{	int xdim = 10;
		g.setFont(f2);g.setColor( Color.black);
		//g.drawString("(from current number of "+String.valueOf(lifeNum)+")",380,20);
		g.setColor( Color.blue );	g.setFont(f);g.drawString(("THE GAME OF LIFE"),15,15);
		g.setFont(f3);g.setColor( Color.red);
		g.drawString("1. An organism is born in an empty cell that has exactly " + String.valueOf(lifeNum)+" neighbors.",10,38);
		g.drawString("2. An organism dies from loneliness if it has fewer than " + String.valueOf(lifeNum-1)+" neighbors.",10,51);
		g.drawString("3. An organism dies from overcrowding if it has more than " + String.valueOf(lifeNum)+" neighbors.",10,64);
		g.drawString("4. An organism's state remains unchanged if it has exactly " + String.valueOf(lifeNum-1)+" neighbors.",10,77);
		g.setFont(f2);
		numberofGens=20;		
			for ( int genCount=1;genCount<= numberofGens;genCount++) 
			{
				if (genCount==1)
				{
				int row, col;
				for( row=0;row<arraySize;row++) 
					{
						for(col=0;col<arraySize;col++) 

							{
							life[row] [col] = originalGen [row] [col];
							}
					} 
				} 			
				if (genCount % 5==1)
				xorigin = 0;
				else	if  (genCount % 5==2)
				xorigin = 120;
				else if  (genCount% 5 ==3)
				xorigin = 240;
				else if  (genCount% 5 ==4)
				xorigin = 360;
				else if (((int)genCount % 5)==0)
				xorigin = 480;
				if  ((genCount>=1)&&(genCount<=5))
				yorigin = 81;
				if  ((genCount>=6)&&(genCount<=10))
				yorigin = 194;
				if  ((genCount>=11)&&(genCount<=15))
				yorigin = 307;
				if  ((genCount>=16)&&(genCount<=20))
				yorigin = 421;
				g.setColor( Color.blue );
				g.drawString("Generation: "+String.valueOf(genCount) ,xorigin+10,yorigin+4);				
				int row,col;
				for( row=0;row<arraySize;row++) 
				{
					for( col=0;col<arraySize;col++) 
					{
						if (life [row] [col] == 1) 
						{
							if ((genCount%2)==0)
							g.setColor( Color.red );
							else
							g.setColor( Color.blue);
						g.fill3DRect(xorigin +(xdim* (row+1)),yorigin + (xdim* (col+1)),xdim,xdim,true);
						}
						else if (life [row] [col] == 0)
						{
							g.setColor( Color.white );
							g.fill3DRect(xorigin + (xdim * (row+1)),yorigin + (xdim * (col+1)),xdim,xdim,true);
						}
					}
				}
				processNext();
			}	
	}
	public boolean action(Event e,Object o) 
	{
		if (e.target instanceof Choice)
		{			
			String numLife=choiceButton.getSelectedItem(); 
			if ( numLife.charAt(0)=='2')
			lifeNum=2;
			else
			if ( numLife.charAt(0)=='3')
			lifeNum=3;
			else
			if ( numLife.charAt(0)=='4')
			lifeNum=4;
			else
			if ( numLife.charAt(0)=='5')
			lifeNum=5;
			else
			if ( numLife.charAt(0)=='6')
			lifeNum=6;
			first=false;
			repaint();
		}
		return true;
	}
	
}
