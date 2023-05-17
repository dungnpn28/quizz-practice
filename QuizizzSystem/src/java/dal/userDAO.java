/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import Model.user;
import jakarta.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Dell
 */
public class userDAO extends DBContext {
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

    public userDAO() {
        connect();
    }
   public user login(String account, String password){
        try {
            String strSelect = "select * from [user] \n" +
"                     where account = ? and \n" +
"                     [password] = ?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, account);
            pstm.setString(2, password);
            rs = pstm.executeQuery();
            while (rs.next()) {
                return new user(rs.getInt(1), 
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5));
                       
            }
        } catch (Exception e) {
            System.out.println("login: " + e.getMessage());
        }
        return null;
       
    }
    
    
}
