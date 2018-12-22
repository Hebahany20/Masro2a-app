/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package masro2a;

//import com.mysql.jdbc.PreparedStatement;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.HashMap;
//import javax.servlet.RequestDispatcher;
//import javax.servlet.http.Cookie;
//import javax.servlet.http.HttpSession;
import java.util.Scanner;
import masro2a.DBConnection;
//import javax.servlet.ServletContext;

/**
 *
 * @author new
 */
public class Masro2a {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DBConnection conn = new DBConnection();
            conn.Connectiontomysql();
            user_access us=new user_access();
             item_services obj=new item_services();
             user_service ac=new  user_service();
        int ch,ch1;
         while(true)
         {
          System.out.println("*************WELCOME IN MASRO2A APP**************");
             System.out.println("1-LOGIN");
             System.out.println("2-SIGNUP");
            Scanner in=new Scanner(System.in) ;
            
            ch=in.nextInt(); 
            
            if(ch==1)
            {
                us.log_in();
                
            }
            else if(ch==2)
            {
                us.signup();
                us.save_info();
                
            } while(true)
            {
            System.out.println("*************YOU ARE NOW LOGED IN***********");
            System.out.println("1-UPLOAD A POST");
             System.out.println("2-SEARCH FOR AN POST");
             System.out.println("3-EDIT");
             System.out.println("4-logout");
             ch=in.nextInt();
             if(ch==1)
             {
                 obj.enter_item_info();
                 obj.save_item_info();
                 continue;
             }
             else if(ch==2)
             {
                 obj.search();
                 continue;
             }
             else if(ch==3)
             {
                 System.out.println("1-Update your information");
                 System.out.println("2-Delete your Account");
                 ch1=in.nextInt();
                 if(ch1==1)
                 {
                     ac.update_userinfo();
                     continue;
                 }
                 else if(ch1==2)
                 {
                     ac.delete_account();
                     System.exit(ch);
                 continue;
                 }
                 
             
             }
           
             else if(ch==4)
             {
                 System.exit(ch);
             break;
             
             }
         }}
          //us.signup();
          // us.save_info();
//            us.log_in();
            
//            us.enter_info();
//            us.save_info();
           // Scanner in=new Scanner(System.in) ;
           // String input ;
           // input=in.next();
         
//           obj1.signup();
//           obj1.save_info();
//           obj1.log_in();
//           uploading ob =new uploading();
//           ob.enter_info();
//           ob.save_info();
         
//obj.enter_item_info();
//obj.save_item_info();
//          obj.search();
    }
    
}
