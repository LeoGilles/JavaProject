package controller;

import junit.framework.Assert;
import junit.framework.TestCase;

public class ConnectBddTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testCreateConnexion() {
		/**
		 * A test to see if the connection with the database works. The method return a String with the message "Connected" and we compare is the massage is true
		 */			
			ConnectBdd cbd = new ConnectBdd();
			cbd.createConnexion();
			String stg = cbd.getCreateConnection();
			Assert.assertEquals("Connected", stg);
	}


}
