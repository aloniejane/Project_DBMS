/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mallmang;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import static mallmang.SignupwinController.userid;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class ViewController implements Initializable {

    @FXML
    private Label back;
    @FXML
    private ChoiceBox choice;
    
    int department;
    
    
     ObservableList<String> Dept = FXCollections.observableArrayList("User Details","All Items","Clothes","Electronics");
    @FXML
    public TableView<Tableview> table;
    @FXML
    public TableColumn<Tableview,String> Col1;
    @FXML
    public TableColumn<Tableview,String> Col2;
    @FXML
    public TableColumn<Tableview,Double> Col3;
    @FXML
    public  TableColumn<Tableview,Integer> Col4;
    
    ObservableList<Tableview> obs=FXCollections.observableArrayList();
    @FXML
    private TableColumn<ClothesTable, String> Col_clothno;
    @FXML
    private TableColumn<ClothesTable, String> Col_clothsize;
    @FXML
    private TableColumn<ClothesTable, String> Col_catid;
    @FXML
    private TableColumn<ClothesTable, Integer> Col_quantity;
    @FXML
    private TableColumn<ClothesTable, Double> Col_price;
    @FXML
    private TableColumn<ClothesTable, String> descrip;
    @FXML
    public TableView<ClothesTable> table_cloth;
    ObservableList<ClothesTable> obsclothes=FXCollections.observableArrayList();
    
    @FXML
    private TableView<User_table> table_user;
    @FXML
    private TableColumn<User_table,Integer> col_userid;
    @FXML
    private TableColumn<User_table,String> col_username;
    @FXML
    private TableColumn<User_table,Long> col_phoneno;
    @FXML
    private TableColumn<User_table,Double> col_ucost;
    ObservableList<User_table> obsuser=FXCollections.observableArrayList();
    
    @FXML
    private TableView<Electronicstable> table_electronics;
    @FXML
    private TableColumn<Electronicstable, String> col_eno;
    @FXML
    private TableColumn<Electronicstable, String> col_type;
    @FXML
    private TableColumn<Electronicstable, String> col_model;
    @FXML
    private TableColumn<Electronicstable, String> col_brand;
    @FXML
    private TableColumn<Electronicstable, Double> col_price1;
    @FXML
    private TableColumn<Electronicstable, Integer> col_Quantity1;
    ObservableList<Electronicstable> obsele=FXCollections.observableArrayList();
    @FXML
    private Label choicelabel;
    
    
  

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       

        choice.setItems(Dept);
        choicelabel.setText("Select Here...");
        
  
        changechoice();
        


        // TODO
    }    

    @FXML
    private void handleback(MouseEvent event) throws IOException {
        Stage stage = (Stage) back.getScene().getWindow();
        stage.hide();
        
        
        Parent root = FXMLLoader.load(getClass().getResource("AdminLog.fxml"));
        Stage stage1 = new Stage();
        stage1.initStyle(StageStyle.UNDECORATED);
        Scene scene1 = new Scene(root);
        stage1.setScene(scene1);
        stage1.show();
    }

    @FXML
    private void handleclose(MouseEvent event) {
        System.exit(0);
    }

    public void changechoice()
    {
      choice.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
      @Override
      public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) 
      {
          
            department =newValue.intValue();
            
        
            
        
            
        
        
        if (department==1)
        {
            choicelabel.setText(null);
           table.setVisible(true);
           table_cloth.setVisible(false);
           table_user.setVisible(false);
           table_electronics.setVisible(false);
                Col1.setText("Item No");
                Col2.setText("Description");
                Col3.setText("Price");
                Col4.setText("Quantity");
                
                Col1.setCellValueFactory(new PropertyValueFactory<Tableview,String>("Itemno"));
                Col2.setCellValueFactory(new PropertyValueFactory<Tableview,String>("Description"));
                Col3.setCellValueFactory(new PropertyValueFactory<Tableview,Double>("Price"));
                Col4.setCellValueFactory(new PropertyValueFactory<Tableview,Integer>("Quantity"));
                
                String itemno=null;
                double price=0.0;
                int quantity=0;
                        
                String mcatid=" ";
                String wcatid=" ";
                        
                String size=null;
                String description=null;
                        
                String type=null;
                String model=null;
                String brand=null;
                
                String thno=null;
                String moviename=null;
                String time=null;
                  
                        
                
                //table.setColumnResizePolicy(TableView.DEFAULT_SORT_POLICY);
                 try 
               {    
                   obs.clear();
                    Class.forName("oracle.jdbc.OracleDriver");
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","DBMSPROJECT","mall@12");
                        Statement stat=con.createStatement();
                        String query1="select * from CLOTHES";
                        
                 
                       
                        ResultSet rs=stat.executeQuery(query1);
                        
                        while(rs.next())
                        {
                            itemno=rs.getString("CLOTHNO");
                            size=rs.getString("CLOTHSIZE");
                            quantity=rs.getInt("QUANTITY");
                            
                            
                            wcatid=rs.getString("WCATID");
                            mcatid=rs.getString("MCATID");
                            
                            
                            if(wcatid.equals("W00"))
                            {
                                String query3="select COST from MEN where CATID=?"; 
                                PreparedStatement prep=con.prepareStatement(query3);
                   
                                prep.setString(1,mcatid);
                
                                ResultSet rs1=prep.executeQuery();
                                if(rs1.next())
                                {
                                    price=rs1.getFloat("COST");
                                }
                                description=size.concat(','+mcatid);
                            }
                            if(mcatid.equals("M00"))
                            {
                                String query3="select COST from WOMEN where CATID=?"; 
                                PreparedStatement prep=con.prepareStatement(query3);
                   
                                prep.setString(1,wcatid);
                
                                ResultSet rs1=prep.executeQuery();
                                if(rs1.next())
                                {
                                    price=rs1.getFloat("COST");
                                }
                              
                                description=size.concat(','+wcatid);
                            }
                            obs.add(new Tableview(itemno,description,price,quantity));
                         
                        }
                        
                        
                        String query2="select * from ELECTRONICS";
                        ResultSet rs1=stat.executeQuery(query2);
                        
                        while(rs1.next())
                        {
                            itemno=rs1.getString("ENO");
                            type=rs1.getString("TYPE");
                            model=rs1.getString("MODEL");
                            brand=rs1.getString("BRAND");
                  
                            
                            price=rs1.getDouble("EPRICE");
                            quantity=rs1.getInt("QUANTITY");
                         
                            description=type.concat(" , "+type+" ,"+model+" , "+brand);
                            obs.add(new Tableview(itemno,description,price,quantity));
                         
                        }
                        
                        
                        table.setItems(obs);
                        table.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
                        table.getSelectionModel().setCellSelectionEnabled(true);
         
                }//try
            catch (ClassNotFoundException | SQLException ex)
            {
                Logger.getLogger(ViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }//if 
        
        
        if(department==2)
        {   
            choicelabel.setText(null);
            table.setVisible(false);
            table_cloth.setVisible(true);
            table_user.setVisible(false);
            table_electronics.setVisible(false);
            String clothno=null;
            String catid=" ";           
            String clothsize=null;
            double price=0.0;
            int quantity=0;
            String des=null;
            
            String wcatid=" "; 
            String mcatid=" "; 
            
            Col_clothno.setCellValueFactory(new PropertyValueFactory<ClothesTable,String>("Clothno"));
            Col_clothsize.setCellValueFactory(new PropertyValueFactory<ClothesTable,String>("Clothsize"));
            Col_catid.setCellValueFactory(new PropertyValueFactory<ClothesTable,String>("Catid"));
            descrip.setCellValueFactory(new PropertyValueFactory<ClothesTable,String>("Description"));
            Col_price.setCellValueFactory(new PropertyValueFactory<ClothesTable,Double>("Price"));
            Col_quantity.setCellValueFactory(new PropertyValueFactory<ClothesTable,Integer>("Quantity"));
            
               
             try {
                 obsclothes.clear();
                 Class.forName("oracle.jdbc.OracleDriver");
                 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","DBMSPROJECT","mall@12");
                 Statement stat=con.createStatement();
                 String query1="select * from CLOTHES";
                 
                 
                 
                 ResultSet rs=stat.executeQuery(query1);
                 
                 while(rs.next())
                 {
                     clothno=rs.getString("CLOTHNO");
                     clothsize=rs.getString("CLOTHSIZE");
                     quantity=rs.getInt("QUANTITY");
                     
                     
                     wcatid=rs.getString("WCATID");
                     mcatid=rs.getString("MCATID");
                     
                     
                     if(wcatid.equals("W00"))
                     {
                         String query3="select DESCRIPTION,COST from MEN where CATID=?";
                         PreparedStatement prep=con.prepareStatement(query3);
                         
                         prep.setString(1,mcatid);
                         
                         ResultSet rs1=prep.executeQuery();
                         if(rs1.next())
                         {
                             des=rs1.getString("DESCRIPTION");
                             price=rs1.getFloat("COST");
                         }
                         
                         catid=mcatid;
                         
                     }
                     if(mcatid.equals("M00"))
                     {
                         String query3="select DESCRIPTION,COST from WOMEN where CATID=?";
                         PreparedStatement prep=con.prepareStatement(query3);
                         
                         prep.setString(1,wcatid);
                         
                         ResultSet rs1=prep.executeQuery();
                         if(rs1.next())
                         {
                             des=rs1.getString("DESCRIPTION");
                             price=rs1.getFloat("COST");
                         }
                         catid=wcatid;
                         
                     }
                     obsclothes.add(new ClothesTable(clothno,catid,clothsize,des,price,quantity));   
                 }
                 table_cloth.setItems(obsclothes);
                 table_cloth.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
                 table_cloth.getSelectionModel().setCellSelectionEnabled(true);
             }
             catch (ClassNotFoundException | SQLException ex)
             {
                 Logger.getLogger(ViewController.class.getName()).log(Level.SEVERE, null, ex);
             }
            }
        
        
        if(department==0)
        {
            choicelabel.setText(null);
            table.setVisible(false);
            table_cloth.setVisible(false);
            table_user.setVisible(true);
            table_electronics.setVisible(false);
            
            String uname=null;
            int uid=0;
             long uphone=0;
            double price=0.0;
            
            
            col_userid.setCellValueFactory(new PropertyValueFactory<User_table,Integer>("Userid"));
            col_username.setCellValueFactory(new PropertyValueFactory<User_table,String>("Username"));
            col_phoneno.setCellValueFactory(new PropertyValueFactory<User_table,Long>("Phoneno"));
            col_ucost.setCellValueFactory(new PropertyValueFactory<User_table,Double>("Totcost"));

               
             try {
                 obsuser.clear();
                 Class.forName("oracle.jdbc.OracleDriver");
                 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","DBMSPROJECT","mall@12");
                 Statement stat=con.createStatement();
                 String query1="select * from USERLOGIN";
            
                 ResultSet rs=stat.executeQuery(query1);
                 
                 while(rs.next())
                 {
                     uid=rs.getInt("USERID");
                     uname=rs.getString("UNAME");
                     uphone=rs.getLong("PHONENO");
                     price=rs.getDouble("TOTALCOST");
                
                    
                     obsuser.add(new User_table(uid,uname,uphone,price));   
                 }
                 table_user.setItems(obsuser);
                 table_user.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
                 table_user.getSelectionModel().setCellSelectionEnabled(true);
             }
             catch (ClassNotFoundException | SQLException ex)
             {
                 Logger.getLogger(ViewController.class.getName()).log(Level.SEVERE, null, ex);
             }
            }
        
        if(department==3)
        {
            choicelabel.setText(null);
            choicelabel.setText(null);
            table.setVisible(false);
            table_cloth.setVisible(false);
            table_user.setVisible(false);
            table_electronics.setVisible(true);
            
            String eno=null;
            String type=null;           
            String model=null;
            String brand=null; 
            double price=0.0;
            int quantity=0;
            
            
            
            col_eno.setCellValueFactory(new PropertyValueFactory< Electronicstable,String>("Eno"));
            col_type.setCellValueFactory(new PropertyValueFactory<Electronicstable,String>("Type"));
            col_model.setCellValueFactory(new PropertyValueFactory<Electronicstable,String>("Model"));
            col_brand.setCellValueFactory(new PropertyValueFactory<Electronicstable,String>("Brand"));
            col_price1.setCellValueFactory(new PropertyValueFactory<Electronicstable,Double>("Price"));
            col_Quantity1.setCellValueFactory(new PropertyValueFactory<Electronicstable,Integer>("Quantity"));
            
               
             try {
                 obsele.clear();
                 Class.forName("oracle.jdbc.OracleDriver");
                 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","DBMSPROJECT","mall@12");
                 Statement stat=con.createStatement();
                 String query1="select * from ELECTRONICS";
                 
                 
                 
                 ResultSet rs=stat.executeQuery(query1);
                 
                 while(rs.next())
                 {
                     eno=rs.getString("ENO");
                     type=rs.getString("TYPE");
                     model=rs.getString("MODEL");
                     brand=rs.getString("brand");
                     quantity=rs.getInt("QUANTITY");
                     price=rs.getFloat("EPRICE");
                         
                     obsele.add(new Electronicstable(eno, type, model, brand, price, quantity));   
                 }
                table_electronics.setItems(obsele);
                 table_electronics .getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
                 table_electronics.getSelectionModel().setCellSelectionEnabled(true);
             }
             catch (ClassNotFoundException | SQLException ex)
             {
                 Logger.getLogger(ViewController.class.getName()).log(Level.SEVERE, null, ex);
             }
            }
            
        }
        
    }
 );
}//changechoice 
              
  
}

