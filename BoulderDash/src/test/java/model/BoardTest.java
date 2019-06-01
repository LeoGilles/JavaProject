package model;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import junit.framework.TestCase;

public class BoardTest extends TestCase {
 
   Board b = new Board();
    
	protected void setUp() throws Exception {
		super.setUp();
		
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testBoard() {
		fail("Not yet implemented");
	}

	public void testActionPerformed() {
		 int keycode;
		Robot bot = null;
			try {
				bot = new Robot();
			} catch (AWTException e) {

				e.printStackTrace();
			}
			final int ve = 0 ;
			keycode = KeyEvent.VK_UP;
			bot.keyPress(keycode);
		
			assertEquals(ve,b.Ps);
			
	}

	public void testPaintGraphics() {
		fail("Not yet implemented");
	}

	

	public void testJPanel() {
		fail("Not yet implemented");
	}



}
