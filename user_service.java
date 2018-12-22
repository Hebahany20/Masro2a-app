/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masro2a;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author new
 */
public class user_service {
    
    
//    app_user obj=new app_user();
   
    
     Connection Connectt = null;
    Statement statement = null;
    PreparedStatement preparedDStatement = null;
    ResultSet resultSet = null;
    
     public void update_userinfo(){
    System.out.println("Enter your Pasword to can Update your information");
        Scanner ob=new Scanner(System.in);
        String pass=ob.next();
        System.out.println("Enter your New name");
        String name=ob.next();
        System.out.println("Enter your New password");
        String pa=ob.next();
        String query="UPDATE user_info " +
                   "SET user_name ="+name+ "and user_password="+pa +"WHERE user_password="+pass;
    try {
            Connectt.prepareStatement(query).executeUpdate();
            System.out.println("your Information is updated successfuly");
        } catch (Exception ex) {
                ex.printStackTrace();

        }  
    }
     
    public void delete_account(){
    System.out.println("Enter your Pasword to can delete the account");
        Scanner ob=new Scanner(System.in);
        String pass=ob.next();
        String query="delete from user_info where password="+pass+"";
      try {
            Connectt.prepareStatement(query).executeUpdate();
            System.out.println("your Account id Deleted");
        } catch (Exception ex) {
                ex.printStackTrace();

        }  
    }
}
