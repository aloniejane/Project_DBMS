
package mallmang;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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


import javax.mail.internet.*;

import javax.mail.*; 
import javax.mail.Session; 
import java.util.Properties;  
import javax.mail.internet.*; 
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Message.RecipientType.*;







public class  FinalBillCartController implements Initializable {

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
    
    int del=1;
    int Sum;
        
    
    
    static Image sig[]=new Image[100];
    static String cdes[]=new String[100];
    static int cost[]=new int[100];
    static int qty[]=new int[100];
    String img[]=new String[100];
    static int ftotal[]=new int[100];
    @FXML
    private Button buy;

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
    private Label total;
    
    static int buy_now;
    static String cost_now;
    
    
    
    
    @FXML
    public void back(MouseEvent event) throws IOException 
    {
        Stage stage = (Stage) cbk.getScene().getWindow();
        stage.hide();
        
        Parent root = FXMLLoader.load(getClass().getResource("userMain.fxml"));
        Stage stage1 = new Stage();
        stage1.initStyle(StageStyle.UNDECORATED);
        Scene scene1 = new Scene(root);
        stage1.setScene(scene1);
        stage1.show();
        
        
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
            j++;


        }
        else
        {
            ig1.setImage(null);
            des1.setText("");
            qt1.setText("");
            cs1.setText("");

            ca1.setStyle("-fx-border-color:#ffffff");
            j++;
            
        }
        
        
        if(sig[j]!=null)
        {
            ig2.setImage(sig[j]);
            des2.setText(cdes[j]);
            qt2.setText("x"+qty[j]);
            cs2.setText(""+(cost[j]*qty[j]));
            j++;

        }
        else
        {
            ig2.setImage(null);
            des2.setText("");
            qt2.setText("");
            cs2.setText("");

            ca2.setStyle("-fx-border-color:#ffffff");
            j++;
        }
        
        
        
