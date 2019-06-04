/*
 * 
 */
package View;


import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Map.
 */

public class Map 
{
	
	/** Attributs initialization. */
	protected int posX;//weight
	
	/** The pos Y. */
	protected int posY;//height
	
	/** The pos XS. */
	protected int posXS;
	
	/** The pos YS. */
	protected int posYS;
	
	/** The col M. */
	protected int ligV ,colV,ligR,colR,ligB,colB,ligM,colM;
	
	/** The monster 3. */
	private Image floor, wall,rock,nothing,diamond,pho,finish,monster1,monster2,monster3; 
	
	/** The tab. */
	public char[][] tab;
	
	/** The ligne. */
	String      ligne;
	
	/** The sc. */
	private Scanner     sc;
	
	/** The nb col. */
	private int         nbLig, nbCol;

	/** The num niv. */
	public int 	    numNiv;
	
	/** The m. */
	protected Scanner m;
	
	/** The Map. */
	protected String Map[] = new String[29];
	
	int rand = 1;

	
	
	/**
	 * Instantiates a new map.
	 */
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
        monster1 = img.getImage();
        img = new ImageIcon("Mob2.jpg");
        monster2 = img.getImage();
        img = new ImageIcon("Mob3.jpg");
        monster3 = img.getImage();
		openFile();
		readFile();
		closeFile();
		
	}
	
	/**
	 * methods to return the associated Sprite.
	 *
	 * @return the floor
	 */
	public Image getFloor() 
	{
		return floor;
	}
	
	/**
	 * Gets the wall.
	 *
	 * @return the wall
	 */
	public Image getWall() 
	{
		return wall;
	}
	
	/**
	 * Gets the rock.
	 *
	 * @return the rock
	 */
	public Image getRock()
	{
		return rock;
	}
	
	/**
	 * Gets the nothing.
	 *
	 * @return the nothing
	 */
	public Image getNothing()
	{
		return nothing;
	}
	
	/**
	 * Gets the diamond.
	 *
	 * @return the diamond
	 */
	public Image getDiamond()
	{
		return diamond;
	}
	
	/**
	 * Gets the finish.
	 *
	 * @return the finish
	 */
	public Image getFinish()
    {
        return finish;
    }

    /**
     * Gets the pho.
     *
     * @return the pho
     */
    public Image getPho()
    {
        return pho;
    }
    
    /**
     * Gets the monster.
     *
     * @return the monster
     */
    public Image getmonster()
    {
    	if (rand != 0 )
    	{
    	rand = getRandomNumberInts(1,3);
    	}
    	if (rand == 1 ) {
    		return monster1;
    	}
    	if (rand == 2 ) {
    		return monster2;
    	}
    	if (rand == 3 ) {
    		return monster3;
    	}
    	else return monster1;
    		
    }
    
    /**
     * function to return the character in the table at a designated position.
     *
     * @param x the x
     * @param y the y
     * @return the map
     */
	public char getMap(int x , int y)
	{
		char index = tab[x][y] ;
		return index;
	}
	
	/**
	 * Gets the random number ints.
	 *
	 * @param min the min
	 * @param max the max
	 * @return the random number ints
	 */
	public int getRandomNumberInts(int min, int max){
	    Random random = new Random();
	    return random.ints(min,(max+1)).findFirst().getAsInt();
	}
	
	/**
	 * function to open the file and get his length/height 
	 * and then create our table with this values.
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
	 * function to Read our file a second time and put all characters into our table.
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
	 * Close file function.
	 */
	public void closeFile() 
	{
		sc.close();
	}
	
	
}
