/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package integrityvalidatordbinsertor;
import java.io.*;

public class IntegrityValidatorDBInsertor 
{
    public static void main(String[] args) 
    {
        
        String bankPath = "D:\\INTERNSHIP\\JAVA Project 2\\IntegrityValidatorDBInsertor\\src\\bankdb1.xls";
        String uidPath = "D:\\INTERNSHIP\\JAVA Project 2\\IntegrityValidatorDBInsertor\\src\\UIDdb1.xls";
        String telePath = "D:\\INTERNSHIP\\JAVA Project 2\\IntegrityValidatorDBInsertor\\src\\telecom1.xls";
        
        //BankDBHelper.helpdb(bankPath);
        //TeleDBHelper.helpdb(telePath);
        UIDDBHelper.helpdb(uidPath);
    }

}
