
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
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import static mallmang.ViewItemController.ds;






public class  CCartController implements Initializable {

    @FXML
    private Label cbk;
    @FXML
    private AnchorPane ca1;
    @FXML
    public ImageView ig1;
    @FXML
    private Label des1;
    @FXML
    private Label cs1;
    @FXML
    private Label grdt;
    @FXML
    private AnchorPane ca2;
    @FXML
    private ImageView ig2;
    @FXML
    private Label des2;
    @FXML
    private Label cs2;
    @FXML
    private AnchorPane ca3;
    @FXML
    private ImageView ig3;
    @FXML
    private Label des3;
    @FXML
    private Label cs3;

    Image ig;
    @FXML
    private AnchorPane bg;
    
    int i,j,d;
    int ver=1;
    
    int m;
    
    int pg;
    public static int el;
        
    
    
    Image sig[]=new Image[100];
    String cdes[]=new String[100];
    int cost[]=new int[100];
    int qty[]=new int[100];
    String img[]=new String[100];
    String size[] = new String[100];
    
    
    private Button buy;
    @FXML
    private Label rem1;
    @FXML
    private Label rem2;
    @FXML
    private Label rem3;
    @FXML
    private TextArea pgs;
    @FXML
    private Label curpg;
    @FXML
    private Label qt1;
    @FXML
    private Label qt2;
    @FXML
    private Label qt3;
    @FXML
    private Label size1;
    @FXML
    private Label size2;
    @FXML
    private Label size3;
    
    
    
    
    @FXML
    public void cartback(MouseEvent event) 
    {
        Stage stage = (Stage) cbk.getScene().getWindow();
        stage.close();
        
    }
    