        if(sig[j]!=null)
        {
            ig3.setImage(sig[j]);
            des3.setText(cdes[j]);
            qt3.setText("x"+qty[j]);
            cs3.setText(""+(cost[j]*qty[j]));
            j++;

        }
        else
        {
            ig3.setImage(null);
            des3.setText("");
            qt3.setText("");
            cs3.setText("");

            ca3.setStyle("-fx-border-color:#ffffff");
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
    public void Buy(MouseEvent event) throws IOException, SQLException
    {
        String cid;
        int qty;
        String size;
        String email=" ";
        
        int i=0,j=0;
        
        
        int user_id;
        
         try //Subtract quantity from tables
        {

                    Class.forName("oracle.jdbc.OracleDriver");
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","DBMSPROJECT","mall@12");
                    java.sql.Statement stat=con.createStatement();
                    java.sql.Statement stat2=con.createStatement();
                    java.sql.Statement statr=con.createStatement();
                    java.sql.Statement stat3=con.createStatement();
                    java.sql.Statement stat4=con.createStatement();
                    
                    String query="Select ID,CLSIZE,QUantity from cart";
                    ResultSet rs = stat.executeQuery(query);
                    if(rs.next())
                    {
                        cid=rs.getString("ID");
                        size=rs.getString("CLSIZE");
                        qty=rs.getInt("QUANTITY");
                        
                        String query2="select * from clothes where clothno = '"+cid+"' and clothsize = '"+size+"'";
                        ResultSet rs2 = stat2.executeQuery(query2);
                        if(rs2.next())
                        {
                            String rquery = "select quantity from clothes where clothno = '"+cid+"' and clothsize = '"+size+"'"; 
                            ResultSet rsr = statr.executeQuery(rquery);
                            if(rsr.next())
                            {
                                int rqty=rsr.getInt("QUANTITY");
                                System.out.println("rqty"+rqty);
                                
                                
                                rqty=rqty-qty;
                                String query3="update clothes set quantity = "+rqty+" where clothno = '"+cid+"' and clothsize = '"+size+"'";
                                System.out.println(query3);
                                stat3.executeQuery(query3);
                            }
                            
                        }
                        
                        
                        
                    }
                    
                    
                    stat.close();
                    con.close();
        }
        catch (ClassNotFoundException|SQLException ex) 
        {
                    Logger.getLogger(ClothesController.class.getName()).log(Level.SEVERE, null, ex);
        } 
         
         
         try //Subtract quantity from tables
        {
             
             String id;
             String des;
             int qy;

                    Class.forName("oracle.jdbc.OracleDriver");
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","DBMSPROJECT","mall@12");
                    java.sql.Statement stat=con.createStatement();
                    java.sql.Statement stat2=con.createStatement();
                    java.sql.Statement statr=con.createStatement();
                    java.sql.Statement stat3=con.createStatement();
                    java.sql.Statement stat4=con.createStatement();
                    
                    String query="Select * from cart";
                    ResultSet rs = stat.executeQuery(query);
                   while(rs.next())
                    {
                        id=rs.getString("ID");
                        des=rs.getString("DESCRIPTION");
                        qy=rs.getInt("QUANTITY");
                        
                        String query2="select quantity from electronics where eno = '"+id+"' and type = '"+des+"'";
                        ResultSet rs2 = stat2.executeQuery(query2);
                        if(rs2.next())
                        {
                            String rquery = "select quantity from electronics where eno = '"+id+"'";
                            ResultSet rsr = statr.executeQuery(rquery);
                            if(rsr.next())
                            {
                                int rqty=rsr.getInt("QUANTITY");
                                System.out.println("rqty"+rqty);
                                
                                
                                rqty=rqty-qy;
                                String query3="update electronics set quantity = "+rqty+" where eno = '"+id+"'";
                                System.out.println(query3);
                                stat3.executeQuery(query3);
                            }
                            
                        }
                        
                        
                        
                    }
                    
                    
                    stat.close();
                    con.close();
        }
        catch (ClassNotFoundException|SQLException ex) 
        {
                    Logger.getLogger(ClothesController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
        
        
        
        
        
        
        
        
        Stage stage = (Stage) cbk.getScene().getWindow();
        stage.hide();
        
        
        UserwinController uw =new UserwinController();
        user_id=UserwinController.useride;
        
        try
        {

                    Class.forName("oracle.jdbc.OracleDriver");
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","DBMSPROJECT","mall@12");
                    java.sql.Statement stat=con.createStatement();
                    
                    String query1="{CALL PUTINORDER("+user_id+")}";
                    CallableStatement cstmt=con.prepareCall(query1); 
                    cstmt.execute();
                    
                    String query="{CALL CALCULATETOTAL("+user_id+")}";
                    CallableStatement stmt=con.prepareCall(query); 
                    
                    stmt.execute();  
                    stat.close();
                    con.close();
        }
        catch (ClassNotFoundException|SQLException ex) 
        {
                    Logger.getLogger(ClothesController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","DBMSPROJECT","mall@12");
                     String query3="select EMAIL_ID from USERLOGIN where USERID=?";
                         PreparedStatement prep=con.prepareStatement(query3);
                         
                         prep.setInt(1,user_id);
                         
                         ResultSet rs1=prep.executeQuery();
                         if(rs1.next())
                         {
                             email=rs1.getString("EMAIL_ID");
                         }
                         
                         final String username = "elantemall123@gmail.com";
            final String password = "Elantemalls5$12";

            Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
            prop.put("mail.smtp.port", "587");
             prop.put("mail.smtp.auth", "true");
            prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        Session session;
        session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("elantemall123@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,InternetAddress.parse("elantemall123@gmail.com,"+email)
            );
            message.setSubject("Elante Mall");
            message.setText("Dear Customer ,"
                    + "\n\n Thank You for shoping with us\n\n Elante Mall");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            System.out.println("Mail not found");
        }
     

        
        
        
        Parent root = FXMLLoader.load(getClass().getResource("VLast.fxml"));
        Stage stage1 = new Stage();
        stage1.initStyle(StageStyle.UNDECORATED);
        Scene scene1 = new Scene(root);
        stage1.setScene(scene1);
        stage1.show();
        
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
    
    
    
    
    
    
    

    
    
    
    
    
    public void Display() throws IOException
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
                        ftotal[i]=cost[i]*qty[i];
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
            j++;

        }
        
        
        
        
        if(sig[j]!=null)
        {
            ig2.setImage(sig[j]);
            des2.setText(cdes[j]);
            qt2.setText("x"+qty[j]);
            cs2.setText(""+(cost[j]*qty[j]));
            ca2.setStyle("-fx-border-color:#DA5244");
            j++;

        }
        
        
        
        
        if(sig[j]!=null)
        {
            ig3.setImage(sig[j]);
            des3.setText(cdes[j]);
            qt3.setText("x"+qty[j]);
            cs3.setText(""+(cost[j]*qty[j]));
            ca3.setStyle("-fx-border-color:#DA5244");
            j++;

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
        
        try 
        {
            Display();
        }
        catch (IOException ex) 
        {
            Logger.getLogger(FinalBillCartController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        pgs.setEditable(false);
        
        for(int i=0;i<ftotal.length;i++)
        {
            Sum+=ftotal[i];
        }
        total.setText("Total Amount: ₹"+Sum);
        


    }    

  

    
    
    
    
}

