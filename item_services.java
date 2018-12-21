/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masro2a;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author new
 */
public class item_services {
    lost_item obj=new lost_item();
    app_user obj1=new app_user();
     ArrayList<String> info=new ArrayList<>();
    Connection Connectt = null;
    Statement statement = null;
    PreparedStatement preparedDStatement = null;
    ResultSet resultSet = null;
     String input , input1,input2;
   Scanner in=new Scanner(System.in);
    public item_services()
    {
     try {
            Class.forName("com.mysql.jdbc.Driver");
            Connectt = DriverManager.getConnection("jdbc:mysql://localhost/app?user=root");
            //Don't forget the db name
            statement = Connectt.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
      public void enter_item_info()
    {
        while(true)
        {
        System.out.println("Please enter the type of lost item ");
        Scanner in=new Scanner(System.in);
        obj.type_item=in.next();
        if(obj.type_item !=null){continue;} 
        else{ System.out.println("it must not be empty !");enter_item_info();}
        System.out.println("Please enter the color of lost item ");
        Scanner in1=new Scanner(System.in);
        obj.color_item=in1.next();
        if(obj.color_item !=null){continue;} 
        else{ System.out.println("it must not be empty !");enter_item_info();}
        System.out.println("Please enter the location of lost item ");
        Scanner in2=new Scanner(System.in);
        obj.location_item=in2.next();
        if(obj.location_item !=null){continue;} 
        else{ System.out.println("it must not be empty !");enter_item_info();}
         System.out.println("Please enter your mobile phone ");
        Scanner in3=new Scanner(System.in);
        obj1.phone=in3.next();
        if(obj1.phone !=null){continue;} 
        else{ System.out.println("it must not be empty !");enter_item_info();}
        }
    }
       public void save_item_info() 
 {
    
  String Queery ="insert into lost_item(type,color,location,phone) values('" + 
       obj.type_item + "','" + obj.color_item + "','" + obj.location_item +"','" + obj1.phone +  "')";  
  
  try {
            Connectt.prepareStatement(Queery).executeUpdate();
            System.out.println("your post is saved and uploaded");
        } catch (Exception ex) {
                ex.printStackTrace();

        }
 }
       
       public void check(String ty , String c,String loc,String ph)
 {    lost_item obj=new lost_item();
 //user.name=na;
    
     
 String Query="select * " + "from lost_item " + "where type='" + ty+ "' and color='" + c+ "' and location ='" + loc+  "'";
    boolean Excists = false;
  try {
           // Connect.prepareStatement(Query).executeUpdate();
            resultSet = statement.executeQuery(Query);
      while (resultSet.next()){
            obj.type_item=(resultSet.getString("type"));
            obj.color_item= (resultSet.getString("color"));
            obj.location_item= (resultSet.getString("location"));
            obj1.phone= (resultSet.getString("phone"));
           //System.out.println(user.e_mail);
            Excists = true; 
                
            String s=obj.type_item+" "+obj.color_item+" "+obj.location_item+" "+obj1.phone;
            info.add(s);
            }    
          
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (Excists) 
            {
                
            System.out.println("founded  "+info) ;
            }
         else {
            System.out.println(" notfounded ") ;
        }
      
      
      
      
      /*if( user.password== pass && user.e_mail==email )
                System.out.println("Successfully log in");
            else 
                System.out.println(" Error log in !! ");
        } catch (Exception ex) {
            ex.printStackTrace();
            }*/ 
 }
       
       public void search()
    {  
         System.out.println("Enter The type of lost_item you want to search:");
         input=in.next() ;
          obj.type_item=input ;
          System.out.println("Enter The color of lost_item you want to search:");
          input1=in.next() ;
          obj.color_item=input1 ;  
            System.out.println("Enter The location of lost_item you want to search:");
            input2=in.next() ;
            obj.location_item=input2 ;  
          check(obj.type_item ,obj.color_item,obj.location_item,obj1.phone);
    }
       
}