    private void Buynow() throws IOException 
    {
        Stage stage = (Stage) buy.getScene().getWindow();
        stage.close();
        
        
        
        Parent root = FXMLLoader.load(getClass().getResource("FinalBillCart.fxml"));
        Stage stage1 = new Stage();
        stage1.initStyle(StageStyle.UNDECORATED);
        Scene scene1 = new Scene(root);
        stage1.setScene(scene1);
        stage1.show();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @FXML
    public void Rem1(MouseEvent event)
    {
        String ds=des1.getText();
        String sz=size1.getText();
        
        
        Stage stage = (Stage) rem1.getScene().getWindow();
        stage.close();
        
        
        
        try
        {

                    Class.forName("oracle.jdbc.OracleDriver");
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","DBMSPROJECT","mall@12");
                    java.sql.Statement stat=con.createStatement();
                    
           
                    String query=null;
             
                    if(el==0)
                    {
                        query="delete from cart where description= '"+ds+"' and clsize = '"+sz+"'";
                    }
                    else
                    {
                        query="delete from cart where description= '"+ds+"'";
                    }                 
                    System.out.println(query);
                    
                    stat.executeUpdate(query);

                    
                    stat.close();
        }
        catch (ClassNotFoundException|SQLException ex) 
        {
                    Logger.getLogger(ClothesController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        

        
    }
    
    
    @FXML
    public void Rem2(MouseEvent event)
    {
        String ds=des2.getText();
        String sz=size2.getText();

        
        Stage stage = (Stage) rem2.getScene().getWindow();
        stage.close();
        
        
        
        try
        {

                    Class.forName("oracle.jdbc.OracleDriver");
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","DBMSPROJECT","mall@12");
                    java.sql.Statement stat=con.createStatement();
                    String query=null;
             
                    if(el==0)
                    {
                        query="delete from cart where description= '"+ds+"' and clsize = '"+sz+"'";
                    }
                    else
                    {
                        query="delete from cart where description= '"+ds+"'";
                    }
                    System.out.println(query);
                    
                    stat.executeUpdate(query);

                    
                    stat.close();
        }
        catch (ClassNotFoundException|SQLException ex) 
        {
                    Logger.getLogger(ClothesController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        

        
    }
    
    
    @FXML
    public void Rem3(MouseEvent event)
    {
        String ds=des3.getText();
        String sz=size3.getText();

        
        Stage stage = (Stage) rem3.getScene().getWindow();
        stage.close();
        
        
        
        try
        {

                    Class.forName("oracle.jdbc.OracleDriver");
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","DBMSPROJECT","mall@12");
                    java.sql.Statement stat=con.createStatement();
           
             
                   
                    String query=null;
             
                    if(el==0)
                    {
                        query="delete from cart where description= '"+ds+"' and clsize = '"+sz+"'";
                    }
                    else
                    {
                        query="delete from cart where description= '"+ds+"'";
                    }
                    System.out.println(query);
                    
                    stat.executeUpdate(query);

                    
                    stat.close();
        }
        catch (ClassNotFoundException|SQLException ex) 
        {
                    Logger.getLogger(ClothesController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        

        
    }
    
    
    
    @FXML
    public void Next(MouseEvent event)
    {
        
        int trg=0;
        if(sig[j]!=null)
        {
            
            
            ver++;
        if(sig[j]!=null)
        {
            ig1.setImage(sig[j]);
            des1.setText(cdes[j]);
            qt1.setText("x"+qty[j]);
            cs1.setText(""+(cost[j]*qty[j]));
            size1.setText(size[j]);
            j++;


        }
        else
        {
            ig1.setImage(null);
            des1.setText("");
            qt1.setText("");
            cs1.setText("");
            rem1.setStyle("-fx-text-fill:#ffffff");
            ca1.setStyle("-fx-border-color:#ffffff");
            size1.setText("");
            j++;
            
        }
        
        
        if(sig[j]!=null)
        {
            ig2.setImage(sig[j]);
            des2.setText(cdes[j]);
            qt2.setText("x"+qty[j]);
            cs2.setText(""+(cost[j]*qty[j]));
            size2.setText(size[j]);
            j++;

        }
        else
        {
            ig2.setImage(null);
            des2.setText("");
            qt2.setText("");
            cs2.setText("");
            rem2.setStyle("-fx-text-fill:#ffffff");
            ca2.setStyle("-fx-border-color:#ffffff");
            size2.setText("");
            j++;
        }
        
        
        
        if(sig[j]!=null)
        {
            ig3.setImage(sig[j]);
            des3.setText(cdes[j]);
            qt3.setText("x"+qty[j]);
            cs3.setText(""+(cost[j]*qty[j]));
            size3.setText(size[j]);
            j++;

        }
        else
        {
            ig3.setImage(null);
            des3.setText("");
            qt3.setText("");
            cs3.setText("");
            rem3.setStyle("-fx-text-fill:#ffffff");
            ca3.setStyle("-fx-border-color:#ffffff");
            size3.setText("");
            j++;
            trg=1;
        }
        
        m=j;
        int k=j;

        if(trg==1 && sig[k-3]==null)
        {
            j=j-3;
            m=j;
            --ver;
            
        }
        curpg.setText(""+ver);
        
        
        
        }
        
        
    }
    
    
    
    @FXML
    public void Previous(MouseEvent event)
    {
        
        if(ver>=2)
        {
            if(m>=3)
            {
                m=m-6;
                
        if(sig[m]!=null)
        {
            ig1.setImage(sig[m]);
            des1.setText(cdes[m]);
            qt1.setText("x"+qty[m]);
            cs1.setText(""+(cost[m]*qty[m]));
            ca1.setStyle("-fx-border-color:#DA5244");
            rem1.setStyle("-fx-text-fill:black");
            size1.setText(size[m]);
            m++;


        }
        else
        {
            m++;
            
        }
        
        
        if(sig[m]!=null)
        {
            ig2.setImage(sig[m]);
            des2.setText(cdes[m]);
            qt2.setText("x"+qty[m]);
            cs2.setText(""+(cost[m]*qty[m]));
            ca2.setStyle("-fx-border-color:#DA5244");
            rem2.setStyle("-fx-text-fill:black");
            size2.setText(size[m]);
            m++;

        }
        else
        {
            m++;
        }
        
        
        
        if(sig[m]!=null)
        {
            ig3.setImage(sig[m]);
            des3.setText(cdes[m]);
            qt3.setText("x"+qty[m]);
            cs3.setText(""+(cost[m]*qty[m]));
            ca3.setStyle("-fx-border-color:#DA5244");
            rem3.setStyle("-fx-text-fill:black");
            size3.setText(size[m]);
            m++;

        }
        else
        {
            m++;
        }
             j=m;
             ver--;
             curpg.setText(""+ver);
                
                
                
                
            }
        }
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    public void Display()
    {
        
        
        curpg.setText("1");
        
        System.out.println("Inside Display");
        try
        {

                    Class.forName("oracle.jdbc.OracleDriver");
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","DBMSPROJECT","mall@12");
                    java.sql.Statement stat1=con.createStatement();
           
             
                   
                    String query="select * from cart";

                    
                    
                    ResultSet rs = stat1.executeQuery(query);
                    i=0;
                    while (rs.next())
                    {
                        img[i]=rs.getString(2);
                        File file1 = new File(img[i]);
                        Image image1 = new Image(file1.toURI().toString());
                        sig[i]=image1;
                        cdes[i]=rs.getString(3);
                        cost[i]=rs.getInt(7);
                        qty[i]=rs.getInt(6);
                        size[i]=rs.getString(4);
                        i++;
                     
                    }
                    stat1.close();
                    con.close();
        }
        catch (ClassNotFoundException|SQLException ex) 
        {
                    Logger.getLogger(ClothesController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
        
        
        
        
        j=0;
        if(sig[j]!=null)
        {
            ig1.setImage(sig[j]);
            des1.setText(cdes[j]);
            qt1.setText("x"+qty[j]);
            cs1.setText(""+(cost[j]*qty[j]));
            ca1.setStyle("-fx-border-color:#DA5244");
            size1.setText(size[j]);
            j++;

        }
        else
        {
            rem1.setStyle("-fx-text-fill:#ffffff");
        }
        
        
        
        if(sig[j]!=null)
        {
            ig2.setImage(sig[j]);
            des2.setText(cdes[j]);
            qt2.setText("x"+qty[j]);
            cs2.setText(""+(cost[j]*qty[j]));
            ca2.setStyle("-fx-border-color:#DA5244");
            size2.setText(size[j]);
            j++;

        }
        else
        {
            rem2.setStyle("-fx-text-fill:#ffffff");
        }
        
        
        
        if(sig[j]!=null)
        {
            ig3.setImage(sig[j]);
            des3.setText(cdes[j]);
            qt3.setText("x"+qty[j]);
            cs3.setText(""+(cost[j]*qty[j]));
            ca3.setStyle("-fx-border-color:#DA5244");
            size3.setText(size[j]);
            j++;

        }
        else
        {
            rem3.setStyle("-fx-text-fill:#ffffff");
        }
        
        
        
        
        int page=0,rm;
        if(i>3)
        {
        if((i%3)==0)
        {
            rm=i/3;
            page=rm;
        }
        else if((i%3)!=0)
        {
            rm=i/3;
            rm=rm+1;
            page=rm;
        }
        }
        else
        {
            page=1;
        }
        pg=page;
        
        
        
        for(int p=1;p<=page;p++)
        {
            Integer.toString(p);
            pgs.appendText(" "+p+" ");
        }
        
        
        
    }
    
    
    
    
    
    

   
            
            
    
    
    
 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Display();
        pgs.setEditable(false);
    }    

    
    
    
    
}
