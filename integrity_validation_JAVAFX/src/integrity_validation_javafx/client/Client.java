/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrity_validation_javafx.client;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Upendra
 */
public class Client 
{
    private final SimpleStringProperty name;
    private final SimpleStringProperty address;
    private final SimpleStringProperty username;
    private final SimpleStringProperty dob;
    private final SimpleStringProperty mob_num;
    private final SimpleStringProperty email;
    private final SimpleStringProperty key;
    private final SimpleStringProperty cfor;
    
    
    public Client()
    {
        super();
        this.username = new SimpleStringProperty();
        this.name = new SimpleStringProperty();
        this.dob = new SimpleStringProperty();
        this.address = new SimpleStringProperty();
        this.mob_num = new SimpleStringProperty();
        this.email = new SimpleStringProperty();
        this.key = new SimpleStringProperty();
        this.cfor = new SimpleStringProperty();
    }
    
    public String getname()
    {
        return name.get();
    }
    
    public void setname(String nname)
    {
        this.name.set(nname);
    }
    
    public SimpleStringProperty getRname()
    {
        return name;
    }
    
    public String getusername()
    {
        return username.get();
    }
    
    public void setusername(String nname)
    {
        this.username.set(nname);
    }
    
    public SimpleStringProperty getRusername()
    {
        return username;
    }
    
    public String getdob()
    {
        return dob.get();
    }
    
    public void setdob(String nname)
    {
        this.dob.set(nname);
    }
    
    public SimpleStringProperty getRdob()
    {
        return dob;
    }
    
    public String getaddress()
    {
        return address.get();
    }
    
    public void setaddress(String nname)
    {
        this.address.set(nname);
    }
    
    public SimpleStringProperty getRaddress()
    {
        return address;
    }
    
    public String getemail()
    {
        return email.get();
    }
    
    public void setemail(String nname)
    {
        this.email.set(nname);
    }
    
    public SimpleStringProperty getRemail()
    {
        return email;
    }
    
    public String getmob_num()
    {
        return mob_num.get();
    }
    
    public void setmob_num(String nname)
    {
        this.mob_num.set(nname);
    }
    
    public SimpleStringProperty getRmob_num()
    {
        return mob_num;
    }
    
    public String getkey()
    {
        return key.get();
    }
    
    public void setkey(String nname)
    {
        this.key.set(nname);
    }
    
    public SimpleStringProperty getRkey()
    {
        return key;
    }
    
     public String getcfor()
    {
        return cfor.get();
    }
    
    public void setcfor(String nname)
    {
        this.cfor.set(nname);
    }
    
    public SimpleStringProperty getRcfor()
    {
        return cfor;
    }
}
