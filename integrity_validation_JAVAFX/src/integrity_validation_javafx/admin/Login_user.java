/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package integrity_validation_javafx.admin;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.sql.DriverManager;
import java.sql.*;
import javax.swing.JOptionPane;


public class Login_user 
{
    public boolean getlogin(String un,String pw)
    {
        boolean flag = true;
        try 
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/integrity_validation","root","root");
            Statement st = conn.createStatement();
            
            String query = "select * from admininfo where username='"+un+"'";
            ResultSet rs = st.executeQuery(query);
            
            if(rs.next())
            {
               String dbun = rs.getString(2);
                String dbpw = rs.getString(3);
                System.out.println("un\t"+dbun+"\npw\t"+dbpw);
                if(dbun.equals(un) && dbpw.equals(pw))
                {
                    flag = true;
                    Edit_AdminController.un = un;
                }
                else
                    flag = false;
            }
            
            
        } 
        catch (HeadlessException | ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) 
        {
            System.out.println("Exception in Login"+e);
            flag = false;
        }
        
        
        return flag;
    }
}
