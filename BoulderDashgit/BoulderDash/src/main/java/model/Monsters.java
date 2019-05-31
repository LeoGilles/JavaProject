package model;

import View.Map;

public class Monsters 
{	
	
	Map m = new Map();
	
	protected int position = 1;
	
	public int getposition()
	{
		return position;
	}
	public void setPosition(int x)
	{
		position = x ;
	}
	public void IA (int x,int y)
	{                                          // mettre Ia en variable dans board
		if (position == 1)
		{
			IA1(x,y);
		}
		else if (position == 2)
		{
			IA2(x,y);
		}
		else if (position == 3)
		{
			IA3(x,y);
		}
		else if (position == 4)
		{
			IA4(x,y);
		}
		else {
			IA1(x,y);
		}	
	}
	public void IA1(int x,int y)            //tout ca dans le for de board
	{
		if(m.tab[x+1][y] == '0')
		{
			m.tab[x+1][y] = '5';
			setPosition(1);
			m.tab[x][y] = '0';
		}
		else if (m.tab[x+1][y] == '2')
		{System.out.println("rochre");
			if (m.tab[x][y-1] == '0')
			{
				m.tab[x][y-1] = '5';
				setPosition(1);
				m.tab[x][y] = '0';
			}
			setPosition(2);
			IA(x,y);
		}
		else {
			setPosition(2);
		}
	}
	
	public void IA2(int x,int y)
	{
		if(m.tab[x][y-1] == '0')
		{
			m.tab[x][y-1] = '5';
			setPosition(2);
			m.tab[x][y] = '0';
		}
		else if (m.tab[x][y-1] == '2')
		{
			if (m.tab[x-1][y] == '0')
			{
				m.tab[x-1][y] = '5';
				setPosition(2);
				m.tab[x][y] = '0';
			}
			setPosition(3);
		}
		else {
			setPosition(3);
		}
	}
	public void IA3(int x,int y)
	{
		if(m.tab[x-1][y] == '0')
		{
			m.tab[x-1][y] = '5';
			setPosition(3);
		}
		else if (m.tab[x-1][y] == '2')
		{
			if (m.tab[x][y+1] == '0')
			{
				m.tab[x][y+1] = '5';
				setPosition(3);
				m.tab[x][y] = '0';
			}
			setPosition(4);
		}
		else {
			setPosition(4);
		}
	}
	public void IA4(int x,int y)
	{
		if(m.tab[x][y+1] == '0')
		{
			m.tab[x][y+1] = '5';
			setPosition(4);
		}
		else if (m.tab[x][y+1] == '2')
		{
			if (m.tab[x+1][y] == '0')
			{
				m.tab[x+1][y] = '5';
				setPosition(4);
				m.tab[x][y] = '0';
			}
			setPosition(1);
		}
		else {
			setPosition(1);
		}
	}
}