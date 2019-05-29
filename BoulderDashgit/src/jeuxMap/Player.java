package jeuxMap;

import java.awt.*;

import javax.swing.*;

public class Player 
{
	
	private int tileX, tileY;
	private Image player;
	
	public Player() 
	{
		ImageIcon img = new ImageIcon("mamouth.png");
		player = img.getImage();
		
		//Départ du personnage
		tileX = 1;
		tileY = 1;
	}
	
	public Image getPlayer() 
	{
		return player;
	}

	public int getTileX() 
	{
		return tileX;
	}
	
	public int getTileY() 
	{
		return tileY;
	}
	
	public void move(int dx, int dy) 
	{
		tileX += dx;
		tileY += dy;
	}
}
