package View;

import java.awt.Image;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.ImageIcon;

import junit.framework.TestCase;

public class MapTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
		
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testGetFloor() {
		Map m = new Map();
		Image floor;
		ImageIcon img = new ImageIcon("DirtBlock.jpg");
		floor = img.getImage();
		assertEquals(floor,m.getFloor());
	}

	public void testGetWall() {
		Map m = new Map();
		Image wall;
		ImageIcon img = new ImageIcon("Wall.jpg");
		wall = img.getImage();
		assertEquals(wall,m.getWall());
	}

	public void testGetRock() {
		Map m = new Map();
		Image rock;
		ImageIcon img = new ImageIcon("Rock1.jpg");
		rock = img.getImage();
		assertEquals(rock,m.getRock());
	}

	public void testGetNothing() {
		Map m = new Map();
		Image nothing;
		ImageIcon img = new ImageIcon("download.jpg");
		nothing = img.getImage();
		assertEquals(nothing,m.getNothing());
	}

	public void testGetDiamond() {
		Map m = new Map();
		Image diamond;
		ImageIcon img = new ImageIcon("Diamons1.jpg");
		diamond = img.getImage();
		assertEquals(diamond,m.getDiamond());
	}

	public void testGetPho() {
		Map m = new Map();
		Image pho;
		ImageIcon img = new ImageIcon("endSprite.jpg");
        pho = img.getImage();
		assertEquals(pho,m.getPho());
	}

	public void testGetFinish() {
		Map m = new Map();
		Image finish;
		ImageIcon img = new ImageIcon("finish1.jpg");
        finish = img.getImage();
		assertEquals(finish,m.getFinish());
	}

	public void testGetmonster() {
		Map m = new Map();
		Image monster1;
		ImageIcon  img = new ImageIcon("Mob.jpg");
        monster1 = img.getImage();
        m.rand = 0;
		assertEquals(monster1,m.getmonster());


	}

	public void testGetMap() {
		Map m = new Map();
		char eq;
		eq = '1';
		assertEquals(eq,m.getMap(0, 0));
	}

	public void testGetRandomNumberInts() {
		Map m = new Map();
		int eq = m.getRandomNumberInts(1, 3);
		
		if (1<eq && eq<3)
		{
			assertEquals(0,0);
		}
		else {
			fail("euh error");
		}
		
	}

	public void testOpenFile() {
		Map m = new Map();
		m.openFile();
		char[][] eq;
		int nbCol = 0;
		int nbLig = 0;
		try
		{
			@SuppressWarnings("resource")
			Scanner sc = new Scanner ( new FileReader ( "Map.txt" ) ); 

			nbCol = sc.nextLine().length();
			nbLig = 1;
			while ( sc.hasNextLine() )
			{
				sc.nextLine();
				nbLig++;
			}
		}
		catch(Exception e){	e.printStackTrace(); }
		eq = new char[nbLig][nbCol];
		assertEquals(eq[1][1],m.tab[1][1]);
	}

	
	public void testReadFile() {
		Map m = new Map();
		m.readFile();
		char eq = '0' ;
		eq = '1' ;
		assertEquals(eq,m.tab[0][0]);
		
	}

	

}
