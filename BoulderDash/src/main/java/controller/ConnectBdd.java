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

//Création de la classe permettant de se connecter à la base de données
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
 * <br></br>
 * Method : createConnection :
 * Provide a connection betwwen the computer and the database.
 * <br></br>
 * <url>
 * In the part <b>try</b> we have the instructions to be connected to the database.
 * You use the method <b>ForName</b> to call the driver which is used to connect the database with
 * your computer.
 * Four attributes are created :
 * <li> The attribute <b>BDD</b>, to include the name of the database</li>
 * <li>The attribute <b>url</b>, to include the way to the database</li>
 * <li>the attribute <b> login </b>, to include the login of the database</li>
 * <li>The attribute <b>passwd</b>, to include the password of the database</li>
 * Finally we use the method <b>getConnection</b> from the class <b>DriverManager</b> to be connected to the database.
 * <br></br>
 * In the part <b>catch</b> we have the exceptions, if the connection doesn't work.
 * @return 
 *  @exception SQLExceptions
 * </url>
 */
    public void createConnexion() {
   
    try {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(url, user, passwd);
        resultConnection = "Connected";
       // System.out.println(resultConnection);

        

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
 @author Le Fortier <br></br>
 
 * This method is used to choice the map you want to play <br></br>
 * <url>
 * In the part <b>try</b> we have the call of the procedure in the database.
 * <li><b>cst</b> is a <b>CallableStatement</b> object which call a procedure.</li>
 * <li>The method <b>prepareCall</b> allows to call the procedure called <b>chooseMap(?, ?)</b> with to parameters : one INPUT parameter and one OUTPUT parameter.</ld>
 * <li>The method <b>setInt</b> allows to give the INPUT parameter.
 * <li>The method <b>registerOutParameter</b> allows to give the OUTPUT parameter which is the result of the procedure.</ld>
 * <li>The method <b>execute</b> allows to execute the procedure.</ld> <br></br>
 * After that, we write the result (the map) in a txt file.
 * 
 * </url>
 * @param ch the choice of the user
 * @exception IOException
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
