package View;


import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Map 
{
	protected int posX;//weight
	protected int posY;//height
	protected int posXS;
	protected int posYS;
	protected int ligV;
	protected int colV;
	protected int ligR;
	protected int colR;
	protected int ligB;
	protected int colB;
	private Image floor, wall,rock,nothing,diamond,pho,finish;
	public char[][] tab;
	String      ligne;
	private Scanner     sc;
	private int         nbLig, nbCol;

	public int 	    numNiv;
	
	protected Scanner m;
	protected String Map[] = new String[29];
	

	
	
	public Map() 
	{
		
		
		 
		nbLig = nbCol = 0;
	
ImageIcon img = new ImageIcon("bloc de terre.jpg");
		floor = img.getImage();
		img = new ImageIcon("mur.jpg");
		wall = img.getImage();
		img = new ImageIcon("pierre 1.jpg");
		rock = img.getImage();
		img = new ImageIcon("download.jpg");
		nothing = img.getImage();
		img = new ImageIcon("diamant 1.1.jpg");
		diamond = img.getImage();
		img = new ImageIcon("phoque.jpg");
        pho = img.getImage();
        img = new ImageIcon("finish1.jpg");
        finish = img.getImage();
        
		openFile();
		readFile();
		closeFile();
		PutFile();
	}
	
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
	public char getMap(int x , int y)
	{
		char index = tab[x][y] ;
		return index;
	}
	
	
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
					if( tab[cptLig][cptCol] == '0' )
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


				}

			}
		}
		catch(Exception e){ e.printStackTrace(); }
	}
	
	public void closeFile() 
	{
		sc.close();
	}
	 public void PutFile()
	 {
	 		for( int lig=0; lig<tab.length; lig++)
	{
		for( int col=0; col<tab[lig].length; col++)
			System.out.print ( tab[lig][col] );

		System.out.println();
	}
	 }
	
}
