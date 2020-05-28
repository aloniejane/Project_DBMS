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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.regex.Pattern; 


/**
 * FXML Controller class
 *
 * @author Bryan Caldeira
 */
public class SignupwinController implements Initializable {

    @FXML
    private TextField name;
    
    @FXML
    private Button signbtn;
    @FXML
    private PasswordField pass,Cpass;
    @FXML
    private TextField PhoneNo;
    @FXML
    private CheckBox checkpolicy;
    private Button lgin; //login button
    private ImageView loading;
    
    
    static String mess;

    /**
     * Initializes the controller class.
     */
    

    
    public static int userid=0;
    @FXML
    private TextField email;
    
    @FXML
    public void handleClose(MouseEvent event)
    {
        System.exit(0);
        
    }
    
    @FXML
    public Label sback;
    
    
    public Label text1,usdid;
    public Button okback;
    public ImageView ck;
    
    int trg;
    
    
    @FXML
    public void handleBack(MouseEvent event) throws Exception
    {
        
        Stage stage = (Stage) sback.getScene().getWindow();
        stage.hide();
        
        
        Parent root = FXMLLoader.load(getClass().getResource("Userwin.fxml"));
        Stage stage1 = new Stage();
        stage1.initStyle(StageStyle.UNDECORATED);
        Scene scene1 = new Scene(root);
        stage1.setScene(scene1);
        stage1.show();
    }
    
    

    
    
    
    
    
    
    
    
    @FXML
    public void privpol(MouseEvent event) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("PrivacyPolicy.fxml"));
        Stage stage1 = new Stage();
        stage1.initStyle(StageStyle.UNDECORATED);
        Scene scene1 = new Scene(root);
        stage1.setScene(scene1);
        stage1.show();
        
    }
    
    
    
   
    
    public void Alertmess() throws IOException
    {
                AlertController ac = new AlertController();
                AlertController.txt=mess;
                Parent root = FXMLLoader.load(getClass().getResource("Alert.fxml"));
                Stage stage1 = new Stage();
                stage1.initStyle(StageStyle.UNDECORATED);
                Scene scene1 = new Scene(root);
                stage1.setScene(scene1);
                stage1.show();
                
        
    }
    
    
    public void regmess() throws IOException
    {
        
                Parent root = FXMLLoader.load(getClass().getResource("registerwin.fxml"));
                Stage stage1=new Stage();
                stage1.initStyle(StageStyle.UNDECORATED);
                
                Scene scene1 = new Scene(root);
                stage1.setScene(scene1);
                stage1.show();
                
                
                
               
    }
    
    public static boolean isValid(String email) //Email validation
    { 
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                            "[a-zA-Z0-9_+&*-]+)*@" + 
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                            "A-Z]{2,7}$"; 
                              
        Pattern pat = Pattern.compile(emailRegex); 
        if (email == null) 
            return false; 
        return pat.matcher(email).matches(); 
    } 
    

    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    public void SignUp(MouseEvent event) throws IOException, SQLException 
    {
        int rows=0;
        int p=0;
        
        String uname=name.getText();
        String phone=PhoneNo.getText();
        String upass=pass.getText();
        String Repass=Cpass.getText();
        String eml=email.getText();

        
        
        
        
        String regexStr = "^(1\\-)?[0-9]{3}\\-?[0-9]{3}\\-?[0-9]{4}$";
        
        //Checks if the phoneno is valid 
        if (phone.matches(regexStr))
        {
            p=1;
        }
        
        //validation of username
        if(uname.isEmpty())
        {
        
              mess="Enter Valid User Name"; 
              Alertmess();
              
        }
        else if(!isValid(eml))
        {
            mess="Enter a Valid Email Id";
            Alertmess();
        }
        //checking for letters in phoneno
        else if(p==0)
        {
           
            mess="Enter valid PhoneNo"; 
            Alertmess(); 
        }
        
        else if(upass.isEmpty())
        { 
            
            mess="Enter Valid Password"; 
            Alertmess(); 
            
        }
        else if(upass.length()<8)
        {
            mess="Min Pass Length 8"; 
            Alertmess(); 
        }
        else if(Repass.isEmpty())
        { 
            mess="Confirm Password"; 
            Alertmess(); 
            
        }
        
        else if(!Repass.matches(upass))
        { 
            mess="Passwords Don't Match"; 
            Alertmess(); 
            
        }
        
        //Checks if the terms and conditions are checked 
        else if(checkpolicy.isSelected()==false)
        {
            mess="Agree to the T&C"; 
            Alertmess(); 
            
        }

        
        //inserts in the database if the passwords matach
        else
        {
            
            try 
            {
                
                
                //connects to database
                Class.forName("oracle.jdbc.OracleDriver");
                Connection  con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","DBMSPROJECT","mall@12");
                
                //inserts values to USERLOGIN table
                Statement stat=con.createStatement();
                String query="insert into USERLOGIN(UNAME,PASSWORD,PHONENO,EMAIL_ID)values('"+uname+"','"+upass+"','"+phone+"','"+eml+"')";
             
                //checks if the passwords are equal 
                if(Repass.equals(upass))
                {
                    rows= stat.executeUpdate(query);
                    
                }
                
                //if any of the rows are inserted then gives an alert message and goes to the Login page
                if(rows!=0)
                {
                    
                    
                    //gets the userid from the table 
                   String query1="select USERID from USERLOGIN where UNAME=? AND PASSWORD=?"; 
                   PreparedStatement sta=con.prepareStatement(query1);
                   
                   sta.setString(1,uname);
                   sta.setString(2,upass);
                    
                    
                    
                    ResultSet rs=sta.executeQuery();
                    
                    while(rs.next())
                    {
                        userid=rs.getInt("USERID");
                    }
                    

                    sta.close();
                    stat.close();
                    con.close();
                }
                
           

            }
            
        
            catch (ClassNotFoundException | SQLException ex) 
            {
                Logger.getLogger(SignupwinController.class.getName()).log(Level.SEVERE, null, ex);
            }
            Stage stage = (Stage) sback.getScene().getWindow();
            stage.hide();
        
        
            Parent root = FXMLLoader.load(getClass().getResource("Userwin.fxml"));
            Stage stage1 = new Stage();
            stage1.initStyle(StageStyle.UNDECORATED);
            Scene scene1 = new Scene(root);
            stage1.setScene(scene1);
            stage1.show();
            
    
        }//close of else 
    }//close of method     
} 
    
            
        
        

    
    
    

