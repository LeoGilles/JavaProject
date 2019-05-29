package jeuxMap;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Map 
{
	
	private Scanner m;
	private String Map[] = new String[29];
	private Image grass, wall;
	
	public Map() 
	{
		
		ImageIcon img = new ImageIcon("bloc de terre.jpg");
		grass = img.getImage();
		img = new ImageIcon("mur.jpg");
		wall = img.getImage();
		
		openFile();
		readFile();
		closeFile();
	}
	
	public Image getGrass() 
	{
		return grass;
	}
	
	public Image getWall() 
	{
		return wall;
	}
	
	public String getMap(int x, int y) 
	{
		String index = Map[y].substring(x, x + 1);
		return index;
	}
	
	public void openFile()
	{
		try 
		{
			m = new Scanner(new File("Map.txt"));
		} catch(Exception e) 
		{
			System.out.println("error loading map");
		}
	}
	
	public void readFile() 
	{
		while(m.hasNext()) 
		{
			for(int i = 0; i < 29; i++) 
			{
				Map[i] = m.next();
			}
		}
	}
	
	public void closeFile() 
	{
		m.close();
	}
}
