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
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import static mallmang.SignupwinController.mess;





public class ClothesController implements Initializable 
{

    int i,j,k;
    int val;
    int q;
    int l;
    
    int m;
    int pg;
    int s;
    int si;
    int ver=1;
    
    int ch_no;
    
    
    public static int thememode=1;

    String ig[]=new String[1000];
    String des[]=new String[1000];
    String cost[]=new String[1000];
    String sig[]=new String[1000];
    String cid[]=new String[1000];

    @FXML
    private Label sback;
    @FXML
    private ImageView img1;
    @FXML
    private ImageView img2;
    @FXML
    private ImageView img3;
    @FXML
    private ImageView img4;
    @FXML
    private ImageView img5;
    @FXML
    private ImageView img6;
    @FXML
    private ImageView img7;
    @FXML
    private ImageView img8;
    @FXML
    private ImageView img9;
    @FXML
    private ImageView img10;
    @FXML
    private ImageView img11;
    @FXML
    private ImageView img12;
    @FXML
    private ChoiceBox<?> ch;

    
    

    ObservableList list=FXCollections.observableArrayList(); //Choice box Observable List
    @FXML
    private Label lab;
    @FXML
    private Label lab1;
    @FXML
    private Label fd1;
    @FXML
    private AnchorPane cl1;
    @FXML
    private ImageView imgsrc;
    @FXML
    private AnchorPane bg;
    @FXML
    private AnchorPane a1;
    @FXML
    private AnchorPane a2;
    @FXML
    private AnchorPane a3;
    @FXML
    private AnchorPane a4;
    @FXML
    private AnchorPane a5;
    @FXML
    private AnchorPane a6;
    @FXML
    private AnchorPane a7;
    @FXML
    private AnchorPane a8;
    @FXML
    private AnchorPane a9;
    @FXML
    private AnchorPane ma;
    @FXML
    private ChoiceBox<?> set;
    @FXML
    private TextArea pglab;
    @FXML
    private ScrollPane srcpane;
    @FXML
    private Label ind;
    @FXML
    private Button lgout;
    @FXML
    private Label uname;
    @FXML
    private Label pgdw;
    @FXML
    private AnchorPane a10;
    
    @FXML
    private AnchorPane a11;
    
    @FXML
    private AnchorPane a12;
    @FXML
    private Label cst1;
    @FXML
    private AnchorPane cl2;
    @FXML
    private Label fd2;
    @FXML
    private Label cst2;
    @FXML
    private AnchorPane cl3;
    @FXML
    private Label fd3;
    @FXML
    private Label cst3;
    @FXML
    private AnchorPane cl4;
    @FXML
    private Label cst4;
    @FXML
    private AnchorPane cl5;
    @FXML
    private Label fd5;
    @FXML
    private Label cst5;
    @FXML
    private AnchorPane cl6;
    @FXML
    private Label fd6;
    @FXML
    private Label cst6;
    @FXML
    private AnchorPane cl7;
    @FXML
    private Label fd7;
    @FXML
    private Label cst7;
    @FXML
    private AnchorPane cl8;
    @FXML
    private Label fd8;
    @FXML
    private Label cst8;
    @FXML
    private AnchorPane cl9;
    @FXML
    private Label fd9;
    @FXML
    private Label cst9;
    @FXML
    private AnchorPane cl10;
    @FXML
    private Label fd10;
    @FXML
    private Label cst10;
    @FXML
    private AnchorPane cl11;
    @FXML
    private Label fd11;
    @FXML
    private Label cst11;
    @FXML
    private AnchorPane cl12;
    @FXML
    private Label fd12;
    @FXML
    private Label cst12;
    @FXML
    private Label fd4;
    @FXML
    private TextField search;
    @FXML
    private Button buy;
    
    
    
    
    
    
    
    @FXML
    public void handleClose(MouseEvent event)
    {
        try 
        {

                    Class.forName("oracle.jdbc.OracleDriver");
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","DBMSPROJECT","mall@12");
                    java.sql.Statement stat=con.createStatement();
                    String query="delete from cart";
                    stat.execute(query);
                    
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
        
        Stage stage = (Stage) sback.getScene().getWindow();
        stage.hide();
        
        
        Parent root = FXMLLoader.load(getClass().getResource("MenWomSel.fxml"));
        Stage stage1 = new Stage();
        stage1.initStyle(StageStyle.UNDECORATED);
        Scene scene1 = new Scene(root);
        stage1.setScene(scene1);
        stage1.show();
    }
    
    
    
    @FXML
    public void srchover(MouseEvent event) 
    {
                
        File file = new File("C:\\Users\\USER\\Documents\\NetBeansProjects\\MallMang\\src\\mallmang\\images\\src.png");
        Image image = new Image(file.toURI().toString());
        imgsrc.setImage(image);
        
    }
    
    @FXML
    public void srchoverover(MouseEvent event) 
    {    
        File file = new File("");
        Image image = new Image(file.toURI().toString());
        imgsrc.setImage(image);
    }
    
    public void Darkmode() 
    {  
        ViewItemController vc=new ViewItemController();
        
        ma.setStyle("-fx-background-color:#666B6F");
        bg.setStyle("-fx-background-color:#000000");
        lab1.setStyle("-fx-text-fill:#ffffff");
        a1.setStyle("-fx-text-fill:#000000");
        a2.setStyle("-fx-text-fill:#000000");
        a3.setStyle("-fx-text-fill:#000000");
        a4.setStyle("-fx-text-fill:#000000");
        a5.setStyle("-fx-text-fill:#000000");
        a6.setStyle("-fx-text-fill:#000000");
        a7.setStyle("-fx-text-fill:#000000");
        a8.setStyle("-fx-text-fill:#000000");
        a9.setStyle("-fx-text-fill:#000000");
        a10.setStyle("-fx-text-fill:#000000");
        a11.setStyle("-fx-text-fill:#000000");
        a12.setStyle("-fx-text-fill:#000000");
        
        thememode=0;
        
    }
    
    public void Defaultmode() 
    { 
        ma.setStyle("-fx-background-color: #DEF0FF");
        bg.setStyle("-fx-background-color:#ffffff");
        lab1.setStyle("-fx-text-fill:#000000");
        thememode=1;
        
    }
    
    
    
    
   public void Choice1()
   {
       list.removeAll(list);
       final String st[]={"Dark mode","Default mode"};
       list.addAll(st);
       set.getItems().addAll(list);
       
       set.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>(){
            @Override
            public void changed(ObservableValue ov,Number value,Number new_value)
                {
                    val=new_value.intValue();

                    if(val==0)
                    {
                       Darkmode(); 
                    }
                    else if(val==1)
                    {
                        Defaultmode();  
                    }
                      
                }});
   }
   
   
   
    
    
    
    
