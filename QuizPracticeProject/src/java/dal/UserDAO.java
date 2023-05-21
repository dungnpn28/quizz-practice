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
public class UserDAO {

    Connection cnn = null;
    Statement stm =null;
    ResultSet rs =null;
    PreparedStatement pstm= null;
    
    private void connect() {
        try {
            cnn = (new DBContext()).connection;
            if (cnn != null) {
                System.out.println("Connect success");
            }
        } catch (Exception e) {
        }
    }

    public UserDAO() {
        connect();
    }
    
   public User checkAccount(String account){
        try {
            String strSelect = "select * from [user] \n" +
"                     where account = ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, account);        
            rs = pstm.executeQuery();
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
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, account);
            pstm.setString(2, password);
            rs = pstm.executeQuery();
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
            pstm = cnn.prepareStatement(strAdd);
            pstm.setString(1, password);
            pstm.setString(2, account);
           

            pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println("updatePassword: " + e.getMessage());
        }
        }
}
