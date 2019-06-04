package view;

import java.awt.Image;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.ImageIcon;

import fr.exia.BoulderDash.Map;
import junit.framework.TestCase;

// TODO: Auto-generated Javadoc
/**
 * The Class MapTest.
 */
public class MapTest extends TestCase {

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
	 * Test the instanciation get floor.
	 */
	public void testGetFloor() {
		Map m = new Map();
		Image floor;
		ImageIcon img = new ImageIcon("DirtBlock.jpg");
		floor = img.getImage();
		assertEquals(floor,m.getFloor());
	}

	/**
	 * Test the instanciation get wall.
	 */
	public void testGetWall() {
		Map m = new Map();
		Image wall;
		ImageIcon img = new ImageIcon("Wall.jpg");
		wall = img.getImage();
		assertEquals(wall,m.getWall());
	}

	/**
	 * Test the instanciation get rock.
	 */
	public void testGetRock() {
		Map m = new Map();
		Image rock;
		ImageIcon img = new ImageIcon("Rock1.jpg");
		rock = img.getImage();
		assertEquals(rock,m.getRock());
	}

	/**
	 * Test the instanciation get nothing.
	 */
	public void testGetNothing() {
		Map m = new Map();
		Image nothing;
		ImageIcon img = new ImageIcon("download.jpg");
		nothing = img.getImage();
		assertEquals(nothing,m.getNothing());
	}

	/**
	 * Test the instanciation get diamond.
	 */
	public void testGetDiamond() {
		Map m = new Map();
		Image diamond;
		ImageIcon img = new ImageIcon("Diamons1.jpg");
		diamond = img.getImage();
		assertEquals(diamond,m.getDiamond());
	}

	/**
	 * Test the instanciation get pho.
	 */
	public void testGetPho() {
		Map m = new Map();
		Image pho;
		ImageIcon img = new ImageIcon("endSprite.jpg");
        pho = img.getImage();
		assertEquals(pho,m.getPho());
	}

	/**
	 * Test the instanciation get finish.
	 */
	public void testGetFinish() {
		Map m = new Map();
		Image finish;
		ImageIcon img = new ImageIcon("finish1.jpg");
        finish = img.getImage();
		assertEquals(finish,m.getFinish());
	}

	/**
	 * Test the instanciation getmonster.
	 */
	public void testGetmonster() {
		Map m = new Map();
		Image monster1;
		ImageIcon  img = new ImageIcon("Mob.jpg");
        monster1 = img.getImage();
        m.rand = 0;
		assertEquals(monster1,m.getmonster());


	}

	/**
	 * Test get map.
	 * test if at this position there is the real char
	 */
	public void testGetMap() {
		Map m = new Map();
		char eq;
		eq = '1';
		assertEquals(eq,m.getMap(0, 0));
	}

	/**
	 * Test get random number ints.
	 * try the random number command and test if the value is not unexpected or out of bounds
	 */


	/**
	 * Test open file.
	 * new scanner on the Map and compare a position with the same position 
	 * in the real OpenFile() method
	 */

	
	/**
	 * Test read file.
	 * new scanner to test if the Readfile is working corectly
	 */
	

	

}
