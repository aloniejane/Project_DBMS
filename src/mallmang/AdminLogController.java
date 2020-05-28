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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class AdminLogController implements Initializable {

    @FXML
    private Button add;
    @FXML
    private Button delete;
    @FXML
    private Button view;
    @FXML
    private Button back;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Add_Item(MouseEvent event) throws IOException 
    {   
        Stage stage = (Stage) add.getScene().getWindow();
        stage.hide();
        
         Parent root = FXMLLoader.load(getClass().getResource("Add.fxml"));
        Stage stage1 = new Stage();
        
        stage1.initStyle(StageStyle.UNDECORATED);
        Scene scene3 = new Scene(root);
        stage1.setScene(scene3);
        stage1.show();
        
    }


    @FXML
    private void Delete_Item(MouseEvent event) throws IOException {
        Stage stage = (Stage) delete.getScene().getWindow();
        stage.hide();
        Parent root = FXMLLoader.load(getClass().getResource("Delete.fxml"));
        Stage stage1 = new Stage();
        
        stage1.initStyle(StageStyle.UNDECORATED);
        Scene scene3 = new Scene(root);
        stage1.setScene(scene3);
        stage1.show();
    }

    @FXML
    private void View_Items(MouseEvent event) throws IOException 
    {
        Stage stage = (Stage) view.getScene().getWindow();
        stage.hide();
        Parent root = FXMLLoader.load(getClass().getResource("View.fxml"));
        Stage stage1 = new Stage();
        
        stage1.initStyle(StageStyle.UNDECORATED);
        Scene scene3 = new Scene(root);
        stage1.setScene(scene3);
        stage1.show();
    }
    

    @FXML
    private void handleback(MouseEvent event) throws IOException {
        
        Stage stage = (Stage) back.getScene().getWindow();
        stage.hide();
        
        
        Parent root = FXMLLoader.load(getClass().getResource("Adminwin.fxml"));
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

    @FXML
    private void view_orders(MouseEvent event) throws IOException {
        Stage stage = (Stage) back.getScene().getWindow();
        stage.hide();
        
        
        Parent root = FXMLLoader.load(getClass().getResource("View_orders.fxml"));
        Stage stage1 = new Stage();
        stage1.initStyle(StageStyle.UNDECORATED);
        Scene scene1 = new Scene(root);
        stage1.setScene(scene1);
        stage1.show();
    }
    
    
}
