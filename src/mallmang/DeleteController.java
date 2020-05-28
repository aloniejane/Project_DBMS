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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;



public class DeleteController implements Initializable {

    @FXML
    private AnchorPane close;
    @FXML
    private Label back;
    @FXML
    private AnchorPane menpane;
    @FXML
    private TextField CatagoryID;
    @FXML
    private AnchorPane view;
    @FXML
    private Label cost;
    @FXML
    private Label des;
    @FXML
    private Label color;
    @FXML
    private Label mcat;
    @FXML
    private TextField CatagoryID1;
    @FXML
    private AnchorPane view1;
    @FXML
    private Label wcat1;
    @FXML
    private Label cost1;
    @FXML
    private Label des1;
    @FXML
    private Label color1;
    @FXML
    private AnchorPane womenpane;
    @FXML
    private AnchorPane elecpane;
    
    @FXML
    private AnchorPane view3;
    @FXML
    private Label cno;
    @FXML
    private Label csize;
  
    @FXML
    private TextField clothno1;
    @FXML
    private Label Catidc;
    @FXML
    private Label quan;
    @FXML
    private AnchorPane elecpane1;
    @FXML
    private TextField Elecno;
    @FXML
    private AnchorPane view4;
    @FXML
    private Label eno1;
    @FXML
    private Label type1;
    @FXML
    private Label model1;
    @FXML
    private Label pricee1;
    @FXML
    private Label brand1;
    @FXML
    private Label equan1;

 
       

    
    

    @FXML
    private void handleclose(MouseEvent event) 
    {
        System.exit(0);
    }
    
    
    @FXML
    private void Delete_Men(ActionEvent event) 
    {
        menpane.setVisible(true);
        womenpane.setVisible(false);
        elecpane.setVisible(false);
        elecpane1.setVisible(false);
        view1.setVisible(false);
        view3.setVisible(false);
        view4.setVisible(false);
        
        CatagoryID.clear();
        CatagoryID1.clear();
        clothno1.clear();
        Elecno.clear();
        
    }
    


