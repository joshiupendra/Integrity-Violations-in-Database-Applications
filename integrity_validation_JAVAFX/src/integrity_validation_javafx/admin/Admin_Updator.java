/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrity_validation_javafx.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author Upendra
 */
public class Admin_Updator 
{
    public boolean update(String un,String pw)
    {
        boolean flag = true;
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/integrity_validation","root","root");
            Statement st = conn.createStatement();
            
            //username, password, name, addr, dob, mob_num, email
            String id = "1";
            String query = "update admininfo set password='"+pw+"',username='"+un+"' where id='"+id+"'";
            int x = st.executeUpdate(query);
            flag = x>0;
            
            
        }
        catch(Exception e)
        {
            System.out.println("Exception in Admin_Updator"+e);
            flag = false;
        }        
                
        
        return flag;
    }
}
