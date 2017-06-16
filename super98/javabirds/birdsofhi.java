
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;
import java.awt.Choice;
import java.awt.Event;
import java.awt.Image;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.util.Random;
import java.awt.image.ImageFilter;

// ***************************************************
// ***************** BIRDS OF HAWAII **********************
// ***************************************************

// CREATED BY THE SEABURY COMPUTER CHALLENGE '98 CLASS.
// LAST MODIFIED:  3/15/98
// AUTHORS: Brandon McPhail, Nikki Probst, MeiLi Coon,  Remy Holwick and  Lawrence Kao under
//			close guidance of computer teacher Roberta Hodara
//			all drawings of birds are original artwork by above named students


public class birdsofhi extends java.applet.Applet
{
	private Choice choiceButton;  			
	Choice myChoice = new Choice();
	// choice box for Hawaiian letters
	int		limit = 10,
	randomNum,
	key,
	rightletterCount,
	wrongletterCount;
	String 	arrayofWords[] 	= new String[limit];
	String 	wordtoGuess,
	letterentered;
	char 	letterch;
	boolean 	alreadyGuessed,
	letterFound,
	allChosen,
	win,
	lose,
	indexofLetters[] = new boolean [limit],
	chosen[] = new boolean [limit],
	stopped = false;
	private ImageFilter cropFilter;
	Font 	f3 = new Font("Courier",Font.PLAIN,10),
	f = new Font("TimesRoman",Font.BOLD,12),
	f4 = new Font("TimesRoman",Font.BOLD,14),
	f2 = new Font("TimesRoman",Font.BOLD,18);
	private 	Image originalImage,
	topleft,
	topcenter,
	topright,
	midleft,
	midcenter,
	midright,
	botleft,
	botcenter,
	botright;
	
	/*public void init()
	// precondition: 	applet starts
	// postcondition:	letters added to choice box
	//				random word picked      
	{
		allChosen = true;
		
		for (int i=0;i< limit;i++)
		if (chosen[i] == false)
		allChosen = false;
		
		if (allChosen)
		for (int i=0;i<6;i++)
			{// number of acceptable errors is exceeded
			lose = true;
			// game over. lose.
		}
	
	}*/
	
	public void update ( Graphics g)
	// overrides repaint command to update the screen 
	// without completely repainting
	{
		paint(g);
	}
	
	public boolean action(Event event, Object o) 
	// precondition:	there is an event from the user.  
	// 				(choice box item is selected)
	// poscondition:	event is process, letter selection is processed,
	//				program checks to see if the game is over
	//				and the screen is repainted (using update())
	{
		if (!(event.target instanceof Choice))
		return false;
		
		if ((event.target instanceof Choice) && (!win ) && (!lose))
		{
			alreadyGuessed = false;
			letterFound=false;
			letterentered=choiceButton.getSelectedItem();   
			letterch = letterentered.charAt(0);
			repaint();
			
			return true;
		}
		
		return false;
	}
	
