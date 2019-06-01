package controller;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import java.util.Scanner;

import javax.swing.JFrame;

import junit.framework.TestCase;

public class MainJavaTest extends TestCase {
	 
	private JFrame testFrame;
	
	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		 if (this.testFrame != null) {
	            this.testFrame.dispose(  );
	            this.testFrame = null;
	        }
	}

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

	public void testMainJava() {
		
		if (this.testFrame == null) {
            this.testFrame = new JFrame("Test");
        }
       assertEquals(this.testFrame == this.testFrame,true);
	
	}

}
