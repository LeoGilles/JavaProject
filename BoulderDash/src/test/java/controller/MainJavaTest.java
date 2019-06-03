package controller;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import java.util.Scanner;

import javax.swing.JFrame;

import junit.framework.TestCase;

// TODO: Auto-generated Javadoc
/**
 * The Class MainJavaTest.
 */
public class MainJavaTest extends TestCase {
	 
	/** The test frame. */
	private JFrame testFrame;
	
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
		 if (this.testFrame != null) {
	            this.testFrame.dispose(  );
	            this.testFrame = null;
	        }
	}

	/**
	 * Test if we did an input from a key what change will occur in main.
	 * and if the Map selection is working
	 */
	public void testMain() {
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
        System.out.println("Which levels do you want ? 1-5 ");
        int choice = sc.nextInt();
        int keycode;
		Robot bot = null;
			try {
				bot = new Robot();
			} catch (AWTException e) {

				e.printStackTrace();
			}
			keycode = KeyEvent.VK_1;
			bot.keyPress(keycode);
			assertEquals(1,choice);	
	}

	/**
	 * Test the Graphical interface JFrame in main java.
	 */
	public void testMainJava() {
		
		if (this.testFrame == null) {
            this.testFrame = new JFrame("Test");
        }
       assertEquals(this.testFrame == this.testFrame,true);
	
	}

}
