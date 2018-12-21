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
import java.sql.Statement;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author new
 */
public class user_access {
    app_user obj=new app_user();
    Connection Connect = null;
    Statement statement = null;
    PreparedStatement preparedDStatement = null;
    ResultSet resultSet = null;
    
    
//    app_user obj=new app_user() ;
    String input , input1;
   Scanner in=new Scanner(System.in);
   public user_access()
    {
     try {
            Class.forName("com.mysql.jdbc.Driver");
            Connect = DriverManager.getConnection("jdbc:mysql://localhost/app?user=root");
            //Don't forget the db name
            statement = Connect.createStatement();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
   public void signup()
 {
      
     System.out.println("***********SIGN UP**************");
     System.out.println("Enter user name :");
     Scanner ob=new Scanner(System.in);
     obj.name=ob.nextLine();
     System.out.println("Enter E-mail :");
     Scanner ob1=new Scanner(System.in);
     obj.password=ob1.nextLine();
     System.out.println("Enter Password :");
     Scanner ob2=new Scanner(System.in);
     obj.password=ob2.nextLine();
     
//      System.out.println("Enter Phone :");
//      Scanner ob3=new Scanner(System.in);
//      obj.phone=ob3.nextInt();
    
 }
   public void save_info() 
 {
     
  String Query = "insert into user_info(user_name,user_password,user_email) values('" + 
       obj.name + "','" + obj.password + "','" + obj.e_mail +  "')";   
  
   
  try {
            Connect.prepareStatement(Query).executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
 }
 public void search(String email , String pass)
 {    app_user user=new app_user() ;
 //user.name=na;
    
     
 String Query="select * " + "from user_info " + "where user_email='" + email+ "' and user_password='" + pass+ "'";
    boolean Excists = false;
  try {
           // Connect.prepareStatement(Query).executeUpdate();
            resultSet = statement.executeQuery(Query);
      while (resultSet.next()){
            user.e_mail=(resultSet.getString("user_email"));
            user.password= (resultSet.getString("user_password"));
           //System.out.println(user.e_mail);
            Excists = true; 
            }    
          
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (Excists) {
            System.out.println(" success ") ;
            
        } else {
            System.out.println(" fail because you should make signup at first ") ;
            System.out.println("1-signup ") ;
            System.out.println("2-close") ;
             Scanner in=new Scanner(System.in) ;
            int ch ;
            ch=in.nextInt();
            if(ch==1)
            {
            signup();
            save_info();
            }
            if(ch==2)
            {
               System.exit(ch);
            }
        }
      
      
      
      
      /*if( user.password== pass && user.e_mail==email )
                System.out.println("Successfully log in");
            else 
                System.out.println(" Error log in !! ");
        } catch (Exception ex) {
            ex.printStackTrace();
            }*/ 
 }
 
    public void log_in()
    {  
         System.out.println("Enter your  E-mail :");
         input=in.next() ;
          obj.e_mail=input ;
          System.out.println("Enter your  Password :");
          input1=in.next() ;
          obj.password=input1 ;  
          search(obj.e_mail ,obj.password);
    }
    
  
}
