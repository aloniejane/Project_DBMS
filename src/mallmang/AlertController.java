/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Bryan Caldeira
 */
public class AlertController implements Initializable {
    
    @FXML
    private Button okback;
    @FXML
    private Label text1;
    
    
    public static String txt;
    
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        text1.setText(txt);
        
        // TODO
    }    

    @FXML
    public void handlebackok(MouseEvent event) 
    {
        Stage stage = (Stage) okback.getScene().getWindow();
        stage.hide();
        
    }

    
}
