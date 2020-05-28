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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.StageStyle;
import javafx.stage.Stage;




public class AddController implements Initializable 
{

    @FXML
    private MenuItem menbtn;
    @FXML
    private AnchorPane Catgory;
    @FXML
    private Label back;
    @FXML
    private Label close;
    
    @FXML
    private TextField catm;
    @FXML
    private TextField typem;
    @FXML
    private TextField colorm;
    
    @FXML
    private MenuItem womenbtn;
    @FXML
    private AnchorPane WCatgory;
    @FXML
    private TextField catw;
    @FXML
    private TextField typew;
    @FXML
    private TextField colorw;
    
    @FXML
    private Button addw;
    @FXML
    private Button addm;
    
    @FXML
    private MenuItem clothesbtn;
    @FXML
    private AnchorPane clothespane;
    @FXML
    private TextField aclothno;
    @FXML
    private TextField asize;
    
    @FXML
    private TextField aquantity;
    @FXML
    private Button addclothes;
    @FXML
    private TextField acatidm;
    @FXML
    private TextField acatidw;
    @FXML
    private TextField imagem;
    @FXML
    private AnchorPane firstpane;
    @FXML
    private TextField mprice;
    @FXML
    private TextField wprice;
    @FXML
    private TextField wimage;
    @FXML
    private MenuBar image1;
    @FXML
    private ImageView image_of_men;
    @FXML
    private ImageView image_of_women;
    
    
    @FXML
    private AnchorPane electronicspane;
    @FXML
    private TextField elecno;
    @FXML
    private TextField Type1;
    @FXML
    private TextField model1;
    @FXML
    private TextField pricee1;
    @FXML
    private TextField brand1;
    @FXML
    private TextField quantitye1;
    @FXML
    private TextField image3;
    @FXML
    private ImageView imageofelectronic;
    @FXML
    private Button addelectronicsbtn;
    
    
    
    
    public void Alert(String mess) throws IOException
    {
        AlertController ac = new AlertController(); //Alert message
        AlertController.txt=mess;
            
        Parent root = FXMLLoader.load(getClass().getResource("Alert.fxml"));    //Load Alert.fxml
        Stage stage1 = new Stage();
        stage1.initStyle(StageStyle.UNDECORATED);
        Scene scene1 = new Scene(root);
        stage1.setScene(scene1);
        stage1.show();
    }
    

    
    
    @FXML
    private void handleback(MouseEvent event) throws IOException 
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
    private void handleclose(MouseEvent event) 
    {
        System.exit(0);
    }


    @FXML
    private void Add_To_Men(ActionEvent event)
    { 
        catm.clear();
        typem.clear();
        colorm.clear();
        imagem.clear();
        mprice.clear();
        image_of_men.setImage(null);
        
        
        catw.clear();
        typew.clear();
        colorw.clear();
        wprice.clear();
        wimage.clear();
        image_of_women.setImage(null);
        
        
        
        aclothno.clear();
        asize.clear();
        aquantity.clear();
        acatidw.clear();
        acatidm.clear();
        
        
        elecno.clear();
        Type1.clear();
        model1.clear();
        brand1.clear();
        pricee1.clear();
        quantitye1.clear();
        image3.clear();
        imageofelectronic.setImage(null);
        
        
        WCatgory.setVisible(false);
        clothespane.setVisible(false); 
        
        Catgory.setVisible(true);
        electronicspane.setVisible(false);
    }


