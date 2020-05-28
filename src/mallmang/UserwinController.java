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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Bryan Caldeira
 */
public class UserwinController implements Initializable {

    @FXML
    private TextField uname;
    @FXML
    private TextField upass;
    
    public static int useride;

    /**
     * Initializes the controller class.
     */
    
    
    @FXML
    public void handleClose(MouseEvent event)
    {
        
        
        System.exit(0);
        
    }
    
    
    
    @FXML
    public Label uback;
    public Button sgnup,lgn;
    
    
    @FXML
    public void handleBack(MouseEvent event) throws Exception
    {
        Stage stage = (Stage) uback.getScene().getWindow();
        stage.hide();
        
        Stage stage1 = new Stage();
        
        Parent root = FXMLLoader.load(getClass().getResource("First.fxml"));
        stage1.initStyle(StageStyle.UNDECORATED);
        Scene scene1 = new Scene(root);
        stage1.setScene(scene1);
        stage1.show();

    }
    
    @FXML
    public void signUp(MouseEvent event) throws Exception
    {
        Stage stage = (Stage) sgnup.getScene().getWindow();
        stage.hide();
        
        Stage stage1 = new Stage();
        
        Parent root = FXMLLoader.load(getClass().getResource("Signupwin.fxml"));
        stage1.initStyle(StageStyle.UNDECORATED);
        Scene scene1 = new Scene(root);
        stage1.setScene(scene1);
        stage1.show();
        


    }
    
    

    
    
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void LogIn(MouseEvent event) throws ClassNotFoundException, SQLException, IOException 
    {
        
        String name=uname.getText();
        String pass=upass.getText();
        
        
        try
        {

                    Class.forName("oracle.jdbc.OracleDriver");
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","DBMSPROJECT","mall@12");
                    java.sql.Statement stat=con.createStatement();
           
             
                   
                    String query="select * from userlogin where uname = '"+name+"' and password = '"+pass+"'";
                    System.out.println(query);

                    ResultSet rs = stat.executeQuery(query);
                    if(!rs.next())
                    {
                        
                        uname.clear();
                        upass.clear();
                        AlertController ac = new AlertController();
                        AlertController.txt="Login Failed !";
                        Parent root = FXMLLoader.load(getClass().getResource("Alert.fxml"));
                        Stage stage1 = new Stage();
                        stage1.initStyle(StageStyle.UNDECORATED);
                        Scene scene1 = new Scene(root);
                        stage1.setScene(scene1);
                        stage1.show();
                        
                    }
                    else
                    {
                        
                        Class.forName("oracle.jdbc.OracleDriver");
                        Connection con1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","DBMSPROJECT","mall@12");
                        java.sql.Statement stat1=con1.createStatement();
           
             
                   
                        String query1="select userid from userlogin where uname = '"+name+"' and password = '"+pass+"'";
  
                        ResultSet rs1 = stat1.executeQuery(query1);
                        if(rs1.next())
                        {
                            useride = rs1.getInt(1);
                        }
                        
                        
                        
                        
                        Stage stage = (Stage) lgn.getScene().getWindow();
                        stage.hide();
        
                        Stage stage1 = new Stage();
        
                        Parent root = FXMLLoader.load(getClass().getResource("userMain.fxml"));
                        stage1.initStyle(StageStyle.UNDECORATED);
                        Scene scene1 = new Scene(root);
                        stage1.setScene(scene1);
                        stage1.show();
                        
                    }
                    stat.close();
                    con.close();
        }
        catch (ClassNotFoundException|SQLException ex) 
        {
                    Logger.getLogger(ClothesController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
       
    }
    
}
