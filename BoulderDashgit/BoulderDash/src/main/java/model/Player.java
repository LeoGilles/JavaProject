package model;



import java.awt.*;

import javax.swing.*;

public class Player 
{
	
	private int tileX, tileY;
	private Image player;
	private Image player2;
	private Image player3;
	private Image player4;
	private Image player5;
	
	public Player() 
	{
		ImageIcon img = new ImageIcon("persob.jpg");
		player = img.getImage();
				
		ImageIcon img1 = new ImageIcon("perso 4.jpg");
		player2 = img1.getImage();
				
		ImageIcon img2 = new ImageIcon("persog.jpg");
		player3 = img2.getImage();
				
		ImageIcon img3 = new ImageIcon("persod.jpg");
		player4 = img3.getImage();	
				
		ImageIcon img4 = new ImageIcon("perso 4.jpg");
		player5 = img4.getImage();
		
		tileX = 1;
		tileY = 1;
	}
	
	public Image getPlayer(int vr) 
	{
		if (vr== 1) {
			return player;
		}
		else if (vr == 2) {
		return player2;
	}
		else if (vr == 3) {
			return player3;
		}
		else if (vr == 4) {
			return player4;
		}
		else 
			return player5;
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
