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
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class UserMainController implements Initializable {

    @FXML
    
    public Button back;
    @FXML
    private ImageView clothes;
    @FXML
    private ImageView elec;

    @FXML
    private Text lab1;
    @FXML
    private Text lab2;
    
    @FXML
     public void handleClose(MouseEvent event)
    {
        
        
        System.exit(0);
        
    }
    @FXML
    public void handleBack(MouseEvent event) throws Exception
    {
        
        try
        {

                    Class.forName("oracle.jdbc.OracleDriver");
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","DBMSPROJECT","mall@12");
                    java.sql.Statement stat=con.createStatement();

                    String query1="delete from CART";

                    stat.executeUpdate(query1);

                   
                    stat.close();
                    con.close();
                        
                        

         
        }
        catch (ClassNotFoundException|SQLException ex) 
        {
                    Logger.getLogger(ClothesController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Stage stage = (Stage) back.getScene().getWindow();
        stage.hide();
        
        Stage stage1 = new Stage();
        
        Parent root = FXMLLoader.load(getClass().getResource("Userwin.fxml"));
        stage1.initStyle(StageStyle.UNDECORATED);
        Scene scene1 = new Scene(root);
        stage1.setScene(scene1);
        stage1.show();

    }
    
    
    
    
    @FXML
    public void clotheshover(MouseEvent event) 
    {
                
        File file = new File("C:\\Users\\USER\\Documents\\NetBeansProjects\\MallMang\\src\\mallmang\\images\\clothes.gif");
        Image image = new Image(file.toURI().toString());
        clothes.setImage(image);
        lab1.setText("CLOTHES");
        
    }
    
    @FXML
    public void clotheshoverover(MouseEvent event) 
    {
                
        File file = new File("");
        Image image = new Image(file.toURI().toString());
        clothes.setImage(image);
        lab1.setText(null);
    }
    
    
    
    @FXML
    public void elechover(MouseEvent event) 
    {
                
        File file = new File("C:\\Users\\USER\\Documents\\NetBeansProjects\\MallMang\\src\\mallmang\\images\\elec.gif");
        Image image = new Image(file.toURI().toString());
        elec.setImage(image);
        lab2.setText("ELECTRONICS");
        
    }
    
    @FXML
    public void elechoverover(MouseEvent event) 
    {
                
        File file = new File("");
        Image image = new Image(file.toURI().toString());
        elec.setImage(image);
        lab2.setText(null);
    }
    
    
    
    
    
    

    
    @FXML
    public void Clotheswin() throws ClassNotFoundException {
        
    Stage stage = (Stage) clothes.getScene().getWindow();
    stage.hide();
    

    try {
        Parent root = FXMLLoader.load(getClass().getResource("MenWomSel.fxml"));
        Stage stage1 = new Stage();
        
        stage1.initStyle(StageStyle.UNDECORATED);
        Scene scene3 = new Scene(root);
        stage1.setScene(scene3);
        stage1.show();
            
        }
        catch(Exception e){}
    
    }
    
    
    @FXML
    public void Elecwin() throws ClassNotFoundException {
        
    Stage stage = (Stage) clothes.getScene().getWindow();
    stage.hide();
    

    try {
        Parent root = FXMLLoader.load(getClass().getResource("Electronics.fxml"));
        Stage stage1 = new Stage();
        
        stage1.initStyle(StageStyle.UNDECORATED);
        Scene scene3 = new Scene(root);
        stage1.setScene(scene3);
        stage1.show();
            
        }
        catch(IOException e){}
    
    }
    
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
