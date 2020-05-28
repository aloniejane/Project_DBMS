/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mallmang;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Bryan Caldeira
 */
public class PrivacyPolicyController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    public Label pback;
    @FXML
    private TextArea txtara;
    @FXML
    private Button ok;
    
    @FXML
    public void handleback(MouseEvent event) 
    {
        Stage stage = (Stage) pback.getScene().getWindow();
        stage.hide();
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtara.setEditable(false);
    }    

    @FXML
    private void handleOk(MouseEvent event) 
    {
        Stage stage = (Stage) ok.getScene().getWindow();
        stage.hide();
    }
    
}
