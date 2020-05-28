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
public class Electronicstable {
   String eno,type,model,brand ;
   double price;
   int quantity=0;
   
    public Electronicstable(String eno, String type,String model,String brand, double price, int quantity) 
    {
        this.eno = eno;
        this.type= type;
        this.model=model;
        this.brand=brand;
        this.price= price;
        this.quantity = quantity;
    }
   
   public String getEno()
    {
        return eno;
    }

    public void setEno(String eno)
    {
        this.eno = eno;
    }

    public String getType() 
    {
        return type;
    }

    public void setType(String type) 
    {
        this.type= type;
    }

    public double getPrice()
    {
        return price;
    }
    
      public void setModel(String model) 
    {
        this.model= model;
    }

    public String getModel()
    {
        return model;
    }
    
      public void setBrand(String brand) 
    {
        this.brand= brand;
    }

    public String getBrand()
    {
        return brand;
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
