/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import model.User;

/**
 *
 * @author Dell
 */
public class UserDAO extends MyDAO {

    
    
   public User checkAccount(String account){
        try {
            String strSelect = "select * from [user] \n" +
"                     where account = ?";
            ps = con.prepareStatement(strSelect);
            ps.setString(1, account);        
            rs = ps.executeQuery();
            while (rs.next()) {
                return new User(rs.getInt(1), 
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4));
                       
            }
        } catch (Exception e) {
            System.out.println("checkAccount: " + e.getMessage());
        }
        return null;
   }
   public User login(String account, String password){
        try {
            String strSelect = "select * from [user] \n" +
"                     where account = ? and \n" +
"                     [password] = ?";
            ps = con.prepareStatement(strSelect);
            ps.setString(1, account);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new User(rs.getInt(1), 
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4));
                       
            }
        } catch (Exception e) {
            System.out.println("login: " + e.getMessage());
        }
        return null;
       
    }
   
   public void updatePassword(String account, String password){
        try {
            String strAdd = "update [user] set [password] = ? where account = ?";
            ps = con.prepareStatement(strAdd);
            ps.setString(1, password);
            ps.setString(2, account);
           

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("updatePassword: " + e.getMessage());
        }
        }
}
