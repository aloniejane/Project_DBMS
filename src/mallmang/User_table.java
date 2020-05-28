/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mallmang;

/**
 *
 * @author USER
 */
public class User_table {
    
   String username;
   int userid;
   long phoneno;
   double totcost;
   
    public User_table(int userid, String username,long phoneno, double totcost) 
    {
        this.username = username;
        this.userid= userid;
        this.phoneno=phoneno;
        this.totcost = totcost;
    }
   
   public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username=username;
    }

    public int getUserid() 
    {
        return userid;
    }

    public void setUserid(int userid) 
    {
        this.userid= userid;
    }

    public long getPhoneno() 
    {
        return phoneno;
    }

    public void setPhoneno(long phoneno) 
    {
        this.phoneno = phoneno;
    }
    
     public double getTotcost()
    {
        return totcost;
    }

    public void setTotcost(double totcost)
    {
        this.totcost = totcost;
    }
   
   
    
}
