import java.awt.*;

import java.applet.Applet;



public class Nuke extends java.applet.Applet {



	Image planetimg;

	Image nukemimg;

	int nuke,nukex,nukey;





	final int MAXSPOTS = 10;

		int xspots[] = new int[MAXSPOTS];

		int yspots[] = new int[MAXSPOTS];

		int currspots = 0;



	public void init()

	{

		setBackground(Color.black);

		planetimg = getImage(getCodeBase(), "planets/Caprica.gif");

		nukemimg = getImage(getCodeBase(),"planets/nuke.gif");

		nuke = 0;

	}



	public boolean mouseDown(Event evt,int x,int y)

	{

		if (currspots < MAXSPOTS)

			addspot(x,y);

		else

			addnuke(x,y);

		return true;

	}





	void addspot(int x,int y)

	{

		xspots[currspots] = x;

		yspots[currspots] = y;

		currspots++;

		repaint();

	}



	void addnuke(int x,int y)

	{

	 			nuke =1;

				nukex = x;

				nukey = y;



		/*for(int i=0;i<currspots;i++)

		{

			if ((   (xspots[i] - x < planetimg.getWidth(this))

				|| (x - xspots[i] < planetimg.getWidth(this)))

				&& ((y - yspots[i] < planetimg.getHeight(this))

 				|| (y - yspots[i] < planetimg.getHeight(this)) ))

			{



			}

		} */

		repaint();

	}



	public void paint(Graphics g)

	{

		int iwidth = planetimg.getWidth(this);

		int iheight = planetimg.getHeight(this);

		for(int i=0;i < currspots;i++)

		{

			g.drawImage(planetimg,xspots[i] - 10, yspots[i] - 10,this);

		}

		

		if (currspots >= MAXSPOTS)

		{

			iwidth = nukemimg.getWidth(this);

			iheight = nukemimg.getHeight(this);

			g.drawImage(nukemimg,(nukex - iwidth / 2), (nukey - iheight / 2), this);

			nuke = 0;

		}	



	}

}