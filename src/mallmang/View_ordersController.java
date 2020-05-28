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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class View_ordersController implements Initializable {

    @FXML
    private ImageView close;
    @FXML
    private Label back;
    
    ObservableList<Orders_table> obs=FXCollections.observableArrayList();
    @FXML
    private TableColumn<Orders_table, String> col_userid;
    @FXML
    private TableColumn<Orders_table, String> col_itemid;
    @FXML
    private TableColumn<Orders_table, String> col_des;
    @FXML
    private TableColumn<Orders_table, Integer> col_quan;
    @FXML
    private TableColumn<Orders_table, Double> col_cost;
    @FXML
    private TableView<Orders_table> o_table;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            
            String userid=null;
            String id=null;           
            String clsize=" ";
            String color=" ";
            double cost=0.0;
            int quantity=0;
            String des=null;
            String Descrip=null;
            
            
            col_userid.setCellValueFactory(new PropertyValueFactory<Orders_table,String>("Userid"));
            col_itemid.setCellValueFactory(new PropertyValueFactory<Orders_table,String>("Id"));
            col_des.setCellValueFactory(new PropertyValueFactory<Orders_table,String>("Description"));
            col_quan.setCellValueFactory(new PropertyValueFactory<Orders_table,Integer>("Quantity"));
            col_cost.setCellValueFactory(new PropertyValueFactory<Orders_table,Double>("Cost"));
            
            obs.clear();
            Class.forName("oracle.jdbc.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","DBMSPROJECT","mall@12");
            Statement stat=con.createStatement();
            String query1="select * from ORDERS";
            
            ResultSet rs=stat.executeQuery(query1);
                 
                 while(rs.next())
                 {
                     userid=rs.getString("USERID");
                     id=rs.getString("ID");
                     clsize=rs.getString("CLSIZE");
                     color=rs.getString("COLOUR");
                     des=rs.getString("DESCRIPTION");
                     
                     quantity=rs.getInt("QUANTITY");
                     cost=rs.getFloat("COST");
                     
                     if(!(clsize==" ")  && !(color==" "))
                     {
                         Descrip= des.concat("   "+clsize+"   "+color);
                     }
                     
                     obs.add(new Orders_table(userid,id,Descrip,cost,quantity));
                     
                 o_table.setItems(obs);
                 o_table.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
                 o_table.getSelectionModel().setCellSelectionEnabled(true);
        
                     
                 } 
                     
            
            
        } 
        catch (ClassNotFoundException | SQLException ex) 
        {
            Logger.getLogger(View_ordersController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleclose(MouseEvent event) {
        System.exit(0);
       
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
    
}
