package model;

import java.awt.*;
import javax.swing.*;

public class Monsters 
{	
	private int axeX,axeY;
	@SuppressWarnings("unused")
	private Image monster1;

	public Monsters() 
	{
		ImageIcon img = new ImageIcon("mob 1.1.jpg");
		monster1 = img.getImage();
		
		axeX = 10;
		axeY = 5;
	}
	
	public int getWidht() 
	{
		return axeX;
	}
	
	public int getLarge() 
	{
		return axeY;
	}
}