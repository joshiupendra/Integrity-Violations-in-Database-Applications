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
public class Client_Inserter 
{
    public boolean insert(String nam,String addr,String pwd,String db,String em,String mn,String un,String cf,String key)
    {
        boolean flag = true;
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/integrity_validation","root","root");
            Statement st = conn.createStatement();
            //username, name, address, dob, client_for, email, mob_num, password, key
            String query = "Insert into clientinfo values('"+un+"','"+nam+"','"+addr+"','"+db+"','"+cf+"','"+em+"','"+mn+"','"+pwd+"','"+key+"')";
            int x = st.executeUpdate(query);
            flag = x>0;
            
            
        }
        catch(Exception e)
        {
            System.out.println("Exception in Client_Inserter"+e);
            flag = false;
        }        
        
        return flag;
    }
}
