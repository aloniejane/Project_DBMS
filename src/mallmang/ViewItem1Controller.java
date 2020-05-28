/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mallmang;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Bryan caldeira
 */
public class ViewItem1Controller implements Initializable {

    @FXML
    private ImageView iv;
    
    
    
    public static Image ige;
    public static String ds,ct;

    String catid,img,desc,siz,col="blue",cloth_no;
    double cst;
    int qty=1; //selected quantity
    
    int tqty; //table quantity
    
    int fqty; //final quantity
    
    
    int ver;
    
    


    /**
     * Initializes the controller class.
     * @param img
     */
    
    public static void Display(Image img,String des,String cost)
    {
        ige=img;
        ds=des;
        ct=cost;
        
      
    }
    
    
    ObservableList list=FXCollections.observableArrayList(); //Choice box Observable List
    
    
    @FXML
    private Label bk;
    @FXML
    private Button add;
    @FXML
    private Label des;
    @FXML
    private Label cost;
    @FXML
    public AnchorPane bg;
    @FXML
    private Label small;
    @FXML
    private Label medium;
    @FXML
    private Label large;
    @FXML
    private ChoiceBox<?> quantity;
    @FXML
    private Label qtytxt;
    
    
    
    @FXML
    public void handleback(MouseEvent event)  
    {
        Stage stage = (Stage) bk.getScene().getWindow();
        stage.hide();
        
    }
    
    
     public void Choice()
   {
       list.removeAll(list);
       final String st[]={"1","2","3","4","5"};
       list.addAll(st);
       quantity.getItems().addAll(list);
       
       quantity.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>(){
            @Override
            public void changed(ObservableValue ov,Number value,Number new_value)
                {
                    int val=new_value.intValue();
                    qty=val=val+1;
                    qtytxt.setText(""+val);

                    
                      
                }});
   }
    
    
    
    
    
    ClothesController cc=new ClothesController();
    
    public void Mode()
    {
        int theme=ClothesController.thememode;
        if(theme==0)
        {
            bg.setStyle("-fx-background-color:#6E7276");
            des.setStyle("-fx-text-fill:#ffffff");
            cost.setStyle("-fx-text-fill:#ffffff");
            bk.setStyle("-fx-text-fill:#ffffff");
        }
        else if(theme==1)
        {
            bg.setStyle("-fx-background-color:#ffffff");
        }
        else
        {
            bg.setStyle("-fx-background-color:#ffffff");
        }
    }
    
    
    @FXML
    public void SmallSize(MouseEvent event)
    {
        small.setStyle("-fx-background-color:RED");
        medium.setStyle("-fx-background-color:WHITE");
        large.setStyle("-fx-background-color:WHITE");
        siz="S";
    }
    @FXML
    public void MediumSize(MouseEvent event)
    {
        medium.setStyle("-fx-background-color:RED");
        small.setStyle("-fx-background-color:WHITE");
        large.setStyle("-fx-background-color:WHITE");
        siz="M";
    }
    @FXML
    public void LargeSize(MouseEvent event)
    {
        large.setStyle("-fx-background-color:RED");
        medium.setStyle("-fx-background-color:WHITE");
        small.setStyle("-fx-background-color:WHITE");
        siz="L";
    }
    
    
    
    
    


    @FXML
    public void Add(MouseEvent event) throws IOException
    {
        if(siz!=null)
        {  
        
        
        try
        {

                    Class.forName("oracle.jdbc.OracleDriver");
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","DBMSPROJECT","mall@12");
                    java.sql.Statement stat=con.createStatement();
                    java.sql.Statement stat1=con.createStatement();
           
             
                   
                    String query="select catid,image,description,cost from women where description= '"+ds+"'";
                    
                    System.out.println(query);


                    ResultSet rs = stat.executeQuery(query);
                    
                    
                    while (rs.next())
                    {
                        
                        catid = rs.getString("CATID");
                        img = rs.getString("IMAGE");
                        desc = rs.getString("DESCRIPTION");
                        cst=Integer.parseInt(rs.getString("COST"));
                        
                    }
                    String query1="select clothno from clothes where wcatid = '"+catid+"'and clothsize = '"+siz+"'";
                    
                    ResultSet rs1 = stat1.executeQuery(query1);
                    
                    while(rs1.next())
                    {
                        cloth_no = rs1.getString("CLOTHNO");
                        
                    }
                    
                    
                    stat.close();
                    con.close();
        }
        catch (ClassNotFoundException|SQLException ex) 
        {
                    Logger.getLogger(ClothesController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
         try
        {

                    Class.forName("oracle.jdbc.OracleDriver");
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","DBMSPROJECT","mall@12");
                    java.sql.Statement stat=con.createStatement();

           
             
                   
                    String query="select quantity from clothes where clothno= '"+cloth_no+"' and clothsize= '"+siz+"' ";
                   System.out.println("123 "+query);
                    ResultSet rs = stat.executeQuery(query);
                    
                    
                    while (rs.next())
                    {
                        
                        tqty = rs.getInt("QUANTITY");
                        
                        
                    }
                    System.out.println(tqty+" "+siz);
                    stat.close();
                    con.close();
        }
        catch (ClassNotFoundException|SQLException ex) 
        {
                    Logger.getLogger(ClothesController.class.getName()).log(Level.SEVERE, null, ex);
        } 
         
         
         
         fqty=tqty-qty;
        
        
        
        
        
        
        
        
        
        
        if(fqty>=0)
        {
             ver=0;
         try
        {

                    Class.forName("oracle.jdbc.OracleDriver");
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","DBMSPROJECT","mall@12");
                    java.sql.Statement stat1=con.createStatement();
                    java.sql.Statement stat=con.createStatement();
                    
                    String query="select id,clsize from cart where id = '"+cloth_no+"' and clsize= '"+siz+"' ";
                    
                    System.out.println("cart "+query);
                    ResultSet rs = stat.executeQuery(query);
                    if(!rs.next())
                    {
                        String query1="insert into CART (ID,IMAGE,DESCRIPTION,CLSIZE,COLOUR,QUANTITY,COST) values('"+cloth_no+"','"+img+"','"+desc+"','"+siz+"','"+col+"',"+qty+","+cst+")";
                        System.out.println(query1);


                        stat1.executeUpdate(query1);
                        ver=1;
                   
                        stat1.close();
                        con.close();
                        Stage stage = (Stage) add.getScene().getWindow();
                        stage.hide();
                        
                    }

                        
                        

             
                   
                    
        }
        catch (ClassNotFoundException|SQLException ex) 
        {
                    Logger.getLogger(ClothesController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        
        }
        
        
        if(tqty==0)
            {
                AlertController ac = new AlertController();
                ac.txt="Item Out Of Stock !";
            
            
                Parent root = FXMLLoader.load(getClass().getResource("Alert.fxml"));
                Stage stage1 = new Stage();
                stage1.initStyle(StageStyle.UNDECORATED);
                Scene scene1 = new Scene(root);
                stage1.setScene(scene1);
                stage1.show();
                
            }
        
        
        else if(tqty!=0 && fqty<0)
        {
             AlertController ac = new AlertController();
            AlertController.txt="Only "+tqty+" No. Available !";
            
            
            Parent root = FXMLLoader.load(getClass().getResource("Alert.fxml"));
            Stage stage1 = new Stage();
            stage1.initStyle(StageStyle.UNDECORATED);
            Scene scene1 = new Scene(root);
            stage1.setScene(scene1);
            stage1.show();
        }
        
        
        
        else
        {
            
            if(ver==0)
            {
            AlertController ac = new AlertController();
            AlertController.txt="Present in cart Inc Qty !";
                        
            Parent root = FXMLLoader.load(getClass().getResource("Alert.fxml"));
            Stage stage1 = new Stage();
            stage1.initStyle(StageStyle.UNDECORATED);
            Scene scene1 = new Scene(root);
            stage1.setScene(scene1);
            stage1.show();
            }

            
        }
        
        
        }
        else
        {
            AlertController ac = new AlertController();
            ac.txt="Select A Size";
            
            
            Parent root = FXMLLoader.load(getClass().getResource("Alert.fxml"));
            Stage stage1 = new Stage();
            stage1.initStyle(StageStyle.UNDECORATED);
            Scene scene1 = new Scene(root);
            stage1.setScene(scene1);
            stage1.show();
            
            
        }
        
        
    }
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
  
        iv.setImage(ige);
        des.setText(ds);
        cost.setText(ct);
        
        Choice();
        
        
        
        
        
         
        
        
        
        
        
        Mode();


    
    
    
        // TODO
    }    

    
}
