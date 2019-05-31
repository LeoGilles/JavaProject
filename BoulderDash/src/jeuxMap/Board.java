package jeuxMap;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class Board extends JPanel implements ActionListener
{
	private Timer timer;
	private Map m;
	private Player p;
	
	public Board() 
	{
		m = new Map();
		p = new Player();
		addKeyListener(new Al());
		setFocusable(true);
		
		timer = new Timer(25, this);
		timer.restart();
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		repaint();
	}
	
	public void paint(Graphics g) 
	{
		super.paint(g);
		
		for(int y = 0; y < 29; y++) 
		{
			for(int x = 0; x < 29; x++) 
			{
				if(m.getMap(x, y).equals("1"))
				{
					g.drawImage(m.getGrass(), x * 16, y * 16, null);
				}
				if(m.getMap(x, y).equals("0"))
				{
					g.drawImage(m.getWall(), x * 16, y * 16, null);
				}
			}
		}
		
		g.drawImage(p.getPlayer(), p.getTileX() * 16, p.getTileY() * 16, null);
	}
	
	public class Al extends KeyAdapter
	{
		public void keyPressed(KeyEvent e) 
		{
			int keycode = e.getKeyCode();
			
			if(keycode == KeyEvent.VK_UP) 
			{
				if(!m.getMap(p.getTileX(), p.getTileY() - 1).equals("0")) 
				{
					p.move(0, -1);				
				}
			}
			
			if(keycode == KeyEvent.VK_DOWN) 
			{
				if(!m.getMap(p.getTileX(), p.getTileY() + 1).equals("0")) 
				{
					p.move(0, 1);				
				}
			}
			
			if(keycode == KeyEvent.VK_LEFT) 
			{
				if(!m.getMap(p.getTileX() - 1, p.getTileY()).equals("0")) 
				{
					p.move(-1, 0);				
				}
			}
			
			if(keycode == KeyEvent.VK_RIGHT) 
			{
				if(!m.getMap(p.getTileX() + 1, p.getTileY()).equals("0")) 
				{
					p.move(1, 0);				
				}
			}
		}
	}
}
