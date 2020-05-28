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
public class Tableview {
    
   String itemno,description;
   double price;
   int quantity=0;
   
    public Tableview(String itemno, String description, double price, int quantity) 
    {
        this.itemno = itemno;
        this.description = description;
        this.price= price;
        this.quantity = quantity;
    }
   
   public String getItemno()
    {
        return itemno;
    }

    public void setItemno(String itemno)
    {
        this.itemno = itemno;
    }

    public String getDescription() 
    {
        return description;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public int getQuantity() 
    {
        return quantity;
    }

    public void setQuantity(int quantity) 
    {
        this.quantity = quantity;
    }
   
   
}
