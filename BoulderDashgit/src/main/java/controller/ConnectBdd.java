package controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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


    /**
     * All attributes for the method chooseMap
     */
    protected Connection conn;
    protected Statement st;
    protected ResultSet rst;
    protected String stg;




/**
 * @author Le Fortier
 * First method --> createConnection :
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
     @author Le Fortier
     * @param ch the choice of the user
     * This method is used to choice the map you want to play
     */
    public void chooseMap(int ch) {
        try {
            st = conn.createStatement();
    /**
     *  In the part "switch" the SQL request is chose according to the choice of the user in the param ch.
     * - st is a Statement object, to use SQL requests
     * - rst is a ResultSet object, to take the result of the Statement object.
     */
            switch(ch)
            {
            case 1:
                rst = st.executeQuery("SELECT * FROM levels WHERE id= 1");
                break;
            case 2:
                rst = st.executeQuery("SELECT * FROM levels WHERE id= 2");
                break;
            case 3:
                 rst = st.executeQuery("SELECT * FROM levels WHERE id= 3");
                 break;
            case 4:
                 rst = st.executeQuery("SELECT * FROM levels WHERE id= 4");
                 break;
            case 5:
                 rst = st.executeQuery("SELECT * FROM levels WHERE id= 5");
                 break;
            default:
                rst = st.executeQuery("SELECT * FROM levels WHERE id= 1");
                break;
            }

    /**
     * In the part "while" we have a loop to publish the result.
     */
            while(rst.next()) {
                stg = rst.getString("Map");
               // System.out.println(stg);
              
                try {
					  File ff=new File("Map.txt");
                	FileWriter ffw=new FileWriter(ff);
                	ffw.write(stg);
                	ffw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
    /**
     * In the part "catch" we have the exceptions, if the instructions don't work.
     */
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }


}