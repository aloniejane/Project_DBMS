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
public class Orders_table 
{
   String userid,id,description ;
   double cost;
   int quantity=0;
   
    public Orders_table(String userid, String id,String description, double cost, int quantity) 
    {
        this.userid = userid;
        this.id = id;
        this.description=description;
        this.cost= cost;
        this.quantity = quantity;
    }
   
   public String getUserid()
    {
        return userid;
    }

    public void setUserid(String userid)
    {
        this.userid = userid;
    }

    public String getId() 
    {
        return id;
    }

    public void setId(String id) 
    {
        this.id = id;
    }

    public double getCost()
    {
        return cost;
    }

    public void setCost(double cost)
    {
        this.cost = cost;
    }

    public int getQuantity() 
    {
        return quantity;
    }

    public void setQuantity(int quantity) 
    {
        this.quantity = quantity;
    }
    
     public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }
    
}
