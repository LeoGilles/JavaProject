package model;

import java.awt.*;
import javax.swing.*;

import View.Map;

public class Monsters 
{	
	private int MoX,MoY;
	Map m = new Map();
	private Image monster1;
	protected int position = 1;
	public Monsters() 
	{
		ImageIcon img = new ImageIcon("mob 1.1.jpg");
		monster1 = img.getImage();
		
		
		MoX = 20;
		MoY = 20;
		m.tab[20][20] = '0' ;
		m.tab[21][20] = '0' ;
	}
	
	public Image getMonster()
	{
		return monster1;
	}
	public int getMonsterX() 
	{
		return MoX;
	}
	public int getposition()
	{
		return position;
	}
	public void setPosition(int x)
	{
		position = x ;
	}
	public int getMonsterY() 
	{
		return MoY;
	}
	public void movemonster(int dx,int dy)
	{
	
		MoX = MoX+ dx;
		MoY = MoY+dy;
	}
	public void IA ()
	{
		if (position == 1)
		{
			
			IA1();
		}
		else if (position == 2)
		{
			IA2();
		}
		else if (position == 3)
		{
			IA3();
		}
		else if (position == 4)
		{
			IA4();
		}
		else {
			IA1();
		}
				
	}
	public void IA1()
	{
		
		if(m.tab[getMonsterX()+1][getMonsterY()] == '0')
		{
			
			
			movemonster(1,0);
			setPosition(1);
			m.tab[getMonsterX()][getMonsterY()] = '0';
		}
		else if (m.tab[getMonsterX()+1][getMonsterY()] == '2')
		{
			if (m.tab[getMonsterX()][getMonsterY()-1] == '0')
			{
				movemonster(0,-1);
				setPosition(1);
				m.tab[getMonsterX()][getMonsterY()] = '0';
			}
		}
		else {
			setPosition(2);
			IA();
		}
	}
	
	public void IA2()
	{
		if(m.tab[getMonsterX()][getMonsterY()-1] == '0')
		{
			movemonster(0,-1);
			setPosition(2);
			m.tab[getMonsterX()][getMonsterY()] = '0';
		}
		else if (m.tab[getMonsterX()][getMonsterY()-1] == '2')
		{
			if (m.tab[getMonsterX()-1][getMonsterY()] == '0')
			{
				movemonster(-1,0);
				setPosition(2);
				m.tab[getMonsterX()][getMonsterY()] = '0';
			}
		}
		else {
			setPosition(3);
			IA();
		}
	}
	public void IA3()
	{
		if(m.tab[getMonsterX()-1][getMonsterY()] == '0')
		{
			movemonster(-1,0);
			setPosition(3);
		}
		else if (m.tab[getMonsterX()-1][getMonsterY()] == '2')
		{
			if (m.tab[getMonsterX()][getMonsterY()+1] == '0')
			{
				movemonster(0,1);
				setPosition(3);
				m.tab[getMonsterX()][getMonsterY()] = '0';
			}
		}
		else {
			setPosition(4);
			IA();
		}
	}
	public void IA4()
	{
		if(m.tab[getMonsterX()][getMonsterY()+1] == '0')
		{
			movemonster(0,1);
			setPosition(4);
		}
		else if (m.tab[getMonsterX()][getMonsterY()+1] == '2')
		{
			if (m.tab[getMonsterX()+1][getMonsterY()] == '0')
			{
				movemonster(1,0);
				setPosition(4);
				m.tab[getMonsterX()][getMonsterY()] = '0';
			}
		}
		else {
			setPosition(1);
			IA();
		}
	}
	
}