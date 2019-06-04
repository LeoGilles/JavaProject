/*
 * 
 */
package fr.exia.BoulderDash;



import java.awt.*;

import javax.swing.*;

// TODO: Auto-generated Javadoc
/**
 * The Class Player.
 */
public class Player 
{
	
	/** Attributes initialization. */
	private int tileX, tileY;
	
	/** The player. */
	private Image player;
	
	/** The player 2. */
	private Image player2;
	
	/** The player 3. */
	private Image player3;
	
	/** The player 4. */
	private Image player4;
	
	/** The player 5. */
	private Image player5;
	
	/** The player 6. */
	private Image player6;
	
	/**
	 * Player's Constructor with his coordinates and sprites.
	 */
	public Player() 
	{
		ImageIcon img = new ImageIcon("playerup.jpg");
		player = img.getImage();
				
		ImageIcon img1 = new ImageIcon("playerdown.jpg");
		player2 = img1.getImage();
				
		ImageIcon img2 = new ImageIcon("playerleft.jpg");
		player3 = img2.getImage();
				
		ImageIcon img3 = new ImageIcon("playerright.jpg");
		player4 = img3.getImage();	
				
		ImageIcon img4 = new ImageIcon("playerdead.jpg");
		player5 = img4.getImage();
		ImageIcon img5 = new ImageIcon("playerdown.jpg");
		player6 = img5.getImage();
		
		
		
		tileX = 1;
		tileY = 1;
	}
	
	/**
	 * Function to select the appropriate sprite with each of the player's move.
	 *
	 * @param vr the vr
	 * @return the player
	 */
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
		else if (vr == 5) {
			return player5;
		}
			return player6;
		}
	
	/**
	 * function to get the x position.
	 *
	 * @return the tile X
	 */
	public int getTileX() 
	{
		return tileX;
	}
	
	/**
	 * function to get the y position.
	 *
	 * @return the tile Y
	 */
	public int getTileY() 
	{
		return tileY;
	}
	
	/**
	 * function to move the player position.
	 *
	 * @param dx the dx
	 * @param dy the dy
	 */
	public void move(int dx, int dy) 
	{
		tileX += dx;
		tileY += dy;
	}
	
}
