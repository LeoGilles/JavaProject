/*
 * 
 */
package Model ;


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
import View.Player;



/**
 * The Class Board.
 */
public class Board extends JPanel implements ActionListener
{
	
	/** Variable initialisation. */
	private static final long serialVersionUID = 1L;
	
	/** The timer. */
	private Timer timer;
	
	/** The m. */
	private Map m;
	
	/** The p. */
	private Player p;
	
	/** The Mo 1. */
	protected int Mo1 = 0;
	
	/** The pt. */
	private int pt = 0;
	
	/** The position. */
	private int position = 1;
	
	/** The img. */
	BufferedImage img ;
	
	/** The Ps. */
	public  int  Ps = 0 ;
	
	/**
	 * Instantiates a new board.
	 */
	public Board() 
	{
		/**
		 * Instanciation
		 */
		m = new Map();
		p = new Player();      
		
		
		addKeyListener(new Al());
		setFocusable(true);
		
		/**
		 * Timer to refresh our panel
		 */
		timer = new Timer(25, this);
		timer.restart();
	}
	
	/**
	 * method to repaint our Jpanel.
	 *
	 * @param e the e
	 */
	public void actionPerformed(ActionEvent e) 
	{
		repaint();
	}
	
	/**
	 * paint of our JPanel.
	 *
	 * @param g the g
	 */
	public void paint(Graphics g) 
	{
		super.paint(g);
		try {
			/**
			 * Background Image (default), from a jpg
			 */
			img = ImageIO.read(new File("download.png"));
			g.drawImage(img,0,0,this.getWidth(),this.getHeight(),this);
		} catch (IOException e) {
			e.printStackTrace();
		}
		/**
		 * double "for" who read our table in order to create the graphical interface 
		 * in this loop we will read our table character by character and replace them by
		 * a jpg
		 */
	
		for(int y = 0; y < 29; y++) 
		{
			for(int x = 0; x < 29; x++) 
			{
				
				
				/**
				 * if in your table there is a '2' character we will replace him by a dirt block
				 * and the second 'if' is a condition to don't  put a rock if there was a void here 
				 * before('0') , when the player is moving ,he will delete the block he is on , and we 
				 * don't want the block from the last move to come back after the graphical refresh   
				 */
               if (m.getMap(x, y) == '2') {
                	   if ( !(m.tab[x][y] == '0') ){
                		   m.tab[x][y] = '2';
					   
				}
                	
                    g.drawImage(m.getFloor(), x * 16,y * 16 , null);
                    
                }
    /**
     * if we have a '0' character , we will put nothing graphicaly and a '0' in our table
     */
                if(m.getMap(x, y) == '0' || m.getMap(x, y)== '8' )
                {
                    g.drawImage(m.getNothing(),x * 16,y * 16,null);
                }
                	  /**
                	   * if we have '4' we will put a diamons , the second condition is to implement 
                	   * the falling mechanics,if there is nothing(0) below our diamons , we will 
                	   * replace the block below by a diamons and our block by nothing .
                	   * The last part of the second if  is to prevent the diamons to directly fall
                	   * on the players. If we on't put this condition , the diamons will directly 
                	   * fall when the players is under,we don't want this because the player had an hitbox
                	   */
              
                if(m.getMap(x,y)== '4'  )
				{
                	g.drawImage(m.getDiamond(), x * 16, y * 16, null);
					
                	if (m.tab[x][y+1] == '0' &&  (x != p.getTileX() || y+1 != p.getTileY()))
					{
					m.tab[x][y] = '0';
					
					m.tab[x][y+1] = '4';
					}
                	else if (m.tab[x+1][y] == '0' && m.tab[x+1][y+1] == '0' &&(  (x+1 != p.getTileX() || y+1 != p.getTileY()) ))
					{
						m.tab[x][y] = '0';
						m.tab[x+1][y+1] = '4';
					}
                	else if (m.tab[x-1][y] == '0' && m.tab[x-1][y+1] == '0' &&(  (x-1 != p.getTileX() || y+1 != p.getTileY()) ))
					{
						m.tab[x][y] = '0';
						m.tab[x-1][y+1] = '4';
					}
            	else 
            	{
            		m.tab[x][y] = '4';
            	}
					
				}
                /**
                 * if we have a '1' character , we will put a wall graphicaly and a '1' in our table
                 */
                if(m.getMap(x, y)== '1')
                {
                	m.tab[x][y] = '1';
                    g.drawImage(m.getWall(), x * 16, y * 16, null);
                }
                /**
          	   * if we have '3' we will put a Rock , the second condition is to implement 
          	   * the falling mechanics,if there is nothing(0) below our Rock , we will 
          	   * replace the block below by a Rock and our block by nothing .
          	   * The last part of the if is aslo to don't directly kill the player, we have to wait 
          	   * until the players make is move , but if he go below to the rock ,  he will get at the same 
          	   * position with our rock and will get stuck(killed)
          	   */
                
                if(m.getMap(x,  y)== '3' )
                {
                  
                    g.drawImage(m.getRock(), x * 16,y * 16, null);

                	if (m.tab[x][y+1] == '0'  &&(  (x != p.getTileX() || y+1 != p.getTileY()) ))
					{
					m.tab[x][y] = '0';
					m.tab[x][y+1] = '3';
					
					if (x == p.getTileX() && y+2 == p.getTileY())
					{
						m.tab[x][y+2] = '3';
						
					}
					}
                	else if (m.tab[x+1][y] == '0' && m.tab[x+1][y+1] == '0' &&(  (x+1 != p.getTileX() || y+1 != p.getTileY()) ))
					{
						m.tab[x][y] = '0';
						m.tab[x+1][y+1] = '3';
					}
                	else if (m.tab[x-1][y] == '0' && m.tab[x-1][y+1] == '0' &&(  (x-1 != p.getTileX() || y+1 != p.getTileY()) ))
					{
						m.tab[x][y] = '0';
						m.tab[x-1][y+1] = '3';
					}
            	else 
            	{
            		m.tab[x][y] = '3';
            	}
                }
                /**
                 * if we have a 'f' character , we will put finishblock graphicaly and a 'f' in our table,
                 * we can finish the level by collecting all diamons and go on the block
                 */
                if(m.getMap(x, y) == 'f')
                {
                    g.drawImage(m.getFinish(), x * 16, y * 16, null);
                }
                if(m.getMap(p.getTileX(), p.getTileY()) == 'f' && pt == 8)
                {
                    g.drawImage(m.getPho(), 0, 0, this.getWidth(), this.getHeight(), null);
                }
                
                
                if(m.getMap(x, y)== '5')
                {
                	if (position == 1 && m.getMap(x, y-1)== '0' )
                	{
                		m.tab[x][y] = '0';
                		m.tab[x][y-1] = '5';
                		 g.drawImage(m.getmonster(),x * 16,y * 16,null);
                		 position = 0;
                	}
                	else if (position == 1 && m.getMap(x, y-1)== '3')
                	{
                		m.tab[x][y] = '0';
                		m.tab[x][y-1] = '3';
                	}
                	else if (position == 2 && m.getMap(x, y+1)== '0')
                	{
                		m.tab[x][y] = '0';
                		m.tab[x][y+1] = '5';
                		g.drawImage(m.getmonster(),x * 16,y * 16,null);
                		position = 0;
                	}
                	else if (position == 3 && m.getMap(x-1, y)== '0')
                	{
                		m.tab[x][y] = '0';
                		m.tab[x-1][y] = '5';
                		g.drawImage(m.getmonster(),x * 16,y * 16,null);
                		position = 0;
                	}
                	else if (position == 4 && m.getMap(x+1, y)== '0')
                	{
                		m.tab[x][y] = '0';
                		m.tab[x+1][y] = '5';
                		g.drawImage(m.getmonster(),x * 16,y * 16,null);
                		position = 0;
                	}                
                	else
                	{
                		g.drawImage(m.getmonster(),x * 16,y * 16,null);
                		position = 0;
                	}
                           	
                }
                if ( m.getMap(p.getTileX(), p.getTileY()-1) == '5')
                {
                	m.tab[p.getTileX()][p.getTileY()] = '8';
                }
                if ( m.getMap(p.getTileX(), p.getTileY()+1) == '5')
                {
                	m.tab[p.getTileX()][p.getTileY()] = '8';
                }
                if ( m.getMap(p.getTileX()-1, p.getTileY()) == '5')
                {
                	m.tab[p.getTileX()][p.getTileY()] = '8';
                }
                if ( m.getMap(p.getTileX()+1, p.getTileY()) == '5')
                {
                	m.tab[p.getTileX()][p.getTileY()] = '8';
                }
			}	
		}
		/**
		 * clearRect to refresh our player's model (who is not essential , just to be sure)
		 * Player's display,call our class players and his function
		 */
		g.clearRect(p.getTileX() * 16,p.getTileY() * 16,0,0);
		g.drawImage(p.getPlayer(Ps), p.getTileX() * 16, p.getTileY() * 16, null);	
		
	}
	
