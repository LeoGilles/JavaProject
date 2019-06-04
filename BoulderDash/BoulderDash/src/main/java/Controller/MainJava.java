/*
 * 
 */
package Controller;


import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JFrame;


import Model.Board;
// TODO: Auto-generated Javadoc
/**
 * The Class MainJava.
 */
public class MainJava 
{
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) 
	{
		/**
		 * Instanciation of our Connnection method to our BDD
		 */
		  ConnectBdd cbdd = new ConnectBdd();
		  /**
		   * Scanner in order to select our World with the consol
		   */
	        Scanner sc = new Scanner(System.in);
	        System.out.println("Which levels do you want ? 1-5 ");
	        int choice = sc.nextInt();
	       /**
	        * Function to ConnectBDD class and cbdd.chooseMap(choice);
	        * to call the BDD process to select a levels
	        */
	        cbdd.createConnexion();
	        try {
				cbdd.chooseMap(choice);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        sc.close(); /** scanner closing*/
		new MainJava();
	}
	 
 	/**
 	 * Constructor to create the Jframe case.
 	 */
	public MainJava() 
	{
		JFrame f = new JFrame();
		f.setTitle("Boulder Dash");    /**Title*/
		f.add(new Board());
		f.setSize(490, 512);            /**Dimension */
		f.setLocationRelativeTo(null);
		f.setResizable(false);           
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.toFront();
	}
	
	}

