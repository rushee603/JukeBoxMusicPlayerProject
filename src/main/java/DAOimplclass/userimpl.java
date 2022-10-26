package DAOimplclass;

import juke.box.DBConnection;
import models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class userimpl {
    Connection con = DBConnection.getConnection();
    Scanner Sc = new Scanner(System.in);
    User user = new User();

//------------------------------------- Create Account -----------------------------------------
    public void CreateAccount() {
        try {
            String str = "^[0-9]{10}$";
            String str1 = "[a-zA-Z]";
            System.out.println("Enter Your Mobileno");
            String mobileno = Sc.next();
            Pattern pattern = Pattern.compile(str);
            Matcher matcher = pattern.matcher(mobileno);
            if (matcher.find() == true) {
                user.setMobileno(mobileno);
                System.out.println("Mobile No Added Successfully");
                System.out.println("Enter Your Name");
                String username = Sc.next();
                Pattern pattern1 = Pattern.compile(str1);
                Matcher matcher1 = pattern1.matcher(username);
                if (matcher1.find() == true) {
                    user.setUsername(username);
                    System.out.println("Enter New User id ");
                    String userId = Sc.next();
                    user.setUserId(userId);
                    System.out.println("Enter Your Password ");
                    String password = Sc.next();
                    System.out.println("Confirm Your Password ");
                    String upass2 = Sc.next();
                     user.setPassword(password);
                    if (upass2.equals(password)) {
                        String query = "insert into Users values(?,?,?,?)";
                        PreparedStatement ps1 = con.prepareStatement(query);
                        ps1.setString(1, user.getUserId());
                        ps1.setString(2, user.getUsername());
                        ps1.setString(3, user.getMobileno());
                        ps1.setString(4, user.getPassword());
                        int rows = ps1.executeUpdate();
                        System.out.println("Congratulation Your Account Has Been Created !!");
                    } else {
                        System.out.println("Not Matched, Plz Check Your Password Again !!");
                    }
                } else {
                    System.out.println("Plz Check your Name  ");
                }
            } else {
                System.out.println("Plz Check Your Mobile Number");
            }


        } catch (Exception e) {
            System.out.println(e);
        }

    }

//----------------------------------------- log in part --------------------------------------------
    public boolean login(int userId,String password) throws SQLException {
//        int id;
//        String password;
      //  String validpassword="";
        try {



            String query1 = "select userId,passwords from Users where userid=? and passwords=?";
            PreparedStatement login = con.prepareStatement(query1);

            login.setInt(1, userId);
            login.setString(2,password);

            ResultSet rs = login.executeQuery();
                if(rs.next())
                {
                    rs.close();
                    login.close();
                    return true;

                }
                rs.close();
                login.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;

    }
}


