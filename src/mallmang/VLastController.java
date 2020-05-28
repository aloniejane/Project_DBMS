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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Bryan caldeira
 */
public class VLastController implements Initializable {

    @FXML
    private ImageView str1;
    @FXML
    private ImageView str2;
    @FXML
    private ImageView str3;
    @FXML
    private ImageView str4;
    @FXML
    private ImageView str5;
    private Label bk;
    
    
    int Strs;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void first(MouseEvent event) 
    {
        File file1 = new File("C:\\Users\\USER\\Documents\\NetBeansProjects\\MallMang\\src\\mallmang\\images\\goldstar.jpg");
        Image image1 = new Image(file1.toURI().toString()); 
        str1.setImage(image1);
        
        File file2 = new File("C:\\Users\\USER\\Documents\\NetBeansProjects\\MallMang\\src\\mallmang\\images\\star-shape-md.png");
        Image image2 = new Image(file2.toURI().toString());
        str2.setImage(image2);
        
        File file3 = new File("C:\\Users\\USER\\Documents\\NetBeansProjects\\MallMang\\src\\mallmang\\images\\star-shape-md.png");
        Image image3 = new Image(file3.toURI().toString());
        str3.setImage(image3);
        
        File file4 = new File("C:\\Users\\USER\\Documents\\NetBeansProjects\\MallMang\\src\\mallmang\\images\\star-shape-md.png");
        Image image4 = new Image(file4.toURI().toString());
        str4.setImage(image4);
        
        File file5 = new File("C:\\Users\\USER\\Documents\\NetBeansProjects\\MallMang\\src\\mallmang\\images\\star-shape-md.png");
        Image image5 = new Image(file5.toURI().toString());
        str4.setImage(image5);
        
        Strs=1;
    }

    @FXML
    private void second(MouseEvent event) {
        File file1 = new File("C:\\Users\\USER\\Documents\\NetBeansProjects\\MallMang\\src\\mallmang\\images\\goldstar.jpg");
        Image image1 = new Image(file1.toURI().toString());
        str1.setImage(image1);
        
        
        File file2 = new File("C:\\Users\\USER\\Documents\\NetBeansProjects\\MallMang\\src\\mallmang\\images\\goldstar.jpg");
        Image image2 = new Image(file2.toURI().toString());
        str2.setImage(image2);
        
        
        File file3 = new File("C:\\Users\\USER\\Documents\\NetBeansProjects\\MallMang\\src\\mallmang\\images\\star-shape-md.png");
        Image image3 = new Image(file3.toURI().toString());
        str3.setImage(image3);
        
        
        File file4 = new File("C:\\Users\\USER\\Documents\\NetBeansProjects\\MallMang\\src\\mallmang\\images\\star-shape-md.png");
        Image image4 = new Image(file4.toURI().toString());
        str4.setImage(image4);
        
        File file5 = new File("C:\\Users\\USER\\Documents\\NetBeansProjects\\MallMang\\src\\mallmang\\images\\star-shape-md.png");
        Image image5 = new Image(file5.toURI().toString());
        str5.setImage(image5);
        
        Strs=2;
        
    }

    @FXML
    private void third(MouseEvent event) {
        
        File file1 = new File("C:\\Users\\USER\\Documents\\NetBeansProjects\\MallMang\\src\\mallmang\\images\\goldstar.jpg");
        Image image1 = new Image(file1.toURI().toString());
        str1.setImage(image1);
        
        File file2 = new File("C:\\Users\\USER\\Documents\\NetBeansProjects\\MallMang\\src\\mallmang\\images\\goldstar.jpg");
        Image image2 = new Image(file2.toURI().toString());
        str2.setImage(image2);
        
        File file3 = new File("C:\\Users\\USER\\Documents\\NetBeansProjects\\MallMang\\src\\mallmang\\images\\goldstar.jpg");
        Image image3 = new Image(file3.toURI().toString());
        str3.setImage(image3);
        
        File file4 = new File("C:\\Users\\USER\\Documents\\NetBeansProjects\\MallMang\\src\\mallmang\\images\\star-shape-md.png");
        Image image4 = new Image(file4.toURI().toString());
        str4.setImage(image4);
        
        File file5 = new File("C:\\Users\\USER\\Documents\\NetBeansProjects\\MallMang\\src\\mallmang\\images\\star-shape-md.png");
        Image image5 = new Image(file5.toURI().toString());
        str5.setImage(image5);
        
        Strs=3;
        
        
        
        
    }

    @FXML
    private void fourth(MouseEvent event) {
        File file1 = new File("C:\\Users\\USER\\Documents\\NetBeansProjects\\MallMang\\src\\mallmang\\images\\goldstar.jpg");
        Image image1 = new Image(file1.toURI().toString());
        str1.setImage(image1);
        
        File file2 = new File("C:\\Users\\USER\\Documents\\NetBeansProjects\\MallMang\\src\\mallmang\\images\\goldstar.jpg");
        Image image2 = new Image(file2.toURI().toString());
        str2.setImage(image2);
        
        File file3 = new File("C:\\Users\\USER\\Documents\\NetBeansProjects\\MallMang\\src\\mallmang\\images\\goldstar.jpg");
        Image image3 = new Image(file3.toURI().toString());
        str3.setImage(image3);
        
        File file4 = new File("C:\\Users\\USER\\Documents\\NetBeansProjects\\MallMang\\src\\mallmang\\images\\goldstar.jpg");
        Image image4 = new Image(file4.toURI().toString());
        str4.setImage(image4);
        
        File file5 = new File("C:\\Users\\USER\\Documents\\NetBeansProjects\\MallMang\\src\\mallmang\\images\\star-shape-md.png");
        Image image5 = new Image(file5.toURI().toString());
        str5.setImage(image5);
        
        Strs=4;
    }

    @FXML
    private void fifth(MouseEvent event) {
        File file1 = new File("C:\\Users\\USER\\Documents\\NetBeansProjects\\MallMang\\src\\mallmang\\images\\goldstar.jpg");
        Image image1 = new Image(file1.toURI().toString());
        str1.setImage(image1);
        
        File file2 = new File("C:\\Users\\USER\\Documents\\NetBeansProjects\\MallMang\\src\\mallmang\\images\\goldstar.jpg");
        Image image2 = new Image(file2.toURI().toString());
        str2.setImage(image2);
        
        File file3 = new File("C:\\Users\\USER\\Documents\\NetBeansProjects\\MallMang\\src\\mallmang\\images\\goldstar.jpg");
        Image image3 = new Image(file3.toURI().toString());
        str3.setImage(image3);
        
        File file4 = new File("C:\\Users\\USER\\Documents\\NetBeansProjects\\MallMang\\src\\mallmang\\images\\goldstar.jpg");
        Image image4 = new Image(file4.toURI().toString());
        str4.setImage(image4);
        
        File file5 = new File("C:\\Users\\USER\\Documents\\NetBeansProjects\\MallMang\\src\\mallmang\\images\\goldstar.jpg");
        Image image5 = new Image(file5.toURI().toString());
        str5.setImage(image5);
        
        Strs=5;
        
        
    }

    @FXML
    private void close(MouseEvent event) {
        System.exit(0);
    }


    @FXML
    private void Done(MouseEvent event) {
        
        UserwinController uc = new UserwinController();
        int uid=UserwinController.useride;
        try
        {

                    Class.forName("oracle.jdbc.OracleDriver");
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","DBMSPROJECT","mall@12");
                    java.sql.Statement stat=con.createStatement();

                    String query1="update USERLOGIN set FEEDBACK = "+Strs+" where USERID = "+uid+"";

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
    
}
