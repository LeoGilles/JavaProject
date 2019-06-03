package model;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import junit.framework.TestCase;

// TODO: Auto-generated Javadoc
/**
 * The Class BoardTest.
 */
public class BoardTest extends TestCase {
 
   /** The b. */
   Board b = new Board();
    
	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	protected void setUp() throws Exception {
		super.setUp();
		
	}

	/**
	 * Tear down.
	 *
	 * @throws Exception the exception
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test board.
	 */
	public void testBoard() {
		fail("Not yet implemented");
	}

	/**
	 * Test action performed.
	 */
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

	/**
	 * Test paint graphics.
	 */
	public void testPaintGraphics() {
		fail("Not yet implemented");
	}

	

	/**
	 * Test J panel.
	 */
	public void testJPanel() {
		fail("Not yet implemented");
	}



}
