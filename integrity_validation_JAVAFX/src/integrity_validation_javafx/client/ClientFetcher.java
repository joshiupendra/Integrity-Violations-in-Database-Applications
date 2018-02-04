/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrity_validation_javafx.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Upendra
 */
public class ClientFetcher 
{
    private static ObservableList<Client> getAllObjects(ResultSet rs) throws ClassNotFoundException, SQLException
    {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        ObservableList<Client> allList = FXCollections.observableArrayList();
        try 
        {
            
        
            while(rs.next())
            {
                //username, name, address, dob, client_for, email, mob_num, password, key
                Client rec = new Client();
                //rec.username(rs.getString(1));
                //rec.name(rs.getString(2));
                rec.setusername(rs.getString(1));
                rec.setname(rs.getString(2));
                rec.setaddress(rs.getString(3));
                rec.setdob(rs.getString(4));
                rec.setcfor(rs.getString(5));
                rec.setemail(rs.getString(6));
                rec.setmob_num(rs.getString(7));
                rec.setkey(rs.getString(9));
                allList.add(rec);
            }
        } 
        catch (Exception e) {
        }
        return allList;
    }
    
    public static ObservableList<Client> getallRecords() throws ClassNotFoundException, SQLException
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/integrity_validation","root","root");
            Statement st = conn.createStatement();
            
            String query = "select * from clientinfo";
            ResultSet rs = st.executeQuery(query);
            
            ObservableList<Client> allList = getAllObjects(rs);
            return allList;
            
        }
        catch(Exception e)
        {
            System.out.println("Exception in ClientFetcher\t"+e);
        }
        return null;
    }
    
    public static ObservableList<Client> getUIDRecords() throws ClassNotFoundException, SQLException
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/integrity_validation","root","root");
            Statement st = conn.createStatement();
            
            String x = "UID";
            String query = "select * from clientinfo where client_for='"+x+"'";
            ResultSet rs = st.executeQuery(query);
            
            ObservableList<Client> allList = getAllObjects(rs);
            return allList;
            
        }
        catch(Exception e)
        {
            System.out.println("Exception in ClientFetcher\t"+e);
        }
        return null;
    }
    
    public static ObservableList<Client> getBankRecords() throws ClassNotFoundException, SQLException
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/integrity_validation","root","root");
            Statement st = conn.createStatement();
            
            String x = "Bank";
            String query = "select * from clientinfo where client_for='"+x+"'";
            ResultSet rs = st.executeQuery(query);
            
            ObservableList<Client> allList = getAllObjects(rs);
            return allList;
            
        }
        catch(Exception e)
        {
            System.out.println("Exception in ClientFetcher\t"+e);
        }
        return null;
    }
    
    public static ObservableList<Client> getTelecomRecords() throws ClassNotFoundException, SQLException
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/integrity_validation","root","root");
            Statement st = conn.createStatement();
            
            String x = "Tele";
            String query = "select * from clientinfo where client_for='"+x+"'";
            ResultSet rs = st.executeQuery(query);
            
            ObservableList<Client> allList = getAllObjects(rs);
            return allList;
            
        }
        catch(Exception e)
        {
            System.out.println("Exception in ClientFetcher\t"+e);
        }
        return null;
    }
    
}