	public void paint(Graphics g) 
	// precondition: 	the screen is called to be repainted. 
	//				update is used to override repaint
	// postcondition:	tile is added or clue is added. word is 
	//				updated to paint over dashes
	{
		g.setFont(f3);
		g.setColor(Color.blue);
		g.drawString("Guess the name of the Hawaiian bird.",15,10);
		g.drawString("Choose a letter from the popup list:",15,25);
		g.setFont(f2);
		
		/*for (int z = 0;z<(wordtoGuess.length());z++)
		{
			if (wrongletterCount == 1)// give a hint  
			switch  (randomNum)
			{
				case 0:
					// nene
					g.drawString("It has adapted to living 4,000 ft.",2,60);
					g.drawString(" above sea level.",2,80);
					break;
				case 1:
					// apapane
					g.drawString("Abundant in native 'ohi'a forest.",2,60);
					break;
				case 2:
					// ala
					g.drawString("Male is green-yellow above, yellow below.",2,60);
					break;
				case 3:
					// akikiki
					g.drawString("It is found in Kaua'i only.",2,60); 
					break;
				case 4:
					// pueo
					g.drawString("This bird is found on all islands.",2,60);
					break;
				case 5:
					// iiwi
					g.drawString("This bird has an amazing sickle-shaped bill.",2,60); 
					break;
				case 6:
					// akohekohe
					g.drawString("It is only found on east Maui.",2,60);
					break;
				case 7:
					// amakihi
					g.drawString("There are four distinct subspecies.",2,60);
					break; 
				case 8:
					// alala
					g.drawString("At one time, only 12 birds were left in",2,60);
					g.drawString("the wild.",2,80);
					break;
				case 9:
					// aeo
					g.drawString("This endemic race occurs on all islands.",2,60);
					break;
			}
			// end switch (randomNum)
			
			g.setColor(Color.blue);
			
			if (wrongletterCount == 2) 
			{
				switch  ((int)randomNum)
				{
					case 0:
						g.drawString("It is found on Haleakala, Maui.",2,100);
						//nene hint
						break;
					case 1:
						g.drawString("Ten songs have been recorded.",2,100);
						//'apapane hint
						break;
					case 2:
						g.drawString("It is found in O'ahu only.",2,100);
						//ala hint
						break;
					case 3:
						g.drawString("Their nest is built in foliage and is",2,100);
						g.drawString("composed largely of mosses and rootlets.",2,120);
						//'akikiki hint
						break;
					case 4:
						g.drawString("This bird is a day flying short-eared owl.",2,100);
						//pueo hint
						break;
					case 5:
						g.drawString("This bird is found in Kaua'i, Maui, and Hawaii.",2,100);
						// iiwi
						break;	
					case 6:
						g.drawString("Formerly found on Moloka'i,",2,100);
						g.drawString("now presumed extinct.",2,120);
						// akohohe
						break;
					case 7:
						g.drawString("It is common in native forest above 2000'.",2,100);
						// amakihi
						break;
					case 8:
						g.drawString("Lives on the island of Hawaii only.",2,100);
						// alala
						break;
					case 9:
						g.drawString("Found in groups or singly in ponds,",2,100);
						g.drawString("marshy areas, and mudflats.",2,120);
						// aeo
						break;
				}
				// end switch
			}
			// end if wrongletterCount == 2
			
			g.setColor(Color.red);
			
			if (wrongletterCount==3)
			{
				if  (randomNum==0)
				g.drawString("It lost the webbing on it's feet.",2,140);
				//nene hint
				else if  (randomNum==1)
				g.drawString("Try the okina.",2,140);
				//'apapane hint
				else if  (randomNum==2)
				g.drawString("They travel in family groups.",2,140);
				//ala hint
				else if  (randomNum==3)
				g.drawString("It is gray-brown above,cream color below.",2,140);
				//akikiki hint
				else if  (randomNum==4)
				g.drawString("This bird soars like a hawk.",2,140);
				// pueo
				else if  (randomNum==5)
				g.drawString("Try the okina.",2,140);
				// iiwi
				else if (randomNum==6) 
				{
					g.drawString("Feeds primarily on nectar from",2,140);
					g.drawString(" 'ohi'a blossoms.",2,160);
					// akohekohe
				}
				else if (randomNum==7)
				g.drawString("It has a slightly decurved, grayish bill.",2,140);
				// amakihi
				else if (randomNum == 8)	
				{
					g.drawString("Birds are being captive bred in Olinda",2,140);
					g.drawString("on Maui for reintroduction.",2,160);
					// alala
				}
				else if (randomNum == 9) 
				{
					g.drawString("They feed on fish, crabs, worms,",2,140);
					g.drawString("and aquatic insects.",2,160);
					// aeo
				}
			}
			// end if wrongletterCount==3
			
			g.setColor(Color.blue);
			
			if (wrongletterCount==4)// 4th wrong letter give a hint
			{
				if  (randomNum==0)
				g.drawString("The mongoose preys on eggs and young.",2,180);
				//nene hint
				else  if  (randomNum==1)
				g.drawString("Nests were found in lava tubes on Mauna Loa.",2,180);
				//'apapane hint
				else if  (randomNum==2)
				g.drawString("They eat insects on koa branches.",2,180);
				//ala hint
				else  if  (randomNum==3)
				g.drawString("It has a dark mask through it's eyes.",2,180);
				//akikiki hint
				else  if  (randomNum==4) 
				{
					g.drawString("This bird was originally worshiped",2,180);
					g.drawString("as gods by ancient Hawaiians.",2,200);
					// pueo
				}
				else if (randomNum==5) 
				{
					g.drawString("This bird is a type of",2,180);
					g.drawString("Hawaiian honey-creeper.",2,200);
					// iiwi
				}
				
				else if (randomNum==6) 
				{
					g.drawString("It is also known as the Crested",2,180);
					g.drawString(" Honeycreeper.",2,200);
					// akohekohe
				}
				else if (randomNum==7)
				g.drawString("It feeds creeper-like on bark insects.",2,180);
				// amakihi
				else if (randomNum == 8)
				g.drawString("The largest of Hawaii's forest birds.",2,180);
				// alala
				else if (randomNum == 9) 
				{
					g.drawString("Listed as an endangered species",2,180);
					g.drawString("in the state of Hawaii",2,200);
					// aeo
				}
			}
			// end wrongletterCount == 4
			
			g.setColor(Color.red);
			
			if (wrongletterCount==5)
			{
				if  (randomNum==0)
				g.drawString("It is the state bird of Hawaii.",2,220);
				//nene hint
				else if  (randomNum==1)
				{
					g.drawString("It's feathers were used in Hawaiian ",2,220);
					g.drawString("featherwork.",2,240);
				}
				//'apapane hint 
				else if  (randomNum==2) 
				{
					g.drawString("Female is drab green above, pale below, with" ,2,220);
					g.drawString("whitish throat, superciliary, and forehead.",2,240);
					// alauahio
				}
				else if  (randomNum==3)
				g.drawString("It's legs are pinkish.",2,220);
				// akikiki
				else if  (randomNum==4) 
				{
					g.drawString("The color of this bird is ",2,220);
					g.drawString("tawny ocraceus to buffy white.",2,240);
					// pueo
				}
				else if  (randomNum==5) 
				{
					g.drawString("This bird is one of the most ",2,220);
					g.drawString("beautiful of Hawaiian native birds.",2,240);
					// iiwi
				}
				else if (randomNum==6) 
				{
					g.drawString("Aggressive, it often dominates other",2,220);
					g.drawString(" species.",2,240);
					// akohekohe
				}
				else if (randomNum==7) 
				{
					g.drawString("Yellowish green, darker above.",2,220);
				}
				// amakihi
				else if (randomNum == 8)
				g.drawString("Vocalizations include: 'cawk' and 'ca-wak.'",2,220);
				// alala
				else if (randomNum == 9) 
				{
					g.drawString("Colonies are found at Kanaha and Keali'a",2,220);
					g.drawString("ponds, Pearl Harbor, and Kuhuku wetlands.",2,240);
					// aeo
				}
			}
			// end wrongletterCount == 5
			
			g.setColor(Color.blue);
			
			if (wrongletterCount==6)
			{
				if  (randomNum==0)
				g.drawString("Their breeding season is from Nov. to June.",2,260);
				//nene hint
				else if  (randomNum==1)         
				g.drawString("It's wings make a whirring noise in flight.",2,260);
				
				//'apapane hint
				else if  (randomNum==2)
				g.drawString("It has a short tail.",2,260);
				//ala hint	
				else if (randomNum==3)		
				g.drawString("Try the okina.",2,260);
				// akikiki
				else if (randomNum==4)		
				g.drawString("This bird eats mice.",2,260);
				// pueo
				
				else  if  (randomNum==5)
				g.drawString("This bird feeds mostly on caterpillars.",2,260);
				// iiwi
				
				else if (randomNum==6)
				
				g.drawString("It is found in elevations from 4500-6500'.",2,260);
				// akohekohe
				else if (randomNum==7) 
				g.drawString("It's breeding season begins in winter.",2,260);
				// amakihi
				else if (randomNum == 8) 
				g.drawString("It is also known as Hawaiian Crow.",2,260);
				// alala
				else if (randomNum == 9) 
				g.drawString("They let their legs trail behind in flight.",2,260);
				// aeo
				
			}
			// end wrongletterCount == 6
		}
		if (rightletterCount>0)//draw top left
		g.drawImage(topleft,280,70,this);
		
		if (rightletterCount>1)//draw top middle
		g.drawImage(topcenter,380,70,this);
		
		if (rightletterCount>2)//draw top right
		g.drawImage(topright,480,70,this);
		
		if (rightletterCount>3)//draw middle left
		g.drawImage(midleft,280,170,this);
		
		if (rightletterCount>4)//draw top left
		g.drawImage(midcenter,380,170,this);
		
		if (rightletterCount>5)//draw top middle
		g.drawImage(midright,480,170,this);
		
		if (rightletterCount>6)//draw top right
		g.drawImage(botleft,280,270,this);
		
		if (rightletterCount>7)//draw middle left
		g.drawImage(botcenter,380,270,this);
		
		if (rightletterCount>8)//draw middle left
		g.drawImage(botright,480,270,this);
		
		g.setFont(f2);
		g.setColor(Color.red);
		
		// end game messages
		if (lose)      
		g.drawString("Times up, it's the ",330,20);
		
		if (win)
		g.drawString("Yes, it's the ",330,20);*/
		}
		}
		
		