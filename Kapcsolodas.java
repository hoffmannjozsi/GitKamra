
package Kamra;

import static Kamra.KamraFoablak.kapcsolatTxt;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author Hoffmann József
 */
public class Kapcsolodas extends KamraFoablak {
    

    public Kapcsolodas() throws KamraDAOException {
        //Alapértelmezett adatbázis kapcsolat
        String hostname = "localhost"; 
        String port = "3306";
        String db = "kamra";
        String serverTimezone = "UTC"; 
        String useSSL ="false";
        String username = "root";
        String pw = "1234";
        try {
            Properties prop = new Properties();
            prop.load(new FileReader("config.ini"));
            hostname = prop.getProperty("hostname");
            port = prop.getProperty("port");
            serverTimezone = prop.getProperty("serverTimezone"); 
            useSSL = prop.getProperty("useSSL");
            db = prop.getProperty("db");
             
            
        } catch (IOException ex) {
            throw new KamraDAOException("Hiba a config.ini fájl beolvasásakor: " + ex.getMessage());
        }
        BejelentkezesDialog bjDialog = new BejelentkezesDialog(this, true);
        bjDialog.setTitle("Bejelentkezés");
        bjDialog.setVisible(true);
        username = bjDialog.getUser();
        pw = bjDialog.getPw();
        
        try {
          //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kamra?serverTimezone=UTC&useSSL=false", "root", "1234");                            
            conn = DriverManager.getConnection("jdbc:mysql://" + hostname + ":" + port + "/" + db + "?serverTimezone="+ serverTimezone + 
                    "&useSSL=" + useSSL, username, pw);  
            //JOptionPane.showMessageDialog(rootPane, "Adatbáziskapcsolat létrejött!", "Sikeres kapcsolódás", JOptionPane.INFORMATION_MESSAGE);
            kapcsolatTxt = "Adatbáziskapcsolat aktív";
        } catch (SQLException e) {
            kapcsolatTxt = e.getMessage();
            JOptionPane.showMessageDialog(rootPane, e.getMessage() , "Hiba történt az adatbáziskapcsolatban!", JOptionPane.ERROR_MESSAGE); 
            System.exit(0);
        } 
    }
    
    public static boolean zar() {
        try {
            conn.close();
                return true;
            } catch (SQLException e) {
                
                return false;
            } 
    }
}