    @FXML
    private void AddM(MouseEvent event) throws ClassNotFoundException, IOException {
        
        
        
        try {
            String mcatid=catm.getText();
            String mtype=typem.getText();
            String mcolor=colorm.getText();
            String imagepath=imagem.getText();
            String Mprice=mprice.getText();
            int rows;
        


            //connects to database
            Class.forName("oracle.jdbc.OracleDriver");
            Connection  con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","DBMSPROJECT","mall@12");
            
            if(mcatid.isEmpty())
            {
                Alert("Enter CatID !");
            }
            
            else if(mtype.isEmpty())
            {
                Alert("Enter Description !");
            }
            else if(mcolor.isEmpty())
            {
                Alert("Enter Colour !");
            }
             
            else if(imagepath.isEmpty())
            {
                Alert("Enter Image Path !");
            }
            else if(Mprice.isEmpty())
            {
                Alert("Enter Price !");
            }
            
            else
            {
                double price=Double.valueOf(Mprice);
                String query1="select CATID from MEN where CATID=?"; 
                PreparedStatement pre=con.prepareStatement(query1);
                   
                pre.setString(1,mcatid);
         
                 ResultSet rs=pre.executeQuery();
            
                if(!rs.next())
                {  
                   String query2="select DESCRIPTION from MEN where DESCRIPTION=?"; 
                    PreparedStatement pre1=con.prepareStatement(query2);
                   
                    pre1.setString(1,mtype);
         
                    ResultSet rs1=pre1.executeQuery();
                    
                    if(!rs1.next())
                    { 
                    
                        //inserts values to MEN table
                        Statement stat=con.createStatement();
                        String query="insert into MEN(CATID,DESCRIPTION,COLOUR,IMAGE,COST)values('"+mcatid+"','"+mtype+"','"+mcolor+"','"+imagepath+"','"+price+"')";
            
                        rows= stat.executeUpdate(query);
                        catm.clear();
                        typem.clear();
                        colorm.clear();
                        imagem.clear();
                        mprice.clear();
                        image_of_men.setImage(null);
                
         
            
                        //if any of the rows are inserted then gives an alert message and goes to the Login page
                        if(rows!=0)
                        {
                            Alert("Values Are Inserted !");
                        }
                    }
                    else
                    {
                        Alert("Desc must be Unique !");
                    }
                }
                else
                {
                    Alert("CatID must be Unique !"); 
                }
            }//else
     
        } //try
        catch (SQLException ex) 
        {
            Logger.getLogger(AddController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    
    @FXML
    private void Add_To_Women(ActionEvent event) {
        
        //clear Men
        catm.clear();
        typem.clear();
        colorm.clear();
        imagem.clear();
        mprice.clear();
        image_of_men.setImage(null);
        
        
        catw.clear();
        typew.clear();
        colorw.clear();
        wprice.clear();
        wimage.clear();
        image_of_women.setImage(null);
        
        
        
        aclothno.clear();
        asize.clear();
        aquantity.clear();
        acatidw.clear();
        acatidm.clear();
        
        
        elecno.clear();
        Type1.clear();
        model1.clear();
        brand1.clear();
        pricee1.clear();
        quantitye1.clear();
        image3.clear();
        imageofelectronic.setImage(null);
        
        WCatgory.setVisible(true);
        Catgory.setVisible(false);
        clothespane.setVisible(false);
        electronicspane.setVisible(false);
    }
    
    
    
    


    @FXML
    private void AddW(MouseEvent event) throws IOException {
        
        
        
         try 
         {
            String wcatid=catw.getText();
            String wtype=typew.getText();
            String wcolor=colorw.getText();
            String Wprice=wprice.getText();
            String Wimage=wimage.getText();
            
            int rows;
            
            
            
            //connects to database
            Class.forName("oracle.jdbc.OracleDriver");
            Connection  con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","DBMSPROJECT","mall@12");
            
            
            if(wcatid.isEmpty())
            {
                Alert("Enter CatID !");
                
            }
            
            else if(wtype.isEmpty())
            {
                Alert("Enter Description !");
            }
            else if(wcolor.isEmpty())
            {
                Alert("Enter Colour !");
            }
            else if (Wimage.isEmpty())
            {
                Alert("Enter Image Path !"); 
            }
            else if (Wprice.isEmpty())
            {
                Alert("Enter Price !");
            }
            else
            {
            
                String query1="select CATID from WOMEN where CATID=?"; 
                PreparedStatement pre=con.prepareStatement(query1);
                   
                pre.setString(1,wcatid);
         
                ResultSet rs=pre.executeQuery();
            
                if(!rs.next())
                {  
                    String query2="select DESCRIPTION from WOMEN where DESCRIPTION=?"; 
                    PreparedStatement pre1=con.prepareStatement(query2);
                   
                    pre1.setString(1,wtype);
         
                    ResultSet rs1=pre1.executeQuery();
                    
                    if(!rs1.next())
                    { 
                        double price=Double.valueOf(Wprice);
                            
                        //inserts values to WOMEN table
                        Statement stat=con.createStatement();
                        String query="insert into WOMEN(CATID,DESCRIPTION,COLOUR,IMAGE,COST)values('"+wcatid+"','"+wtype+"','"+wcolor+"','"+Wimage+"','"+price+"')";
            
                        rows= stat.executeUpdate(query);
                        
                        
                        catw.clear();
                        typew.clear();
                        colorw.clear();
                        wprice.clear();
                        wimage.clear();
                        image_of_women.setImage(null);
 
                        //if any of the rows are inserted then gives an alert message 
                        if(rows!=0)
                        {
                            Alert("Values Are Inserted !");
                        }
                    }
                    else
                    {
                        Alert("Desc must be Unique !");
                    }
                
                }
                else
                {
                    Alert("CatID must be Unique !");
                }
            
            }//else
 
        } //try 
        catch (SQLException | ClassNotFoundException ex) 
        {
            Logger.getLogger(AddController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   

    @FXML
    private void Add_To_Clothes(ActionEvent event) {
        
        catm.clear();
        typem.clear();
        colorm.clear();
        imagem.clear();
        mprice.clear();
        image_of_men.setImage(null);
        
        
        catw.clear();
        typew.clear();
        colorw.clear();
        wprice.clear();
        wimage.clear();
        image_of_women.setImage(null);
        
        
        
        aclothno.clear();
        asize.clear();
        aquantity.clear();
        acatidw.clear();
        acatidm.clear();
        
        
        elecno.clear();
        Type1.clear();
        model1.clear();
        brand1.clear();
        pricee1.clear();
        quantitye1.clear();
        image3.clear();
        imageofelectronic.setImage(null);
        
        WCatgory.setVisible(false);
        Catgory.setVisible(false);
        
        clothespane.setVisible(true);
        electronicspane.setVisible(false);
    }

    @FXML
    private void AddC(MouseEvent event) throws IOException
    {
        
        
        try 
        {
            String clothno=aclothno.getText();
            String size=asize.getText();
            String quanity=aquantity.getText();
            String wcatid=acatidw.getText();
            String mcatid=acatidm.getText();
            int Quantity=0;
            
 
            int rows,rows1;
            
            Class.forName("oracle.jdbc.OracleDriver");
            Connection  con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","DBMSPROJECT","mall@12");
            
            String query4="select CLOTHNO from CLOTHES where CLOTHNO=?"; 
            PreparedStatement pred=con.prepareStatement(query4);
            pred.setString(1,clothno);
         
            ResultSet rst=pred.executeQuery();
            
            
            
            if(clothno.isEmpty())
           {
                Alert("Enter Cloth No. !");
                
           }
            
            
            else if(rst.next())
            {
                Alert("Cloth No. Exists");
            }
            else if(size.isEmpty())
            {
                Alert("Enter Size !");
                
            }
           
    
            
            
            else if(wcatid.isEmpty()&&mcatid.isEmpty())
            {
                Alert("Enter a CatID !"); 
            }
            else if(!wcatid.isEmpty() && !mcatid.isEmpty())
            {
                Alert("Enter only one catID !"); 
            }
        
            
             else if(quanity.isEmpty())
                {
                    Alert("Enter Quantity !");
                }
         
            
            else 
            {
                 Quantity=Integer.valueOf(quanity);
//                 Price=Double.valueOf(price);
                 
                if(wcatid.isEmpty()) 
                {
                
                    String query1="select CATID from MEN where CATID=?"; 
                    PreparedStatement pre=con.prepareStatement(query1);
                   
                    pre.setString(1,mcatid);
         
                    ResultSet rs=pre.executeQuery();
            
                    if(rs.next())
                    {  
                        String query2="select MCATID,CLOTHSIZE from CLOTHES where MCATID=? AND CLOTHSIZE=?"; 
                        PreparedStatement prep=con.prepareStatement(query2);
                   
                        prep.setString(1,mcatid);
                        prep.setString(2,size);
         
                        ResultSet rs1=prep.executeQuery();
                    
                        if(!rs1.next())
                        {
          
                            Statement stat=con.createStatement();
                            String query="insert into CLOTHES(CLOTHNO,CLOTHSIZE,QUANTITY,MCATID)values('"+clothno+"','"+size+"','"+Quantity+"','"+mcatid+"')";
            
                            rows= stat.executeUpdate(query);
                            
                            
                            aclothno.clear();
                            asize.clear();
                            aquantity.clear();
                            acatidw.clear();
                            acatidm.clear();

                            //if any of the rows are inserted then gives an alert message 
                            if(rows!=0)
                            {
                                 Alert("Values are Inserted !");
                            }
                        }
                        else
                        {
                            Alert("Already existing value !"); 
                        }
                    }//values are inserted 
                    else
                    {
                        Alert("Invaild catgory id !");
                    
                    }//for unique catid
                
                }
                else
                {
                
                    String query2="select CATID from WOMEN where CATID=?"; 
                    PreparedStatement pre=con.prepareStatement(query2);
                   
                     pre.setString(1,wcatid);
         
                    ResultSet rs=pre.executeQuery();
            
                    if(rs.next())
                    {  
                    
                        String query3="select WCATID,CLOTHSIZE from CLOTHES where WCATID=? AND CLOTHSIZE=?"; 
                        PreparedStatement prep=con.prepareStatement(query3);
                   
                        prep.setString(1,wcatid);
                        prep.setString(2,size);
         
                        ResultSet rs1=prep.executeQuery();
                    
                        if(!rs1.next())
                        {
                            Statement stat1=con.createStatement();
                            String query1="insert into CLOTHES(CLOTHNO,CLOTHSIZE,QUANTITY,WCATID)values('"+clothno+"','"+size+"','"+Quantity+"','"+wcatid+"')";
            
                            rows1= stat1.executeUpdate(query1);
                            
                            catw.clear();
                            typew.clear();
                            colorw.clear();
                            wprice.clear();
                            wimage.clear();
                            image_of_women.setImage(null);

                            //if any of the rows are inserted then gives an alert message and goes to the Login page
                            if(rows1!=0)
                            {
                                Alert("Values are inserted !");
                            }
                        }
                        else
                        {
                            Alert("Already existing value !");
                        }
                    }//values are inserted 
                    else
                    {
                         Alert("Invaild CatID !");
                    
                    }//end of if for the unique catid   
                 }//to insert with women catid
            }
        } //try 
        catch (SQLException | ClassNotFoundException ex) 
        {
            Logger.getLogger(AddController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void Get_Image(MouseEvent event)
    {   
        
        final FileChooser chooser = new FileChooser();
        Stage stage=(Stage) firstpane.getScene().getWindow();
        chooser.setInitialDirectory(new File("C:\\Users\\USER\\Documents\\NetBeansProjects\\MallMang\\src\\mallmang\\images"));
        File file = chooser.showOpenDialog(stage);
        if (file != null) {
                String fileAsString = file.toString();
                imagem.setText(fileAsString);
                Image image_m = new Image(file.toURI().toString());
                image_of_men.setImage(image_m);
        
        }
        
        
    }

    @FXML
    private void Get_image_women(MouseEvent event)
    {
        final FileChooser chooser = new FileChooser();
        Stage stage=(Stage) firstpane.getScene().getWindow();
        chooser.setInitialDirectory(new File("C:\\Users\\USER\\Documents\\NetBeansProjects\\MallMang\\src\\mallmang\\images"));
        File file = chooser.showOpenDialog(stage);
        if (file != null)
        {
                String fileAsString = file.toString();
                wimage.setText(fileAsString);
                Image image_w = new Image(file.toURI().toString());
                image_of_women.setImage(image_w);
        }
    }   

    @FXML
    private void Add_To_Electronics(ActionEvent event) {
        catm.clear();
        typem.clear();
        colorm.clear();
        imagem.clear();
        mprice.clear();
        image_of_men.setImage(null);
        
        
        catw.clear();
        typew.clear();
        colorw.clear();
        wprice.clear();
        wimage.clear();
        image_of_women.setImage(null);
        
        
        
        aclothno.clear();
        asize.clear();
        aquantity.clear();
        acatidw.clear();
        acatidm.clear();
        
        
        elecno.clear();
        Type1.clear();
        model1.clear();
        brand1.clear();
        pricee1.clear();
        quantitye1.clear();
        image3.clear();
        imageofelectronic.setImage(null);
        
        WCatgory.setVisible(false);
        clothespane.setVisible(false); 
        
        Catgory.setVisible(false);
        electronicspane.setVisible(true);
        
    }

    @FXML
    private void addeleimage(MouseEvent event) 
    {
         final FileChooser chooser = new FileChooser();
        Stage stage=(Stage) firstpane.getScene().getWindow();
        chooser.setInitialDirectory(new File("C:\\Users\\USER\\Documents\\NetBeansProjects\\MallMang\\src\\mallmang\\images"));
        File file = chooser.showOpenDialog(stage);
        if (file != null)
        {
                String fileAsString = file.toString();
                image3.setText(fileAsString);
                Image image_e = new Image(file.toURI().toString());
                imageofelectronic.setImage(image_e);
        }
    }   

    @FXML
    private void AddE(MouseEvent event) throws IOException {
        
        
        
        try 
          {
            
            String eno=elecno.getText();
            String type=Type1.getText();
            String model=model1.getText();
            String brand=brand1.getText();
     
            String price=pricee1.getText();
            String quan=quantitye1.getText();
            String image=image3.getText();
            
            int rows;
            
            
            
            //connects to database
            Class.forName("oracle.jdbc.OracleDriver");
            Connection  con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","DBMSPROJECT","mall@12");
            
            
            if(eno.isEmpty())
            {
                Alert("Enter Electronic No. !");
            }
            
            else if(type.isEmpty())
            {
                Alert("Enter Type !");
            }
            else if(model.isEmpty())
            {
                Alert("Enter Model !");
            }
            else if(brand.isEmpty())
            {
                Alert("Enter Brand !"); 
            }
            else if (price.isEmpty())
            {
                Alert("Enter Price !");
                
            }
            else if(quan.isEmpty())
            {
                Alert("Enter Quantity !"); 
            }
            else if (image.isEmpty())
            {
                Alert("Enter Image Path !");
            }
            
            
            else
            {
            
                String query1="select ENO from ELECTRONICS where ENO=?"; 
                PreparedStatement pre=con.prepareStatement(query1);
                   
                pre.setString(1,eno);
         
                ResultSet rs=pre.executeQuery();
            
                if(!rs.next())
                {  
                    String query2="select TYPE from ELECTRONICS where TYPE=?"; 
                    PreparedStatement pre1=con.prepareStatement(query2);
                   
                    pre1.setString(1,type);
         
                    ResultSet rs1=pre1.executeQuery();
                    
                    if(!rs1.next())
                    {
                        String query3="select MODEL from ELECTRONICS where MODEL=?"; 
                        PreparedStatement pre2=con.prepareStatement(query3);
                   
                        pre2.setString(1,model);
         
                        ResultSet rs2=pre2.executeQuery();
                    
                        if(!rs2.next())
                        {
                    
                            double pricet=Double.valueOf(price);
                            int quantity=Integer.valueOf(quan);
                        
                            
                            //inserts values to WOMEN table
                            Statement stat=con.createStatement();
                            String query="insert into ELECTRONICS(ENO,TYPE,MODEL,BRAND,EPRICE,QUANTITY,IMAGE)values('"+eno+"','"+type+"','"+model+"','"+brand+"','"+pricet+"','"+quantity+"','"+image+"')";
            
                            rows= stat.executeUpdate(query);
                            
                            elecno.clear();
                            Type1.clear();
                            model1.clear();
                            brand1.clear();
                            pricee1.clear();
                            quantitye1.clear();
                            image3.clear();
                            imageofelectronic.setImage(null);
 
                            //if any of the rows are inserted then gives an alert message 
                            if(rows!=0)
                            {
                                Alert("Values are Inserted !");
                            }
                        }
                        else
                        {
                            Alert("Model must be Unique !");
                        }
                    }
                    else
                    {
                       Alert("Type must be Unique !");  
                    }
                
                }
                else
                {
                    Alert("ENO. must be Unique !"); 
                }
            
            }//else
 
        } //try 
        catch (SQLException | ClassNotFoundException ex) 
        {
            Logger.getLogger(AddController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {

    } 
    
    
}