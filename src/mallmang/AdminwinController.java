package mallmang;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;



public class AdminwinController implements Initializable 
{

    @FXML
    public Label back;  //back label
    public Label minz;  //minimize label
    public Button submit;   //Submit Button
    public TextField Aname;    //Admin name field
    public PasswordField Adminpass;    //Admin password field
    String Admin_nam,Admin_pass;    //variables to store Admin name & password
    
    
    @FXML
    public void handleBack(MouseEvent event) throws Exception  //Back event
    {
        
        Stage stage = (Stage) back.getScene().getWindow();  //Close current window
        stage.close();
        
        Parent root = FXMLLoader.load(getClass().getResource("First.fxml"));    //Load First.fxml 
        Stage stage1 = new Stage();
        stage1.initStyle(StageStyle.UNDECORATED);
        Scene scene1 = new Scene(root);
        stage1.setScene(scene1);
        stage1.show();
    }
    
    @FXML
     public void handleClose(MouseEvent event)  //Close event
    {
        System.exit(0);  //Exit App
        
    }
     
     
    @FXML
     public void min(MouseEvent event) //min Method Mouse Event
    {
        ((Stage) minz.getScene().getWindow()).setIconified(true); //Minimize Adminwin.fxml
    }
     
     
     
     
    @FXML
    public void Submit(MouseEvent event) throws IOException //Submit Method Mouse Event
    {
        
        Admin_nam=Aname.getText();
        Admin_pass=Adminpass.getText();
         
        if(Admin_nam.equals("Admin") && Admin_pass.equals("Admin@elante")) //Verify Admin Details
        {
            Stage stage = (Stage) submit.getScene().getWindow();    //Close current stage
            stage.hide();
        
        
            Parent root = FXMLLoader.load(getClass().getResource("AdminLog.fxml")); //Load AdminLog.fxmml
            Stage stage1 = new Stage();
            stage1.initStyle(StageStyle.UNDECORATED);
            Scene scene1 = new Scene(root);
            stage1.setScene(scene1);
            stage1.show();
        }
        else
        {
            Aname.clear();
            Adminpass.clear();
            
            AlertController ac = new AlertController(); //Alert message
            AlertController.txt="Invalid Login Credentials !";
            
            Parent root = FXMLLoader.load(getClass().getResource("Alert.fxml"));    //Load Alert.fxml
            Stage stage1 = new Stage();
            stage1.initStyle(StageStyle.UNDECORATED);
            Scene scene1 = new Scene(root);
            stage1.setScene(scene1);
            stage1.show();
            
        }
         
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) //Initialize Method
    {
        
    }    
    
}
