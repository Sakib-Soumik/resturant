import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author SOUMIK
 */
//table showing code,just change the table name
//tablename.setModel(DbUtils.resultSetToTableModel (Db.selectquery(query)));
//
public class Db {

    public static ResultSet selectquery(String query) {
        ResultSet rs=null;
        try {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=ProjectDB;user=sa;password=123456";
            Connection con = DriverManager.getConnection(url);
           
            PreparedStatement pst = con.prepareStatement(query);
            
             rs = pst.executeQuery();
            
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, "SELECT QUERY error");
        }
        return rs;
    }
    public static void updatequery(String query) {
        try {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://localhost:1433;databaseName=ProjectDB;user=sa;password=123456";
            Connection con = DriverManager.getConnection(url);
           
            PreparedStatement pst = con.prepareStatement(query);
            
             pst.executeUpdate();
            
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    } 
}
