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
public class BankDBInsertor 
{
    public void insert(ArrayList a)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/integrity_validation","root","root");
            Statement st = conn.createStatement();
            //account_no, cust_name, dob, address, branch, MICR, IFSC, mob_num, email, balance, acc_type, card_type, card_num, gender
            String account_no = (String) a.get(0);
            String cust_name = (String) a.get(1);
            String dob = (String) a.get(2);
            
            String address = (String) a.get(3);
            
            String branch = (String) a.get(4);
            String MICR = (String) a.get(5);
            String IFSC = (String) a.get(6);
            String mob_num = (String) a.get(7);
            String email = (String) a.get(8);
            String balance = (String) a.get(9);
            String acc_type = (String) a.get(10);
            String card_type = (String) a.get(11);
            String card_num = (String) a.get(12);
            String gender = (String) a.get(13);
            
            //System.out.println(account_no+"\n"+cust_name+"\n"+dob+"\n"+address+"\n"+branch+"\n"+MICR+"\n"+IFSC+"\n"+mob_num+"\n"+email+"\n"+ balance+"\n"+ acc_type +"\n"+card_type +"\n"+card_num +"\n"+gender);
            String query = "Insert into bankinfo values('"+account_no+"','"+cust_name+"','"+dob+"','"+address+"','"+branch+"','"+MICR+"','"+IFSC+"','"+mob_num+"','"+email+"','"+balance+"','"+acc_type+"','"+card_type+"','"+card_num+"','"+gender+"')";
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
            System.out.println("Exception in BankDBInsertor"+e);
            
        }  
    }
}
