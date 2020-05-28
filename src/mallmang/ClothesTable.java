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
public class ClothesTable {
    
   String clothno,catid,clothsize,description ;
   double price;
   int quantity=0;
   
    public ClothesTable(String clothno, String catid,String clothsize,String description, double price, int quantity) 
    {
        this.clothno = clothno;
        this.catid = catid;
        this.clothsize=clothsize;
        this.description=description;
        this.price= price;
        this.quantity = quantity;
    }
   
   public String getClothno()
    {
        return clothno;
    }

    public void setClothno(String clothno)
    {
        this.clothno = clothno;
    }

    public String getCatid() 
    {
        return catid;
    }

    public void setCatid(String catid) 
    {
        this.catid = catid;
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
    
    public void setClothsize(String clothsize) 
    {
        this.clothsize = clothsize;
    }

    public String getClothsize()
    {
        return clothsize;
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
