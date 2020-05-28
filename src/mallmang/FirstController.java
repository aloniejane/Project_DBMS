/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mallmang;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

/**
 * FXML Controller class
 *
 * @author Bryan Caldeira
 */
public class FirstController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    @FXML
    public void handleClose(MouseEvent event)
    {
        System.exit(0);
        
    }
    
    @FXML
    public Label minz;
    
    
    public void min(MouseEvent event) 
    {
        
        ((Stage) minz.getScene().getWindow()).setIconified(true);
    }
    
    @FXML
    public Button diss;
    public ImageView admin,user;
    public Label lab1,lab2;
    public Label adminwin,userwin;
    
    public void adminhover(MouseEvent event) 
    {
                
        File file = new File("C:\\Users\\USER\\Documents\\NetBeansProjects\\MallMang\\src\\mallmang\\images\\admin.png");
        Image image = new Image(file.toURI().toString());
        admin.setImage(image);
        lab1.setText("ADMIN");
        
    }
    
    public void adminhoverover(MouseEvent event) 
    {
                
        File file = new File("");
        Image image = new Image(file.toURI().toString());
        admin.setImage(image);
        lab1.setText(null);
    }
    
    
    
    public void userhover(MouseEvent event) 
    {
                
        File file = new File("C:\\Users\\USER\\Documents\\NetBeansProjects\\MallMang\\src\\mallmang\\images\\user.jpg");
        Image image = new Image(file.toURI().toString());
        user.setImage(image);
        lab2.setText("USER");
    }
    
    public void userhoverover(MouseEvent event) 
    {
                
        File file = new File("");
        Image image = new Image(file.toURI().toString());
        user.setImage(image);
        lab2.setText(null);
        
        
    }
    
    @FXML
    public void adminwin() throws ClassNotFoundException {
    Stage stage = (Stage) admin.getScene().getWindow();
    stage.hide();

    try {
        Parent root = FXMLLoader.load(getClass().getResource("Adminwin.fxml"));
        Stage stage1 = new Stage();
        
        stage1.initStyle(StageStyle.UNDECORATED);
        Scene scene3 = new Scene(root);
        stage1.setScene(scene3);
        stage1.show();
            
        }
        catch(Exception e){}
    
    }
    
    
    
    @FXML
    public void userwin() throws ClassNotFoundException {
    Stage stage = (Stage) user.getScene().getWindow();
    stage.hide();

    try {
        Parent root = FXMLLoader.load(getClass().getResource("Userwin.fxml"));
        Stage stage1 = new Stage();
        
        stage1.initStyle(StageStyle.UNDECORATED);
        Scene scene3 = new Scene(root);
        stage1.setScene(scene3);
        stage1.show();
        
            
        }
        catch(Exception e){}
    
    }
    
    
    
    
    

    
    
    
    
    
   
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
