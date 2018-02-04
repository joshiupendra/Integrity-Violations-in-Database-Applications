/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrityvalidatordbinsertor;

import java.util.ArrayList;

/**
 *
 * @author Upendra
 */
public class TeleDBHelper 
{
    public static void helpdb(String path)
    {
        ArrayList data = new ArrayList();
        ExcelReader er = new ExcelReader();
        data = er.getExcelData(path);
        
        for(int i=0;i<data.size();i++)
        {
            ArrayList x = (ArrayList) data.get(i);
            TeleDBInsertor bd = new TeleDBInsertor();
            bd.insert(x);
        }
    }
}
