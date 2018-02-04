/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrityvalidatordbinsertor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Upendra
 */
public class TeleDBInsertor 
{
    public void insert(ArrayList a)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/integrity_validation","root","root");
            Statement st = conn.createStatement();
            //name, address, mob_num, document, type, plan, active_date, email, gender, dob
            String mob_num = (String) a.get(0);
            String name = (String) a.get(1);
            String dob = (String) a.get(2);
            String address = (String) a.get(3);
            String document = (String) a.get(4);
            String type = (String) a.get(5);
            String plan = (String) a.get(6);
            String active_date = (String) a.get(7);
            String email = (String) a.get(8);
            String gender = (String) a.get(9);
            
            
            //System.out.println(account_no+"\n"+cust_name+"\n"+dob+"\n"+address+"\n"+branch+"\n"+MICR+"\n"+IFSC+"\n"+mob_num+"\n"+email+"\n"+ balance+"\n"+ acc_type +"\n"+card_type +"\n"+card_num +"\n"+gender);
            String query = "Insert into telecominfo values('"+mob_num+"','"+name+"','"+dob+"','"+address+"','"+document+"','"+type+"','"+plan+"','"+active_date+"','"+email+"','"+gender+"')";
            int x = st.executeUpdate(query);
            if(x>0)
            {
                System.out.println("success");
            }
            else
                System.out.println("Data is not inserted");
            
        }
        catch(Exception e)
        {
            System.out.println("Exception in TeleDBInsertor"+e);
            
        }  
    }
    
}
