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


public class ConnectBdd {
	
/**
 * All attributes for the method createConnection
 */
    protected String BDD = "JavaProject";
    protected String url = "jdbc:mysql://localhost:3306/" + BDD;
    protected String user = "root";
    protected String passwd = "";
    protected int choice;
    protected CallableStatement cst ;

/**
 * All attributes for the method chooseMap
 */
    protected Connection conn = null;
    protected Statement st = null;
    protected ResultSet rst = null;
    protected String stg = null;
    protected String resultConnection = null;

/**
 * @author Le Fortier
 * 
 * Method : createConnection :
 * Provide a connection betwwen the computer and the database.
 * 
 * 
 * In the part try we have the instructions to be connected to the database.
 * You use the method ForName to call the driver which is used to connect the database with
 * your computer.
 * Four attributes are created :
 *  The attribute BDD, to include the name of the database
 * The attribute url, to include the way to the database
 * the attribute  login , to include the login of the database
 * The attribute passwd, to include the password of the database
 * Finally we use the method getConnection from the class DriverManager to be connected to the database.
 * 
 * In the part catch we have the exceptions, if the connection doesn't work.
 * 
 * 
 * 
 */
    public void createConnexion() {
   
    try {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(url, user, passwd);
        resultConnection = "Connected";
       System.out.println(resultConnection);

        

    } catch (ClassNotFoundException e){
        e.printStackTrace();
        System.out.println("Error");
        System.exit(0);

    } catch(SQLException e){
        e.printStackTrace();
     }

}
    
    public String getCreateConnection() {
    	return resultConnection;
    }
/**
 @author Le Fortier 
 
 * This method is used to choice the map you want to play 
 * 
 * In the part try we have the call of the procedure in the database.
 * cst is a CallableStatement object which call a procedure.
 * The method prepareCall allows to call the procedure called chooseMap(?, ?) with to parameters : one INPUT parameter and one OUTPUT parameter.
 * The method setInt allows to give the INPUT parameter.
 * The method registerOutParameter allows to give the OUTPUT parameter which is the result of the procedure.
 * The method execute allows to execute the procedure.
 * After that, we write the result (the map) in a txt file.
 * 
 * 
 * @param ch the choice of the user
 * 
 */
    public void chooseMap(int ch) throws SQLException {
    	try {
        cst = conn.prepareCall("{call chooseMap(?, ?)}");
        cst.setInt(1, ch);
        cst.registerOutParameter(2, java.sql.Types.VARCHAR);
        cst.execute();
        stg = cst.getString(2);
        		
        File ff=new File("Map.txt");
        FileWriter ffw=new FileWriter(ff);
        ffw.write(stg);
        ffw.close();

        }catch(SQLException e) {
	        e.printStackTrace();
	        System.out.println("Error");
        }catch (IOException e) {
        	e.printStackTrace();
        }       
    }
}
