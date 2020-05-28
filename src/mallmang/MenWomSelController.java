
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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class MenWomSelController implements Initializable 
{

    @FXML
    private ImageView men;
    @FXML
    private ImageView women;
    @FXML
    private Label back;
    
    
    
    
    @FXML
    public void handleClose(MouseEvent event)
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
        System.exit(0);
        
    }
    
    
    @FXML
    public void handleBack(MouseEvent event) throws Exception
    {
        
       
        
        Stage stage = (Stage) back.getScene().getWindow();
        stage.hide();
        
        
        Parent root = FXMLLoader.load(getClass().getResource("userMain.fxml"));
        Stage stage1 = new Stage();
        stage1.initStyle(StageStyle.UNDECORATED);
        Scene scene1 = new Scene(root);
        stage1.setScene(scene1);
        stage1.show();
    }
    
    
    
    
    
    
    @FXML
     public void menhover(MouseEvent event) 
    {
                
        File file = new File("C:\\Users\\USER\\Documents\\NetBeansProjects\\MallMang\\src\\mallmang\\images\\men.jpg");
        Image image = new Image(file.toURI().toString());
        men.setImage(image);

        
    }
    @FXML
    public void menhoverover(MouseEvent event) 
    {
                
        File file = new File("");
        Image image = new Image(file.toURI().toString());
        men.setImage(image);

    }
    
    @FXML
    public void womenhover(MouseEvent event) 
    {
                
        File file = new File("C:\\Users\\USER\\Documents\\NetBeansProjects\\MallMang\\src\\mallmang\\images\\women.jpg");
        Image image = new Image(file.toURI().toString());
        women.setImage(image);

        
    }
    @FXML
    public void womenhoverover(MouseEvent event) 
    {
                
        File file = new File("");
        Image image = new Image(file.toURI().toString());
        women.setImage(image);

    }
    
    
    
    @FXML
    public void menwin() throws ClassNotFoundException, IOException {
    Stage stage = (Stage) men.getScene().getWindow();
    stage.hide();


        Parent root = FXMLLoader.load(getClass().getResource("Mclothes.fxml"));
        Stage stage1 = new Stage();
        
        stage1.initStyle(StageStyle.UNDECORATED);
        Scene scene3 = new Scene(root);
        stage1.setScene(scene3);
        stage1.show();
            
        }
    
    @FXML
    public void womenwin() throws ClassNotFoundException, IOException {
    Stage stage = (Stage) men.getScene().getWindow();
    stage.hide();


        Parent root = FXMLLoader.load(getClass().getResource("Wclothes.fxml"));
        Stage stage1 = new Stage();
        
        stage1.initStyle(StageStyle.UNDECORATED);
        Scene scene3 = new Scene(root);
        stage1.setScene(scene3);
        stage1.show();
            
        }

    
    


    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        
    }    
    
}