	/**
	 * Player's movements controller .
	 *
	 * @author leo gilles
	 */
	public class Al extends KeyAdapter
	{
		
		/**
		 * Key pressed.
		 *
		 * @param e the e
		 */
		public void keyPressed(KeyEvent e) 
        {
			/**
			 * variable initialisation
			 */
            int keycode = e.getKeyCode();
            /**
             * if our players go up, we will test if there is nothing wrong with the position up
             * if there is nothing , the player will change his position,change his sprite with
             *  and change his next position to '0' in the table ( this   is in order
             * to remove the dirtblock when the player is passing on) ,but if there is a Rock '3
             *  ' or a wall '1' , he will not change his position, if there is a finish
             *   block 'f' or a rock '3'in his actual case he will get stuck  (end of the game )
             *  if there is a diamons he will do the same as the dirt block and increment our points
             *  when we change something in our table, we will see the changes at the next graphical refresh
             */
            if(keycode == KeyEvent.VK_Z) 
            {
            	if (m.getMap(p.getTileX(), p.getTileY()) == 'f'|| m.getMap(p.getTileX(), p.getTileY()) == '3' ||m.getMap(p.getTileX(), p.getTileY()) == '8' ) /**test if we are on a rock or finishblock   */
            	{
            		System.out.println("Game Over");                           /**display end*/
            		Ps = 5;                                              /**change sprite*/           		
            	}
            	
            	else if(!(m.getMap(p.getTileX(), p.getTileY() - 1)== '1')) /**test if the next case is a wall   */
                {
                    if(!(m.getMap(p.getTileX(), p.getTileY() - 1)== '3')) /**test if the next case is a Rock   */
                    {
                    	if (m.getMap(p.getTileX(), p.getTileY() - 1)== '4')  /** test if the next case is a diamons */
                    	{
                    		m.tab[p.getTileX()][p.getTileY()-1] = '0';  /** set 0 to table */
                    		pt = pt + 1;                                 /**add points*/
                    		System.out.println("Your Points :"+ pt)  ;    /** display points*/   
                    	}
                    	Ps = 1;                                   /**change sprite*/                    	
                        p.move(0, -1);                                  /** make the player move */
                      m.tab[p.getTileX()][p.getTileY()] = '0';          /** set 0 to table */
                  
                    }
                }
            	position = m.getRandomNumberInts(1,4);
            }
/**
 * the same as up.key but for down.key
 */
            if(keycode == KeyEvent.VK_S) 
            {            	
           	if (m.getMap(p.getTileX(), p.getTileY()) == 'f'|| m.getMap(p.getTileX(), p.getTileY()) == '3' ||m.getMap(p.getTileX(), p.getTileY()) == '8')
            	{
            		System.out.println("Game Over");
            		Ps = 5;
            	}
           	else	if (m.getMap(p.getTileX(), p.getTileY()+1) == 'f' )
            	{        	
            		p.move(0, 1);
            	}
            	else    if(!(m.getMap(p.getTileX(), p.getTileY() + 1)== '1')) 
                {
                    if(!(m.getMap(p.getTileX(), p.getTileY() + 1)== '3')) 
                    {
                    	if (m.getMap(p.getTileX(), p.getTileY() + 1)== '4')
                    	{
                    		m.tab[p.getTileX()][p.getTileY()+1] = '0';
                    		pt = pt + 1;
                    		System.out.println("Your Points :"+ pt)  ;
                    	}
                    	Ps=2;
                        p.move(0, 1);
                        m.tab[p.getTileX()][p.getTileY()] = '0';
                    }
                }
           	position = m.getRandomNumberInts(1,4);
            }
            /**
             * the same as up.key and down.key but , if we try to go in a rock block and there is 
             * nothing after this rock, we will push the rock block and take his place 
             */
            if(keycode == KeyEvent.VK_Q) 
            {  
           	if (m.getMap(p.getTileX(), p.getTileY()) == 'f' || m.getMap(p.getTileX(), p.getTileY()) == '3'||m.getMap(p.getTileX(), p.getTileY()) == '8' )
            	{
            		System.out.println("Game Over");
            		Ps = 5;
            	}
           	else	if (m.getMap(p.getTileX()-1, p.getTileY()) == 'f' )
            	{        		
            		p.move(-1, 0);
            	}
            	else    if(!(m.getMap(p.getTileX() - 1, p.getTileY())== '1')) 
                {
                    if(!(m.getMap(p.getTileX() - 1, p.getTileY())== '3')) 
                    {                                       		
                    	if (m.getMap(p.getTileX()-1, p.getTileY())== '4')
                    	{
                    		m.tab[p.getTileX()-1][p.getTileY()] = '0';
                    		pt = pt + 1;
                    		System.out.println("Your Points :"+ pt)  ;
                    	}                  	
                    	Ps=3;                    	
                        p.move(-1, 0);
                        m.tab[p.getTileX()][p.getTileY()] = '0';     
                    }
                    else if (m.getMap(p.getTileX() - 1, p.getTileY())== '3')  /** test if this is a rock */
                    {														
                    	if (m.getMap(p.getTileX() - 2, p.getTileY())== '0')  /**test if there is nothing 2 case ahead*/
                    	{
                    		Ps=3;                                          /**change sprite*/
                    		m.tab[p.getTileX()-2][p.getTileY()] = '3';    /**replace the case by a rock*/
                            p.move(-1, 0);                                /** move player*/
                            m.tab[p.getTileX()][p.getTileY()] = '0';       /**replace the case by nothing*/
                    	}
                    }
                }
           	position = m.getRandomNumberInts(1,4);
            }
            /**
             * the same as left.key
             */
            if(keycode == KeyEvent.VK_D) 
            {
            	if (m.getMap(p.getTileX(), p.getTileY()) == 'f'|| m.getMap(p.getTileX(), p.getTileY()) == '3' ||m.getMap(p.getTileX(), p.getTileY()) == '8')
            	{
            		System.out.println("Game Over");
            		Ps = 5;
            	}
            	else if (m.getMap(p.getTileX()+1, p.getTileY()) == 'f' )
            	{           		
            		p.move(1, 0);
            	}
            	else    if(!(m.getMap(p.getTileX() + 1, p.getTileY())== '1')) 
                {
                    if(!(m.getMap(p.getTileX() + 1, p.getTileY())== '3')) 
                    {
                    	if (m.getMap(p.getTileX()+1, p.getTileY())== '4')
                    	{
                    		m.tab[p.getTileX()+1][p.getTileY()] = '0';
                    		pt = pt + 1;
                    		System.out.println("Your Points :"+ pt)  ;
                    	}
                    	Ps=4;                   	
                        p.move(1, 0);
                        m.tab[p.getTileX()][p.getTileY()] = '0';
                    }
                    else if (m.getMap(p.getTileX() + 1, p.getTileY())== '3')
                    {
                    	if (m.getMap(p.getTileX() + 2, p.getTileY())== '0')
                    	{
                    		Ps=4;
                    		m.tab[p.getTileX()+2][p.getTileY()] = '3';
                            p.move(1, 0);
                            m.tab[p.getTileX()][p.getTileY()] = '0';
                    	}
                    }
                }
            }
            position = m.getRandomNumberInts(1,4);
}
}
}