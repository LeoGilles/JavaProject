package View;



import java.awt.*;

import javax.swing.*;

public class Player 
{
	/**
	 * Attributes initialization
	 */
	private int tileX, tileY;
	private Image player;
	private Image player2;
	private Image player3;
	private Image player4;
	private Image player5;
	private Image player6;
	/**
	 * Player's Constructor with his coordinates and sprites
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
	 * Function to select the appropriate sprite with each of the player's move
	 * @param vr
	 * @return
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
	 * function to get the x position
	 * @return
	 */
	public int getTileX() 
	{
		return tileX;
	}
	/**
	 * function to get the y position
	 * @return
	 */
	public int getTileY() 
	{
		return tileY;
	}
	/**
	 * function to move the player position
	 * @param dx
	 * @param dy
	 */
	public void move(int dx, int dy) 
	{
		tileX += dx;
		tileY += dy;
	}
	
}