    @FXML
    private void delMen(MouseEvent event) throws IOException 
    {
        
        
        try 
        {
            
            
            String cat=CatagoryID.getText();
            
            Class.forName("oracle.jdbc.OracleDriver");
            Connection  con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","DBMSPROJECT","mall@12");
            
            
            String query1="select DESCRIPTION,COLOUR,COST from MEN where CATID=?"; 
            PreparedStatement pre=con.prepareStatement(query1);
                   
            pre.setString(1,cat);
         
            ResultSet rs=pre.executeQuery();
            if(rs.next() && !cat.equals("M00"))
            {
                String desp=rs.getString("DESCRIPTION");
                String colorm=rs.getString("COLOUR");
                double cost1=rs.getDouble("COST");
                
                String query="DELETE from MEN where CATID=?"; 
                PreparedStatement pre1=con.prepareStatement(query);
                pre1.setString(1,cat);
                 
                pre1.executeQuery();
                 
                mcat.setText(cat); 
                des.setText(desp); 
                 
                color.setText(colorm); 
                cost.setText("RS "+cost1); 
                view.setVisible(true);
                 
                CatagoryID.clear();    //Clear TextField
            }
            else
            {
                if(cat.equals(""))
                {
                    AlertController ac = new AlertController(); //Alert message
                    AlertController.txt="CatID Can't be NULL !";
            
                    Parent root = FXMLLoader.load(getClass().getResource("Alert.fxml"));    //Load Alert.fxml
                    Stage stage1 = new Stage();
                    stage1.initStyle(StageStyle.UNDECORATED);
                    Scene scene1 = new Scene(root);
                    stage1.setScene(scene1);
                    stage1.show(); 
                }
                else
                {
                    AlertController ac = new AlertController(); //Alert message
                    AlertController.txt="CatID doesnot exist !";
            
                    Parent root = FXMLLoader.load(getClass().getResource("Alert.fxml"));    //Load Alert.fxml
                    Stage stage1 = new Stage();
                    stage1.initStyle(StageStyle.UNDECORATED);
                    Scene scene1 = new Scene(root);
                    stage1.setScene(scene1);
                    stage1.show();
                }
                
            }
            
        } 
        catch (ClassNotFoundException | SQLException ex) 
        {
            Logger.getLogger(DeleteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    @FXML
    private void Delete_Women(ActionEvent event) 
    {
        womenpane.setVisible(true);
        menpane.setVisible(false);
        elecpane.setVisible(false);
        elecpane1.setVisible(false);
        view.setVisible(false);
        view3.setVisible(false);
        view4.setVisible(false);
        
        CatagoryID.clear();
        CatagoryID1.clear();
        clothno1.clear();
        Elecno.clear();
    }

    @FXML
    private void delwomen(MouseEvent event) throws IOException 
    {
        
        
        try 
        {
            
            
            String cat=CatagoryID1.getText();
            
            Class.forName("oracle.jdbc.OracleDriver");
            Connection  con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","DBMSPROJECT","mall@12");
            System.out.println(cat);
            
            String query1="select DESCRIPTION,COLOUR,COST from WOMEN where CATID=?"; 
            PreparedStatement pre=con.prepareStatement(query1);
                   
            pre.setString(1,cat);
         
            ResultSet rs=pre.executeQuery();
            if(rs.next()&& !cat.equals("W00"))
            {
                String desp=rs.getString("DESCRIPTION");
                String colorm=rs.getString("COLOUR");
                double cost2=rs.getDouble("COST");
                
                String query="DELETE from WOMEN where CATID=?"; 
                 PreparedStatement pre1=con.prepareStatement(query);
                 pre1.setString(1,cat);
                 
                 pre1.executeQuery();
                 
                 wcat1.setText(cat); 
                 des1.setText(desp); 
                 
                 color1.setText(colorm); 
                 cost1.setText("RS "+cost2); 
                 view1.setVisible(true);
                 
                 CatagoryID1.clear();
                 
                 
            }
            else
            {
                if(cat.equals(""))
                {
                    AlertController ac = new AlertController(); //Alert message
                    AlertController.txt="CatID Can't be NULL !";
            
                    Parent root = FXMLLoader.load(getClass().getResource("Alert.fxml"));    //Load Alert.fxml
                    Stage stage1 = new Stage();
                    stage1.initStyle(StageStyle.UNDECORATED);
                    Scene scene1 = new Scene(root);
                    stage1.setScene(scene1);
                    stage1.show(); 
                }
                else
                {
                    AlertController ac = new AlertController(); //Alert message
                    AlertController.txt="CatID doesnot exist !";
            
                    Parent root = FXMLLoader.load(getClass().getResource("Alert.fxml"));    //Load Alert.fxml
                    Stage stage1 = new Stage();
                    stage1.initStyle(StageStyle.UNDECORATED);
                    Scene scene1 = new Scene(root);
                    stage1.setScene(scene1);
                    stage1.show();
                }
                
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DeleteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Delete_Clothes(ActionEvent event) 
    {
        
        elecpane.setVisible(true);
        menpane.setVisible(false);
        womenpane.setVisible(false);
        elecpane1.setVisible(false);
        view.setVisible(false);
        view1.setVisible(false);
        view4.setVisible(false);
        
        CatagoryID.clear();
        CatagoryID1.clear();
        clothno1.clear();
        Elecno.clear();
    }

    @FXML
    private void delelec(MouseEvent event) throws IOException 
    {
        
        
        try 
        {
            
            
            String cln=clothno1.getText();
            
            Class.forName("oracle.jdbc.OracleDriver");
            Connection  con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","DBMSPROJECT","mall@12");
            
            
            String query1="select CLOTHSIZE,QUANTITY,WCATID,MCATID from CLOTHES where CLOTHNO=?"; 
            PreparedStatement pre=con.prepareStatement(query1);
                   
            pre.setString(1,cln);
         
            ResultSet rs=pre.executeQuery();
            if(rs.next())
            {
                String clsize=rs.getString("CLOTHSIZE");
                String Quan=rs.getString("QUANTITY");
                String Wcat=rs.getString("WCATID");
                String Mcat=rs.getString("MCATID");
                
                String query="DELETE from CLOTHES where CLOTHNO=?"; 
                PreparedStatement pre1=con.prepareStatement(query);
                pre1.setString(1,cln);
                 
                pre1.executeQuery();
                 
                cno.setText(cln); 
                csize.setText(clsize);
                quan.setText(Quan); 
                 
                if(Wcat.equals("W00"))
                {
                   Catidc.setText(Mcat);
                }
                if(Mcat.equals("M00"))
                {
                    Catidc.setText(Wcat); 
                }
                
                
                view3.setVisible(true);
                
                clothno1.clear();
   
            }
            else
            {
                if(cln.equals(""))
                {
                    AlertController ac = new AlertController(); //Alert message
                    AlertController.txt="Cloth No. Can't be NULL !";
            
                    Parent root = FXMLLoader.load(getClass().getResource("Alert.fxml"));    //Load Alert.fxml
                    Stage stage1 = new Stage();
                    stage1.initStyle(StageStyle.UNDECORATED);
                    Scene scene1 = new Scene(root);
                    stage1.setScene(scene1);
                    stage1.show(); 
                }
                else
                {
                    AlertController ac = new AlertController(); //Alert message
                    AlertController.txt="Cloth No. doesnot exist !";
            
                    Parent root = FXMLLoader.load(getClass().getResource("Alert.fxml"));    //Load Alert.fxml
                    Stage stage1 = new Stage();
                    stage1.initStyle(StageStyle.UNDECORATED);
                    Scene scene1 = new Scene(root);
                    stage1.setScene(scene1);
                    stage1.show();
                }
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DeleteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handlebk(MouseEvent event) throws IOException 
    {
        Stage stage = (Stage) back.getScene().getWindow();
        stage.hide();
        
        
        Parent root = FXMLLoader.load(getClass().getResource("AdminLog.fxml"));
        Stage stage1 = new Stage();
        stage1.initStyle(StageStyle.UNDECORATED);
        Scene scene1 = new Scene(root);
        stage1.setScene(scene1);
        stage1.show();
    }

    @FXML
    private void Delete_ELEctronics(ActionEvent event) 
    {
        womenpane.setVisible(false);
        menpane.setVisible(false);
        elecpane.setVisible(false);
        elecpane1.setVisible(true);
        view.setVisible(false);
        view1.setVisible(false);
        view3.setVisible(false);
        
        CatagoryID.clear();
        CatagoryID1.clear();
        clothno1.clear();
        Elecno.clear();
    }

    @FXML
    private void deleteE(MouseEvent event) throws IOException 
    {
        
        
        
        try 
        {
            
            
            String eno=Elecno.getText();
            
            Class.forName("oracle.jdbc.OracleDriver");
            Connection  con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","DBMSPROJECT","mall@12");
            
            
            String query1="select TYPE,MODEl,BRAND,QUANTITY,EPrice from ELECTRONICS where ENO=?"; 
            PreparedStatement pre=con.prepareStatement(query1);
                   
            pre.setString(1,eno);
         
            ResultSet rs=pre.executeQuery();
            if(rs.next())
            {
                String type=rs.getString("TYPE");
                String Quan=rs.getString("QUANTITY");
                String model=rs.getString("MODEL");
                String brand=rs.getString("BRAND");
                double price=rs.getDouble("EPRICE");
                
                String query="DELETE from ELECTRONICS where ENO=?"; 
                PreparedStatement pre1=con.prepareStatement(query);
                pre1.setString(1,eno);
                 
                pre1.executeQuery();
                 
                eno1.setText(eno); 
                type1.setText(type);
                equan1.setText(Quan); 
                 
                
                model1.setText(model);
                pricee1.setText("RS "+price); 
                
                brand1.setText(brand); 
                 
                view4.setVisible(true);
                
                Elecno.clear();
                 
                 
            }
            else
            {
                if(eno.equals(""))
                {
                    AlertController ac = new AlertController(); //Alert message
                    AlertController.txt="ENo. Can't be NULL !";
            
                    Parent root = FXMLLoader.load(getClass().getResource("Alert.fxml"));    //Load Alert.fxml
                    Stage stage1 = new Stage();
                    stage1.initStyle(StageStyle.UNDECORATED);
                    Scene scene1 = new Scene(root);
                    stage1.setScene(scene1);
                    stage1.show(); 
                }
                else
                {
                    AlertController ac = new AlertController(); //Alert message
                    AlertController.txt="ENo. doesnot exist !";
            
                    Parent root = FXMLLoader.load(getClass().getResource("Alert.fxml"));    //Load Alert.fxml
                    Stage stage1 = new Stage();
                    stage1.initStyle(StageStyle.UNDECORATED);
                    Scene scene1 = new Scene(root);
                    stage1.setScene(scene1);
                    stage1.show();
                }
            }
            
        } 
        catch (ClassNotFoundException | SQLException ex) 
        {
            Logger.getLogger(DeleteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
     
    } 
}
    

