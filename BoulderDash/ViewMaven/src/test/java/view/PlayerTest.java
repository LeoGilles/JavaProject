/*
 * 
 */
package view;

import java.awt.Image;

import javax.swing.ImageIcon;

import fr.exia.BoulderDash.Player;
import junit.framework.TestCase;

// TODO: Auto-generated Javadoc
/**
 * The Class PlayerTest.
 */
public class PlayerTest extends TestCase {

	/** The p. */
	private Player p;
	
	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	protected void setUp() throws Exception {
		super.setUp();
		p = new Player();
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
	 * Test the instanciation get player.
	 */
	public void testGetPlayer() {
		Image player6;
		ImageIcon img5 = new ImageIcon("playerdown.jpg");
		player6 = img5.getImage();
		final Image expected = player6;
		assertEquals(expected,p.getPlayer(6));
	}

	/**
	 * Test  the attribute and the return of get tile X.
	 */
	public void testGetTileX() {
		final int expected =  1 ;
		assertEquals(expected,p.getTileX());
	}

	/**
	 * Test the attribute and the return  get tile Y.
	 */
	public void testGetTileY() {
		final int expected =  1 ;
		assertEquals(expected,p.getTileY());
	}

	/**
	 * Test if the method move really change our position
	 */
	public void testMove() {
		final int expected1 = 2 ;
		final int expected2 = 2 ;
		p.move(1, 1);
		assertEquals(expected1,p.getTileX());
		assertEquals(expected2,p.getTileY());
	}

}
