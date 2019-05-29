package View ;


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

import model.Monsters;
import model.Player;
import model.Block;

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
	  
	BufferedImage img ;
	public static int  Ps = 0 ;
	private Block r;
	public Board() 
	{
		m = new Map();
		p = new Player();
		r = new Block();
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
				
				
				
               if (m.getMap(x, y) == '2') {
                	   if ( !(m.tab[x][y] == '0') ){
                		   m.tab[x][y] = '2';
					   
				}
                	
                    g.drawImage(m.getFloor(), x * 16,y * 16 , null);
                    
                }
 
                if(m.getMap(x, y) == '0' )
                {
                    g.drawImage(m.getNothing(),x * 16,y * 16,null);
                }
                	  
              
                if(m.getMap(x,y)== '4'  )
				{
                	g.drawImage(m.getDiamond(), x * 16, y * 16, null);
					
                	if (m.tab[x][y+1] == '0')
						{
						m.tab[x][y] = '0';
						
						m.tab[x][y+1] = '4';
						}
                	else 
                	{
                		m.tab[x][y] = '4';
                	}
					
				}

                if(m.getMap(x, y)== '1')
                {
                	m.tab[x][y] = '1';
                    g.drawImage(m.getWall(), x * 16, y * 16, null);
                }
                if(m.getMap(x,  y)== '3' )
                {
                  
                    g.drawImage(m.getRock(), x * 16,y * 16, null);

                	if (m.tab[x][y+1] == '0' && x+1 != p.getTileX())
					{
					m.tab[x][y] = '0';
					
					m.tab[x][y+1] = '3';
					}
            	else 
            	{
            		m.tab[x][y] = '3';
            	}
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
            	if (m.getMap(p.getTileX(), p.getTileY()) == '3' )
            	{
            		System.out.println("BloQUé");
            	}
            	else if(!(m.getMap(p.getTileX(), p.getTileY() - 1)== '1')) 
                {
                    if(!(m.getMap(p.getTileX(), p.getTileY() - 1)== '3')) 
                    {
                    	if (m.getMap(p.getTileX(), p.getTileY() - 1)== '4')
                    	{
                    		m.tab[p.getTileX()][p.getTileY()-1] = '7';
                    		pt = pt + 1;
                    		System.out.println("Your Points :"+ pt)  ;
                    	}
                    	Ps = 1;
                    	
                        p.move(0, -1);
                      m.tab[p.getTileX()][p.getTileY()] = '0';
                    }
                }
            }

            if(keycode == KeyEvent.VK_S) 
            {
            	if (m.getMap(p.getTileX(), p.getTileY()) == '3' )
            	{
            		System.out.println("BloQUé");
            	}
            	else    if(!(m.getMap(p.getTileX(), p.getTileY() + 1)== '1')) 
                {
                    if(!(m.getMap(p.getTileX(), p.getTileY() + 1)== '3')) 
                    {
                    	if (m.getMap(p.getTileX(), p.getTileY() + 1)== '4')
                    	{
                    		m.tab[p.getTileX()][p.getTileY()+1] = '7';
                    		pt = pt + 1;
                    		System.out.println("Your Points :"+ pt)  ;
                    	}
                    	Ps=2;
                      
                        p.move(0, 1);
                        m.tab[p.getTileX()][p.getTileY()] = '0';
                    }
                }
            }

            if(keycode == KeyEvent.VK_Q) 
            {
            	if (m.getMap(p.getTileX(), p.getTileY()) == '3' )
            	{
            		System.out.println("BloQUé");
            	}
            	else    if(!(m.getMap(p.getTileX() - 1, p.getTileY())== '1')) 
                {
                    if(!(m.getMap(p.getTileX() - 1, p.getTileY())== '3')) 
                    {
                    	if (m.getMap(p.getTileX()-1, p.getTileY())== '4')
                    	{
                    		m.tab[p.getTileX()-1][p.getTileY()] = '7';
                    		pt = pt + 1;
                    		System.out.println("Your Points :"+ pt)  ;
                    	}
                    	Ps=3;
                    	
                        p.move(-1, 0);
                        m.tab[p.getTileX()][p.getTileY()] = '0';
                    }
                }
            }

            if(keycode == KeyEvent.VK_D) 
            {
            	if (m.getMap(p.getTileX(), p.getTileY()) == '3' )
            	{
            		System.out.println("BloQUé");
            	}
            	else    if(!(m.getMap(p.getTileX() + 1, p.getTileY())== '1')) 
                {
                    if(!(m.getMap(p.getTileX() + 1, p.getTileY())== '3')) 
                    {
                    	if (m.getMap(p.getTileX()+1, p.getTileY())== '4')
                    	{
                    		m.tab[p.getTileX()+1][p.getTileY()] = '7';
                    		pt = pt + 1;
                    		System.out.println("Your Points :"+ pt)  ;
                    	}
                    	Ps=4;
                    	
                        p.move(1, 0);
                        m.tab[p.getTileX()][p.getTileY()] = '0';
                    }
                }
            }
}
}
}