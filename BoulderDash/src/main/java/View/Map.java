package View;


import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Map 
{
	/**
	 * Attributs initialization
	 */
	protected int posX;//weight
	protected int posY;//height
	protected int posXS;
	protected int posYS;
	protected int ligV ,colV,ligR,colR,ligB,colB,ligM,colM;
	private Image floor, wall,rock,nothing,diamond,pho,finish,monster; 
	public char[][] tab;
	String      ligne;
	private Scanner     sc;
	private int         nbLig, nbCol;

	public int 	    numNiv;
	
	protected Scanner m;
	protected String Map[] = new String[29];
	

	
	
	public Map() 
	{
		
		/**
		 * Images initialization 
		 * and call function to open the file with the map,read the file and close the file
		 */
		 
		nbLig = nbCol = 0;
	
ImageIcon img = new ImageIcon("DirtBlock.jpg");
		floor = img.getImage();
		img = new ImageIcon("Wall.jpg");
		wall = img.getImage();
		img = new ImageIcon("Rock1.jpg");
		rock = img.getImage();
		img = new ImageIcon("download.jpg");
		nothing = img.getImage();
		img = new ImageIcon("Diamons1.jpg");
		diamond = img.getImage();
		img = new ImageIcon("endSprite.jpg");
        pho = img.getImage();
        img = new ImageIcon("finish1.jpg");
        finish = img.getImage();
        img = new ImageIcon("Mob.jpg");
        monster = img.getImage();
        
		openFile();
		readFile();
		closeFile();
		
	}
	/**
	 * methods to return the associated Sprite
	 * @return
	 */
	public Image getFloor() 
	{
		return floor;
	}
	
	public Image getWall() 
	{
		return wall;
	}
	public Image getRock()
	{
		return rock;
	}
	public Image getNothing()
	{
		return nothing;
	}
	public Image getDiamond()
	{
		return diamond;
	}
	public Image getFinish()
    {
        return finish;
    }

    public Image getPho()
    {
        return pho;
    }
    public Image getmonster()
    {
    	return monster;
    }
    /**
     * function to return the character in the table at a designated position
     * @param x
     * @param y
     * @return
     */
	public char getMap(int x , int y)
	{
		char index = tab[x][y] ;
		return index;
	}
	
	/**
	 * function to open the file and get his length/height 
	 * and then create our table with this values
	 */
	public void openFile()
	{
		try
		{
			sc = new Scanner ( new FileReader ( "Map.txt" ) ); 

			nbCol = sc.nextLine().length();
			nbLig = 1;
			while ( sc.hasNextLine() )
			{
				sc.nextLine();
				nbLig++;
			}
		}
		catch(Exception e){	e.printStackTrace(); }
		tab = new char[nbLig][nbCol];
	
	}
	/**
	 * function to Read our file a second time and put all characters into our table 
	 */
	public void readFile() 
	{
		try
		{
			sc = new Scanner     ( new FileReader ( "Map.txt" ) );

			for(int cptLig=0; cptLig< nbLig; cptLig++)
			{
				ligne = sc.nextLine();

				for (int cptCol=0; cptCol<nbCol; cptCol++)
				{
					tab[cptLig][cptCol] = ligne.charAt(cptCol);
					if( tab[cptLig][cptCol] == '0' )    /**for each caracters we select a variable and put it in the table    */
					{
						this.posY = cptLig;
						this.posX = cptCol;
					}
					if( tab[cptLig][cptCol] == '1')
					{
						posXS = cptLig;
						posYS = cptCol;
					}
					if( tab[cptLig][cptCol] == '2')
					{
						this.ligV	 = cptLig;
						this.colV = cptCol;
					}
					if( tab[cptLig][cptCol] == '3')
					{
						this.ligB = cptLig;
						this.colB = cptCol;
					}
					if( tab[cptLig][cptCol] == '4')
					{
						this.ligR = cptLig;
						this.colR = cptCol;
					}
					if( tab[cptLig][cptCol] == '5')
					{
						this.ligM = cptLig;
						this.colM = cptCol;
					}

				}

			}
		}
		catch(Exception e){ e.printStackTrace(); }
	}
	/**
	 * Close file function
	 */
	public void closeFile() 
	{
		sc.close();
	}
	
	
}
