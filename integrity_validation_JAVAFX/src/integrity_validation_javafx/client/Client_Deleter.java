/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrity_validation_javafx.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author Upendra
 */
public class Client_Deleter 
{
    public boolean del(String user)
    {
        boolean flag = true;
        
        try 
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/integrity_validation","root","root");
            Statement st = conn.createStatement();
            
            String query = "delete from clientinfo where username='"+user+"' ";
            int x = st.executeUpdate(query);
            flag = x>0;
        } 
        catch (Exception e) 
        {
            System.out.println("Exception in Client_Deleter"+e);
            flag = false;
        }
        
        return flag;
    }
}
