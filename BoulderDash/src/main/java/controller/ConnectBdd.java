/*
 * 
 */
package controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// TODO: Auto-generated Javadoc
/**
 * The Class ConnectBdd.
 */
//Création de la classe permettant de se connecter à la base de données
public class ConnectBdd {
    
    /** All attributes for the method createConnection. */
    protected String BDD = "JavaProject";
    
    /** The url. */
    protected String url = "jdbc:mysql://localhost:3306/" + BDD;
    
    /** The user. */
    protected String user = "root";
    
    /** The passwd. */
    protected String passwd = "";
    
    /** The choice. */
    protected int choice;
    
    /** The cst. */
    protected CallableStatement cst ;

    /** All attributes for the method chooseMap. */
    protected Connection conn;
    
    /** The st. */
    protected Statement st;
    
    /** The rst. */
    protected ResultSet rst;
    
    /** The stg. */
    protected String stg;




/**
 * Creates the connexion.
 *
 * @author Le Fortier
 * First method -- createConnection :
 * Provide a connection betwwen the computer and the database.
 */
    public void createConnexion() {
    /**
     *In the part "try" we have the instructions to be connected to the database.
     */
    try {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(url, user, passwd);
        System.out.println("Connected");

    } catch (ClassNotFoundException e){
        e.printStackTrace();
        System.out.println("Error");
        System.exit(0);
    /**
    *In the part "catch" we have the exceptions, if the connection doesn't work.
    */
     }catch(SQLException e){
        e.printStackTrace();
     }
}

/**
 * Choose map.
 *
 * @author Le Fortier
 * @param ch the choice of the user
 * This method is used to choice the map you want to play
 * @throws SQLException the SQL exception
 */
    public void chooseMap(int ch) throws SQLException {
        try {
        cst = conn.prepareCall("{call chooseMap(?, ?)}");
        cst.setInt(1, ch);
        cst.registerOutParameter(2, java.sql.Types.VARCHAR);
        cst.execute();
        stg = cst.getString(2);

    }catch(SQLException e) {
        e.printStackTrace();
        System.out.println("Error");
    }

    /**
     * In the part "while" we have a loop to publish the result.
     /
          /  while(rst.next()) {
                stg = rst.getString("Map");
               // System.out.println(stg);*/

                try {
                      File ff=new File("Map.txt");
                    FileWriter ffw=new FileWriter(ff);
                    ffw.write(stg);
                    ffw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
    }

}