    public void Choice()
    {
        lab.setText("Sort by: Featured");
        list.removeAll(list);
        final String s[]={"Featured","Price:Low to High","Price:High to Low"};
        list.addAll(s);
        ch.getItems().addAll(list);
        
        ch.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>(){
            @Override
            public void changed(ObservableValue ov,Number value,Number new_value)
                {
                    lab.setText(null);
                    lab1.setText("Sort by:");
                    String txt=s[new_value.intValue()];
                    System.out.println(txt);  
                    
                    int ch=new_value.intValue(); // CHOICE TO SORT
                    if(ch==0)
                    {
                        j=0;
                        pglab.setText("");
                        ch_no=0;
                        Display();
                        
                    }
                    else if(ch==1)
                    {
                        j=0;
                        ch_no=1;
                        pglab.setText("");
                        Display();
                    }
                    else if(ch==2)
                    {
                        j=0;
                        ch_no=2;
                        pglab.setText("");
                        Display();
                    }
                    
                    
                }

        });
        
        

        
    }
    
    
    
    public void Display()
    {
        
        try  //Result set for Images of Clothes
        {

                    Class.forName("oracle.jdbc.OracleDriver");
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","DBMSPROJECT","mall@12");
                    java.sql.Statement stat=con.createStatement();
           
                   String query=null;
                            
                   if(ch_no==0)
                   {
                        query="select * from men";
                   }
                   else if(ch_no==1)
                   {
                       query="select * from men order by cost";
                   }
                   else if(ch_no==2)
                   {
                       query="select * from men order by cost desc";
                   }
                    
                    

                    ResultSet rs = stat.executeQuery(query);
                    i=0;
                    while (rs.next())
                    {
                        if(rs.getString("CATID").equals("M00"))
                            continue;
        
                        ig[i]= rs.getString("image");
                        des[i]=rs.getString("description");
                        cid[i]=rs.getString("CATID");
                        cost[i]= rs.getString("cost");
                        i++;
        
                    }
                    stat.close();
                    con.close();
        }
        catch (ClassNotFoundException|SQLException ex) 
        {
                    Logger.getLogger(ClothesController.class.getName()).log(Level.SEVERE, null, ex);
        } 
            
    
        ind.setText("1");
        pgdw.setText("1");
        
        if(ig[j]!=null)
        {
            File file1 = new File(ig[j]);
            Image image1 = new Image(file1.toURI().toString());
            img1.setImage(image1); //Set Image
            fd1.setText(des[j]); //Set Description 
            cst1.setText("₹"+cost[j]);  //Set Cost
            j++;
        }
          
        if(ig[j]!=null)
        {
            File file2 = new File(ig[j]);
            Image image2 = new Image(file2.toURI().toString());
            img2.setImage(image2);
            fd2.setText(des[j]);
            cst2.setText("₹"+cost[j]);
            j++;
        }
        
        if(ig[j]!=null)
        {
        File file3 = new File(ig[j]);
        Image image3 = new Image(file3.toURI().toString());
        img3.setImage(image3);
        fd3.setText(des[j]);
        cst3.setText("₹"+cost[j]);
        j++;
        }
        
        if(ig[j]!=null)
        {
        File file4 = new File(ig[j]);
        Image image4 = new Image(file4.toURI().toString());
        img4.setImage(image4);
        fd4.setText(des[j]);
        cst4.setText("₹"+cost[j]);
        j++;
        }
        
        if(ig[j]!=null)
        {
        File file5 = new File(ig[j]);
        Image image5 = new Image(file5.toURI().toString());
        img5.setImage(image5);
        fd5.setText(des[j]);
        cst5.setText("₹"+cost[j]);
        j++;
        }
        
        if(ig[j]!=null)
        {
        File file6 = new File(ig[j]);
        Image image6 = new Image(file6.toURI().toString());
        img6.setImage(image6);
        fd6.setText(des[j]);
        cst6.setText("₹"+cost[j]);
        j++;
        }
        
        if(ig[j]!=null)
        {
        File file7 = new File(ig[j]);
        Image image7 = new Image(file7.toURI().toString());
        img7.setImage(image7);
        fd7.setText(des[j]);
        cst7.setText("₹"+cost[j]);
        j++;
        }
        
        
        if(ig[j]!=null)
        {
        File file8 = new File(ig[j]);
        Image image8 = new Image(file8.toURI().toString());
        img8.setImage(image8);
        fd8.setText(des[j]);
        cst8.setText("₹"+cost[j]);
        j++;
        }
        
        
        if(ig[j]!=null)
        {
        File file9 = new File(ig[j]);
        Image image9 = new Image(file9.toURI().toString());
        img9.setImage(image9);
        fd9.setText(des[j]);
        cst9.setText("₹"+cost[j]);
        j++;
        }
        
        
        if(ig[j]!=null)
        {
        File file10 = new File(ig[j]);
        Image image10 = new Image(file10.toURI().toString());
        img10.setImage(image10);
        fd10.setText(des[j]);
        cst10.setText("₹"+cost[j]);
        j++;
        }
        
        if(ig[j]!=null)
        {
        File file11 = new File(ig[j]);
        Image image11 = new Image(file11.toURI().toString());
        img11.setImage(image11);
        fd11.setText(des[j]);
        cst11.setText("₹"+cost[j]);
        j++;
        }
        
        if(ig[j]!=null)
        {
        File file12 = new File(ig[j]);
        Image image12 = new Image(file12.toURI().toString());
        img12.setImage(image12);
        fd12.setText(des[j]);
        cst12.setText("₹"+cost[j]);
        j++;
        }
        
        
        System.out.println("No of pics"+j);
        
        int page=0,rm;
        if(i>12)
        {
        if((i%12)==0)
        {
            rm=i/12;
            page=rm;
        }
        else if((i%12)!=0)
        {
            rm=i/12;
            rm=rm+1;
            page=rm;
        }
        }
        else
        {
            page=1;
        }
        
        pg=page;
        System.out.println(page);
        
        pglab.setEditable(false);
  
        
        for(int p=1;p<=page;p++)
        {
            Integer.toString(p);
            pglab.appendText(" "+p+" ");
        }

    }
    
    
    @FXML
    public void Next(MouseEvent event) //Next Window Of Shopping
    {
        srcpane.setVvalue(0.0);
        int trg=0;

        if(ig[j]!=null)
        {
            ver++;
        if(ig[j]!=null)
        {
            File file1 = new File(ig[j]);
            Image image1 = new Image(file1.toURI().toString());
            img1.setImage(image1);
            fd1.setText(des[j]);
            cst1.setText("₹"+cost[j]);
            j++;
            q++;
        }
        else
        {
            File file1 = new File("");
            Image image1 = new Image(file1.toURI().toString());
            img1.setImage(image1);
            fd1.setText("");
            cst1.setText("");
            j++;
        }
          
        if(ig[j]!=null)
        {
        File file2 = new File(ig[j]);
        Image image2 = new Image(file2.toURI().toString());
        img2.setImage(image2);
        fd2.setText(des[j]);
        cst2.setText("₹"+cost[j]);
        j++;
        q++;
        }
        else
        {
        File file2 = new File("");
        Image image2 = new Image(file2.toURI().toString());
        img2.setImage(image2);
        fd2.setText("");
        cst2.setText("");
        j++;

            
        }
        
        if(ig[j]!=null)
        {
        File file3 = new File(ig[j]);
        Image image3 = new Image(file3.toURI().toString());
        img3.setImage(image3);
        fd3.setText(des[j]);
        cst3.setText("₹"+cost[j]);
        j++;
        q++;
        }
        else
        {
        File file3 = new File("");
        Image image3 = new Image(file3.toURI().toString());
        img3.setImage(image3);
        fd3.setText("");
        cst3.setText("");
        j++;
        }
        
        if(ig[j]!=null)
        {
        File file4 = new File(ig[j]);
        Image image4 = new Image(file4.toURI().toString());
        img4.setImage(image4);
        fd4.setText(des[j]);
        cst4.setText("₹"+cost[j]);
        j++;
        q++;
        }
        else
        {
        File file4 = new File("");
        Image image4 = new Image(file4.toURI().toString());
        img4.setImage(image4);
        fd4.setText("");
        cst4.setText("");
        j++;
            
        }
        
        if(ig[j]!=null)
        {
        File file5 = new File(ig[j]);
        Image image5 = new Image(file5.toURI().toString());
        img5.setImage(image5);
        fd5.setText(des[j]);
        cst5.setText("₹"+cost[j]);
        j++;
        q++;
        }
        else
        {
        File file5 = new File("");
        Image image5 = new Image(file5.toURI().toString());
        img5.setImage(image5);
        fd5.setText("");
        cst5.setText("");
        j++;
            
        }
        
        if(ig[j]!=null)
        {
        File file6 = new File(ig[j]);
        Image image6 = new Image(file6.toURI().toString());
        img6.setImage(image6);
        fd6.setText(des[j]);
        cst6.setText("₹"+cost[j]);
        j++;
        q++;
        }
        else
        {
        File file6 = new File("");
        Image image6 = new Image(file6.toURI().toString());
        img6.setImage(image6);
        fd6.setText("");
        cst6.setText("");
        j++;
            
        }
        
        if(ig[j]!=null)
        {
        File file7 = new File(ig[j]);
        Image image7 = new Image(file7.toURI().toString());
        img7.setImage(image7);
        fd7.setText(des[j]);
        cst7.setText("₹"+cost[j]);
        j++;
        q++;
        }
        else
        {
        File file7 = new File("");
        Image image7 = new Image(file7.toURI().toString());
        img7.setImage(image7);
        fd7.setText("");
        cst7.setText("");
        j++;
            
        }
        
        
        if(ig[j]!=null)
        {
        File file8 = new File(ig[j]);
        Image image8 = new Image(file8.toURI().toString());
        img8.setImage(image8);
        fd8.setText(des[j]);
        cst8.setText("₹"+cost[j]);
        j++;
        q++;
        }
        else
        {
            File file8 = new File("");
        Image image8 = new Image(file8.toURI().toString());
        img8.setImage(image8);
        fd8.setText("");
        cst8.setText("");
        j++;
            
        }
        
        
        if(ig[j]!=null)
        {
        File file9 = new File(ig[j]);
        Image image9 = new Image(file9.toURI().toString());
        img9.setImage(image9);
        fd9.setText(des[j]);
        cst9.setText("₹"+cost[j]);
        j++;
        q++;
        }
        else
        {
        File file9 = new File("");
        Image image9 = new Image(file9.toURI().toString());
        img9.setImage(image9);
        fd9.setText("");
        cst9.setText("");
        j++;
            
        }
        if(ig[j]!=null)
        {
        File file10 = new File(ig[j]);
        Image image10 = new Image(file10.toURI().toString());
        img10.setImage(image10);
        fd10.setText(des[j]);
        cst10.setText("₹"+cost[j]);
        j++;
        q++;
        }
        else
        {
        File file10 = new File("");
        Image image10 = new Image(file10.toURI().toString());
        img10.setImage(image10);
        fd10.setText("");
        cst10.setText("");
        j++;
            
        }
        
        if(ig[j]!=null)
        {
        File file11 = new File(ig[j]);
        Image image11 = new Image(file11.toURI().toString());
        img11.setImage(image11);
        fd11.setText(des[j]);
        cst11.setText("₹"+cost[j]);
        j++;
        q++;
        }
        else
        {
        File file11 = new File("");
        Image image11 = new Image(file11.toURI().toString());
        img11.setImage(image11);
        fd11.setText("");
        cst11.setText("");
        j++;
            
        }
        
        if(ig[j]!=null)
        {
        File file12 = new File(ig[j]);
        Image image12 = new Image(file12.toURI().toString());
        img12.setImage(image12);
        fd12.setText(des[j]);
        cst12.setText("₹"+cost[j]);
        j++;
        q++;
        }
        else
        {
        File file12 = new File("");
        Image image12 = new Image(file12.toURI().toString());
        img12.setImage(image12);
        fd12.setText("");
        cst12.setText("");
        j++;
        trg=1; 
        }

        m=j;
        int k=j;
        System.out.println(ig[q]);
        if(trg==1 && ig[k-12]==null)
        {
            j=j-12;
            m=j;
            --ver;
            System.out.println("trg");
        }
        System.out.println("This"+j);
        System.out.println("ver"+ver);

        }
        ind.setText(""+ver);
        pgdw.setText(""+ver);
        
        
    }
    
    
    @FXML
    public void Previous(MouseEvent event) //Previous Window Of Shopping
    {
         
        if(ver>=2)
        {

        
        if(m>=12)
        {
            m=m-24;
            System.out.println("m "+m);
        srcpane.setVvalue(0.0);
        if(ig[m]!=null)
        {
            File file1 = new File(ig[m]);
            Image image1 = new Image(file1.toURI().toString());
            img1.setImage(image1);
            fd1.setText(des[m]);
            cst1.setText("₹"+cost[m]);
            m++;
        }
        else
        {
            m++;
        }
        
        if(ig[m]!=null)
        {
        File file2 = new File(ig[m]);
        Image image2 = new Image(file2.toURI().toString());
        img2.setImage(image2);
        fd2.setText(des[m]);
        cst2.setText("₹"+cost[m]);
        m++;

        }
        else
        {
            m++;
        }
       
        
        
        if(ig[m]!=null)
        {
        File file3 = new File(ig[m]);
        Image image3 = new Image(file3.toURI().toString());
        img3.setImage(image3);
        fd3.setText(des[m]);
        cst3.setText("₹"+cost[m]);
        m++;

        }
        else
        {
            m++;
        }
        
        
        
        if(ig[m]!=null)
        {
        File file4 = new File(ig[m]);
        Image image4 = new Image(file4.toURI().toString());
        img4.setImage(image4);
        fd4.setText(des[m]);
        cst4.setText("₹"+cost[m]);
        m++;

        }
        else
        {
            m++;
        }
        
        
        if(ig[m]!=null)
        {
        File file5 = new File(ig[m]);
        Image image5 = new Image(file5.toURI().toString());
        img5.setImage(image5);
        fd5.setText(des[m]);
        cst5.setText("₹"+cost[m]);
        m++;

        }
        else
        {
            m++;
        }
        
        if(ig[m]!=null)
        {
        File file6 = new File(ig[m]);
        Image image6 = new Image(file6.toURI().toString());
        img6.setImage(image6);
        fd6.setText(des[m]);
        cst6.setText("₹"+cost[m]);
        m++;

        }
        else
        {
            m++;
        }
        
        if(ig[m]!=null)
        {
        File file7 = new File(ig[m]);
        Image image7 = new Image(file7.toURI().toString());
        img7.setImage(image7);
        fd7.setText(des[m]);
        cst7.setText("₹"+cost[m]);
        m++;

        }
        else
        {
            m++;
        }
        
        
        if(ig[m]!=null)
        {
        File file8 = new File(ig[m]);
        Image image8 = new Image(file8.toURI().toString());
        img8.setImage(image8);
        fd8.setText(des[m]);
        cst8.setText("₹"+cost[m]);
        m++;

        }
        else
        {
            m++;
        }
        
        
        if(ig[m]!=null)
        {
        File file9 = new File(ig[m]);
        Image image9 = new Image(file9.toURI().toString());
        img9.setImage(image9);
        fd9.setText(des[m]);
        cst9.setText("₹"+cost[m]);
        m++;

        }
        else
        {
            m++;
        }
        
        if(ig[m]!=null)
        {
        File file10 = new File(ig[m]);
        Image image10 = new Image(file10.toURI().toString());
        img10.setImage(image10);
        fd10.setText(des[m]);
        cst10.setText("₹"+cost[m]);
        m++;

        }
        else
        {
            m++;
        }
        
        if(ig[m]!=null)
        {
        File file11 = new File(ig[m]);
        Image image11 = new Image(file11.toURI().toString());
        img11.setImage(image11);
        fd11.setText(des[m]);
        cst11.setText("₹"+cost[m]);
        m++;

        }
        else
        {
            m++;
        }
        
        if(ig[m]!=null)
        {
        File file12 = new File(ig[m]);
        Image image12 = new Image(file12.toURI().toString());
        img12.setImage(image12);
        fd12.setText(des[m]);
        cst12.setText("₹"+cost[m]);
        m++;
        
        }
        else
        {
            m++;
           
        }
        
        
            j=m;
            ver--;
            
        
        ind.setText(""+ver);
        pgdw.setText(""+ver);
        }
        }
        
    }
    
    
    @FXML
    public void LogOut(MouseEvent event) throws IOException
    {
        
        try 
        {

                    Class.forName("oracle.jdbc.OracleDriver");
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","DBMSPROJECT","mall@12");
                    java.sql.Statement stat=con.createStatement();
                    String query="delete from cart";
                    stat.execute(query);
                    
                    stat.close();
                    con.close();
        }
        catch (ClassNotFoundException|SQLException ex) 
        {
                    Logger.getLogger(ClothesController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
        Stage stage = (Stage) lgout.getScene().getWindow();
        stage.hide();

        Parent root = FXMLLoader.load(getClass().getResource("Userwin.fxml"));
        Stage stage1 = new Stage();
        stage1.initStyle(StageStyle.UNDECORATED);
        Scene scene3 = new Scene(root);
        stage1.setScene(scene3);
        stage1.show();
    }
    
    
    
    
    //View Item
    public void Onclkimg1(MouseEvent event) throws IOException
    {
        
        
    }
    
    @FXML
    public void Clkimg1(MouseEvent event) throws IOException
    {
        ViewItemController vc = new ViewItemController();
  
       Image imag=img1.getImage();
       String ds=fd1.getText();    //Get description
       String ct= cst1.getText();  //Get Cost
       if(imag!=null && !ds.isEmpty() && !ct.isEmpty())
       {
            ViewItemController.Display(imag,ds,ct);
            Parent root = FXMLLoader.load(getClass().getResource("ViewItem.fxml"));
            Stage stage1 = new Stage();
            stage1.initStyle(StageStyle.UNDECORATED);
            Scene scene3 = new Scene(root);
            stage1.setScene(scene3);
            stage1.show();
           
       }
    }
    
    
    @FXML
    public void Clkimg2(MouseEvent event) throws IOException
    {
        ViewItemController vc = new ViewItemController();
        
       Image imag=img2.getImage();
       String ds=fd2.getText();    //Get description
       String ct= cst2.getText();  //Get Cost

       if(imag!=null && !ds.isEmpty() && !ct.isEmpty())
       {
            ViewItemController.Display(imag,ds,ct);
            Parent root = FXMLLoader.load(getClass().getResource("ViewItem.fxml"));
            Stage stage1 = new Stage();
            stage1.initStyle(StageStyle.UNDECORATED);
            Scene scene3 = new Scene(root);
            stage1.setScene(scene3);
            stage1.show();
           
       }
        
    }
    
    
    @FXML
    public void Clkimg3(MouseEvent event) throws IOException
    {
        ViewItemController vc = new ViewItemController();
        
       Image imag=img3.getImage();
       String ds=fd3.getText();    //Get description
       String ct= cst3.getText();  //Get Cost

       if(imag!=null && !ds.isEmpty() && !ct.isEmpty())
       {
            ViewItemController.Display(imag,ds,ct);
            Parent root = FXMLLoader.load(getClass().getResource("ViewItem.fxml"));
            Stage stage1 = new Stage();
            stage1.initStyle(StageStyle.UNDECORATED);
            Scene scene3 = new Scene(root);
            stage1.setScene(scene3);
            stage1.show();
           
       }
        
    }
    
    
    @FXML
    public void Clkimg4(MouseEvent event) throws IOException
    {
        ViewItemController vc = new ViewItemController();
        
       Image imag=img4.getImage();
       String ds=fd4.getText();    //Get description
       String ct= cst4.getText();  //Get Cost

       if(imag!=null && !ds.isEmpty() && !ct.isEmpty())
       {
            ViewItemController.Display(imag,ds,ct);
            Parent root = FXMLLoader.load(getClass().getResource("ViewItem.fxml"));
            Stage stage1 = new Stage();
            stage1.initStyle(StageStyle.UNDECORATED);
            Scene scene3 = new Scene(root);
            stage1.setScene(scene3);
            stage1.show();
           
       }
        
    }
    
    
    @FXML
    public void Clkimg5(MouseEvent event) throws IOException
    {
        ViewItemController vc = new ViewItemController();
        
       Image imag=img5.getImage();
       String ds=fd5.getText();    //Get description
       String ct= cst5.getText();  //Get Cost

       if(imag!=null && !ds.isEmpty() && !ct.isEmpty())
       {
            ViewItemController.Display(imag,ds,ct);
            Parent root = FXMLLoader.load(getClass().getResource("ViewItem.fxml"));
            Stage stage1 = new Stage();
            stage1.initStyle(StageStyle.UNDECORATED);
            Scene scene3 = new Scene(root);
            stage1.setScene(scene3);
            stage1.show();
           
       }
        
    }
    
    
    @FXML
    public void Clkimg6(MouseEvent event) throws IOException
    {
        ViewItemController vc = new ViewItemController();
        
       Image imag=img6.getImage();
       String ds=fd6.getText();    //Get description
       String ct= cst6.getText();  //Get Cost

       if(imag!=null && !ds.isEmpty() && !ct.isEmpty())
       {
            ViewItemController.Display(imag,ds,ct);
            Parent root = FXMLLoader.load(getClass().getResource("ViewItem.fxml"));
            Stage stage1 = new Stage();
            stage1.initStyle(StageStyle.UNDECORATED);
            Scene scene3 = new Scene(root);
            stage1.setScene(scene3);
            stage1.show();
           
       }
        
    }
    
    
    @FXML
    public void Clkimg7(MouseEvent event) throws IOException
    {
        ViewItemController vc = new ViewItemController();
        
       Image imag=img7.getImage();
       String ds=fd7.getText();    //Get description
       String ct= cst7.getText();  //Get Cost

       if(imag!=null && !ds.isEmpty() && !ct.isEmpty())
       {
            ViewItemController.Display(imag,ds,ct);
            Parent root = FXMLLoader.load(getClass().getResource("ViewItem.fxml"));
            Stage stage1 = new Stage();
            stage1.initStyle(StageStyle.UNDECORATED);
            Scene scene3 = new Scene(root);
            stage1.setScene(scene3);
            stage1.show();
           
       }
        
    }
    
    
    
    @FXML
    public void Clkimg8(MouseEvent event) throws IOException
    {
        ViewItemController vc = new ViewItemController();
        
       Image imag=img8.getImage();
       String ds=fd8.getText();    //Get description
       String ct= cst8.getText();  //Get Cost

       if(imag!=null && !ds.isEmpty() && !ct.isEmpty())
       {
            ViewItemController.Display(imag,ds,ct);
            Parent root = FXMLLoader.load(getClass().getResource("ViewItem.fxml"));
            Stage stage1 = new Stage();
            stage1.initStyle(StageStyle.UNDECORATED);
            Scene scene3 = new Scene(root);
            stage1.setScene(scene3);
            stage1.show();
           
       }
        
    }
    
    
    @FXML
    public void Clkimg9(MouseEvent event) throws IOException
    {
        ViewItemController vc = new ViewItemController();
        
       Image imag=img9.getImage();
       String ds=fd9.getText();    //Get description
       String ct= cst9.getText();  //Get Cost

       if(imag!=null && !ds.isEmpty() && !ct.isEmpty())
       {
            ViewItemController.Display(imag,ds,ct);
            Parent root = FXMLLoader.load(getClass().getResource("ViewItem.fxml"));
            Stage stage1 = new Stage();
            stage1.initStyle(StageStyle.UNDECORATED);
            Scene scene3 = new Scene(root);
            stage1.setScene(scene3);
            stage1.show();
           
       }
        
    }
    
    
    @FXML
    public void Clkimg10(MouseEvent event) throws IOException
    {
        ViewItemController vc = new ViewItemController();
        
       Image imag=img10.getImage();
       String ds=fd10.getText();    //Get description
       String ct= cst10.getText();  //Get Cost

       if(imag!=null && !ds.isEmpty() && !ct.isEmpty())
       {
            ViewItemController.Display(imag,ds,ct);
            Parent root = FXMLLoader.load(getClass().getResource("ViewItem.fxml"));
            Stage stage1 = new Stage();
            stage1.initStyle(StageStyle.UNDECORATED);
            Scene scene3 = new Scene(root);
            stage1.setScene(scene3);
            stage1.show();
           
       }
        
    }
    
    
    @FXML
    public void Clkimg11(MouseEvent event) throws IOException
    {
        ViewItemController vc = new ViewItemController();
        
       Image imag=img11.getImage();
       String ds=fd11.getText();    //Get description
       String ct= cst11.getText();  //Get Cost

       if(imag!=null && !ds.isEmpty() && !ct.isEmpty())
       {
            ViewItemController.Display(imag,ds,ct);
            Parent root = FXMLLoader.load(getClass().getResource("ViewItem.fxml"));
            Stage stage1 = new Stage();
            stage1.initStyle(StageStyle.UNDECORATED);
            Scene scene3 = new Scene(root);
            stage1.setScene(scene3);
            stage1.show();
           
       }
        
    }
    
    @FXML
    public void Clkimg12(MouseEvent event) throws IOException
    {
        ViewItemController vc = new ViewItemController();
        
       Image imag=img12.getImage();
       String ds=fd12.getText();    //Get description
       String ct= cst12.getText();  //Get Cost

       if(imag!=null && !ds.isEmpty() && !ct.isEmpty())
       {
            ViewItemController.Display(imag,ds,ct);
            Parent root = FXMLLoader.load(getClass().getResource("ViewItem.fxml"));
            Stage stage1 = new Stage();
            stage1.initStyle(StageStyle.UNDECORATED);
            Scene scene3 = new Scene(root);
            stage1.setScene(scene3);
            stage1.show();
           
       }
        
    }
    
    
    
    
    @FXML
    private void Buy(MouseEvent event) throws IOException
    {
        
        try
        {

                    Class.forName("oracle.jdbc.OracleDriver");
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","DBMSPROJECT","mall@12");
                    java.sql.Statement stat=con.createStatement();
           
             
                   
                    String query="select * from cart";


                    ResultSet rs = stat.executeQuery(query);
                    
                    if(rs.next())
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
                    else
                    {
                        AlertController ac = new AlertController();
                        AlertController.txt="Cart is Empty !";
                        Parent root = FXMLLoader.load(getClass().getResource("Alert.fxml"));
                        Stage stage1 = new Stage();
                        stage1.initStyle(StageStyle.UNDECORATED);
                        Scene scene1 = new Scene(root);
                        stage1.setScene(scene1);
                        stage1.show();
                                
                    }
                    
                    stat.close();
                    con.close();
        }
        catch (ClassNotFoundException|SQLException ex) 
        {
                    Logger.getLogger(ClothesController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        

        
    }
    
    
    
    
    
    
    
    
    //On Cart Icon Click
    
    @FXML
    public void Cartwin(MouseEvent event) throws IOException 
    {

        Parent root = FXMLLoader.load(getClass().getResource("CCart.fxml"));
        Stage stage1 = new Stage();
        
        stage1.initStyle(StageStyle.UNDECORATED);
        Scene scene3 = new Scene(root);
        stage1.setScene(scene3);
        stage1.show();
  
    
    }
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        
        Choice();
        
        Choice1();
        
        Display();
  
    }  //END OF INITIALIZE

    @FXML
    private void Search(MouseEvent event) 
    {
        String src =search.getText();
        src=src.toUpperCase();
        if(src.equals("FEATURED"))
        {
            Display();
        }
        try
        {

                    Class.forName("oracle.jdbc.OracleDriver");
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","DBMSPROJECT","mall@12");
                    java.sql.Statement stat=con.createStatement();
           
             
                   
                    String query="select * from men where description like'%"+src+"%' escape'\\'";

                    for(int q=0;q<1000;q++)
                    {
                        ig[q]=null;
                    }
                    si=0;
                    ResultSet rs = stat.executeQuery(query);
                    while (rs.next())
                    {
        
                        ig[si]= rs.getString("image");
                        des[si]=rs.getString("description");
                        si++;
        
                    }
                    stat.close();
                    con.close();
        }
        catch (ClassNotFoundException|SQLException ex) 
        {
                    Logger.getLogger(ClothesController.class.getName()).log(Level.SEVERE, null, ex);
        } 

        SearchDisplay();
        
    }
    
    
    public void SearchDisplay()
    {
        ind.setText("1");
        pgdw.setText("1");
        
        ver=1;
        
        System.out.println("Inside Search");
        
        s=0;
        srcpane.setVvalue(0.0);
        if(ig[s]!=null)
        {

        if(ig[s]!=null)
        {
            File file1 = new File(ig[s]);
            Image image1 = new Image(file1.toURI().toString());
            img1.setImage(image1);
            fd1.setText(des[s]);
            cst1.setText("₹"+cost[s]);
            s++;
        }
        else
        {
            File file1 = new File("");
            Image image1 = new Image(file1.toURI().toString());
            img1.setImage(image1);
            fd1.setText("");
            cst1.setText("");
            s++;
        }
          
        if(ig[s]!=null)
        {
        File file2 = new File(ig[s]);
        Image image2 = new Image(file2.toURI().toString());
        img2.setImage(image2);
        fd2.setText(des[s]);
        cst2.setText("₹"+cost[s]);
        s++;
        }
        else
        {
        File file2 = new File("");
        Image image2 = new Image(file2.toURI().toString());
        img2.setImage(image2);
        fd2.setText("");
        cst2.setText("");
        s++;

            
        }
        
        if(ig[s]!=null)
        {
        File file3 = new File(ig[s]);
        Image image3 = new Image(file3.toURI().toString());
        img3.setImage(image3);
        fd3.setText(des[s]);
        cst3.setText("₹"+cost[s]);
        s++;

        }
        else
        {
        File file3 = new File("");
        Image image3 = new Image(file3.toURI().toString());
        img3.setImage(image3);
        fd3.setText("");
        cst3.setText("");
        s++;
        }
        
        if(ig[s]!=null)
        {
        File file4 = new File(ig[s]);
        Image image4 = new Image(file4.toURI().toString());
        img4.setImage(image4);
        fd4.setText(des[s]);
        cst4.setText("₹"+cost[s]);
        s++;
        }
        else
        {
        File file4 = new File("");
        Image image4 = new Image(file4.toURI().toString());
        img4.setImage(image4);
        fd4.setText("");
        cst4.setText("");
        s++;
            
        }
        
        if(ig[s]!=null)
        {
        File file5 = new File(ig[s]);
        Image image5 = new Image(file5.toURI().toString());
        img5.setImage(image5);
        fd5.setText(des[s]);
        cst5.setText("₹"+cost[s]);
        s++;
        }
        else
        {
        File file5 = new File("");
        Image image5 = new Image(file5.toURI().toString());
        img5.setImage(image5);
        fd5.setText("");
        cst5.setText("");
        s++;
            
        }
        
        if(ig[s]!=null)
        {
        File file6 = new File(ig[s]);
        Image image6 = new Image(file6.toURI().toString());
        img6.setImage(image6);
        fd6.setText(des[s]);
        cst6.setText("₹"+cost[s]);
        s++;
        }
        else
        {
        File file6 = new File("");
        Image image6 = new Image(file6.toURI().toString());
        img6.setImage(image6);
        fd6.setText("");
        cst6.setText("");
        s++;
            
        }
        
        if(ig[s]!=null)
        {
        File file7 = new File(ig[s]);
        Image image7 = new Image(file7.toURI().toString());
        img7.setImage(image7);
        fd7.setText(des[s]);
        cst7.setText("₹"+cost[s]);
        s++;
        }
        else
        {
        File file7 = new File("");
        Image image7 = new Image(file7.toURI().toString());
        img7.setImage(image7);
        fd7.setText("");
        cst7.setText("");
        s++;
            
        }
        
        
        if(ig[s]!=null)
        {
        File file8 = new File(ig[s]);
        Image image8 = new Image(file8.toURI().toString());
        img8.setImage(image8);
        fd8.setText(des[s]);
        cst8.setText("₹"+cost[s]);
        s++;
        }
        else
        {
            File file8 = new File("");
        Image image8 = new Image(file8.toURI().toString());
        img8.setImage(image8);
        fd8.setText("");
        cst8.setText("");
        s++;
            
        }
        
        
        if(ig[s]!=null)
        {
        File file9 = new File(ig[s]);
        Image image9 = new Image(file9.toURI().toString());
        img9.setImage(image9);
        fd9.setText(des[s]);
        cst9.setText("₹"+cost[s]);
        s++;
        }
        else
        {
        File file9 = new File("");
        Image image9 = new Image(file9.toURI().toString());
        img9.setImage(image9);
        fd9.setText("");
        cst9.setText("");
        s++;
            
        }
        if(ig[s]!=null)
        {
        File file10 = new File(ig[s]);
        Image image10 = new Image(file10.toURI().toString());
        img10.setImage(image10);
        fd10.setText(des[s]);
        cst10.setText("₹"+cost[s]);
        s++;
        }
        else
        {
        File file10 = new File("");
        Image image10 = new Image(file10.toURI().toString());
        img10.setImage(image10);
        fd10.setText("");
        cst10.setText("");
        s++;
            
        }
        
        if(ig[s]!=null)
        {
        File file11 = new File(ig[s]);
        Image image11 = new Image(file11.toURI().toString());
        img11.setImage(image11);
        fd11.setText(des[s]);
        cst11.setText("₹"+cost[s]);
        s++;
        }
        else
        {
        File file11 = new File("");
        Image image11 = new Image(file11.toURI().toString());
        img11.setImage(image11);
        fd11.setText("");
        cst11.setText("");
        s++;
            
        }
        
        if(ig[s]!=null)
        {
        File file12 = new File(ig[s]);
        Image image12 = new Image(file12.toURI().toString());
        img12.setImage(image12);
        fd12.setText(des[s]);
        cst12.setText("₹"+cost[s]);
        s++;
        }
        else
        {
        File file12 = new File("");
        Image image12 = new Image(file12.toURI().toString());
        img12.setImage(image12);
        fd12.setText("");
        cst12.setText("");
        s++;

            
        }
        
        
        
        int page=0,rm;
        if(si>12)
        {
        if((si%12)==0)
        {
            rm=si/12;
            page=rm;
        }
        else if((si%12)!=0)
        {
            rm=si/12;
            rm=rm+1;
            page=rm;
        }
        }
        else
        {
            page=1;
        }
        
        pg=page;
        System.out.println(page);
        
        pglab.setEditable(false);
 
        pglab.setText("");
        for(int p=1;p<=page;p++)
        {
            Integer.toString(p);
            pglab.appendText(" "+p+" ");
        }
        j=s;
    }
    
    
   
    }

    @FXML
    private void Clear(MouseEvent event) 
    {
        search.clear();
    }
}