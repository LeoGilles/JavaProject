package controller ;


import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import View.Map;
import model.Monsters;
import model.Player;
import model.Rock;

public class Board extends JPanel implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Timer timer;
	private Map m;
	private Player p;
	private Monsters mon;
	private int pt = 0;
	  ;
	BufferedImage img ;
	public static int  Ps = 0 ;
	private Rock r;
	public Board() 
	{
		m = new Map();
		p = new Player();
		r = new Rock();
		mon = new Monsters();
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
		try {
			img = ImageIO.read(new File("download.png"));
			g.drawImage(img,0,0,this.getWidth(),this.getHeight(),this);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for(int y = 0; y < 29; y++) 
		{
			for(int x = 0; x < 29; x++) 
			{
				
				if ( !(r.axeXY[x][y] == 2 ))
                    r.setFloorXY(x, y);
				
 
                if(m.getMap(x, y)== '2' )
                {
                    g.drawImage(m.getNothing(),r.getRockX(x) * 16,r.getRockY(y) * 16,null);


                }
                	  
                if (r.verif(x, y) == 0) {

                    g.drawImage(m.getFloor(), r.getRockX(x) * 16, r.getRockY(y) * 16, null);
                }
                
                if(m.getMap(x,y)== '4'  )
				{
                	g.drawImage(m.getDiamond(), x * 16, y * 16, null);
					if (r.axeXY[x][y] == 0)
						{
						r.setDiamonsXY(x, y);
						}
             
					
				}

                if(m.getMap(x, y)== '1')
                {
                    r.setWallXY(x, y);
                    g.drawImage(m.getWall(), x * 16, y * 16, null);
                }
                if(m.getMap(x,  y)== '3' )
                {
                  
                	r.setRockXY(x,y);
                    g.drawImage(m.getRock(), r.getRockX(x) * 16, r.getRockY(y) * 16, null);

                }
                
         
               
			
			}
			
		}
		
		g.clearRect(p.getTileX() * 16,p.getTileY() * 16,0,0);
		g.drawImage(p.getPlayer(Ps), p.getTileX() * 16, p.getTileY() * 16, null);
		g.drawImage(null, mon.getLarge() *16, mon.getWidht() * 16, null);
		
		
	}
	
	public class Al extends KeyAdapter
	{
		public void keyPressed(KeyEvent e) 
        {
            int keycode = e.getKeyCode();

            if(keycode == KeyEvent.VK_Z) 
            {
                if(!(m.getMap(p.getTileX(), p.getTileY() - 1)== '1')) 
                {
                    if(!(m.getMap(p.getTileX(), p.getTileY() - 1)== '3')) 
                    {
                    	if (m.getMap(p.getTileX(), p.getTileY() - 1)== '4')
                    	{
                    		r.axeXY[p.getTileX()][p.getTileY()-1] = 2;
                    		pt = pt + 1;
                    		System.out.println("Your Points :"+ pt)  ;
                    	}
                    	Ps = 1;
                        r.setNothing(p.getTileX(), p.getTileY()-1);
                        p.move(0, -1);
                    }
                }
            }

            if(keycode == KeyEvent.VK_S) 
            {
                if(!(m.getMap(p.getTileX(), p.getTileY() + 1)== '1')) 
                {
                    if(!(m.getMap(p.getTileX(), p.getTileY() + 1)== '3')) 
                    {
                    	if (m.getMap(p.getTileX(), p.getTileY() + 1)== '4')
                    	{
                    		r.axeXY[p.getTileX()][p.getTileY()+1] = 2;
                    		pt = pt + 1;
                    		System.out.println("Your Points :"+ pt)  ;
                    	}
                    	Ps=2;
                        r.setNothing(p.getTileX(), p.getTileY()+1);
                        p.move(0, 1);
                    }
                }
            }

            if(keycode == KeyEvent.VK_Q) 
            {
                if(!(m.getMap(p.getTileX() - 1, p.getTileY())== '1')) 
                {
                    if(!(m.getMap(p.getTileX() - 1, p.getTileY())== '3')) 
                    {
                    	if (m.getMap(p.getTileX()-1, p.getTileY() - 1)== '4')
                    	{
                    		r.axeXY[p.getTileX()-1][p.getTileY()] = 2;
                    		pt = pt + 1;
                    		System.out.println("Your Points :"+ pt)  ;
                    	}
                    	Ps=3;
                        r.setNothing(p.getTileX()-1, p.getTileY());
                        p.move(-1, 0);
                    }
                }
            }

            if(keycode == KeyEvent.VK_D) 
            {
                if(!(m.getMap(p.getTileX() + 1, p.getTileY())== '1')) 
                {
                    if(!(m.getMap(p.getTileX() + 1, p.getTileY())== '3')) 
                    {
                    	if (m.getMap(p.getTileX()+1, p.getTileY())== '4')
                    	{
                    		r.axeXY[p.getTileX()+1][p.getTileY()] = 2;
                    		pt = pt + 1;
                    		System.out.println("Your Points :"+ pt)  ;
                    	}
                    	Ps=4;
                        r.setNothing(p.getTileX()+1, p.getTileY());
                        p.move(1, 0);
                    }
                }
            }
}
}
}