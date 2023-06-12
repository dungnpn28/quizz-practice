/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;
import model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author ACER
 */
public class RegisterDAO extends MyDAO{
    
    public void registerUser(String email, String pass) throws SQLException {
        xSql = "insert into [user]\n"
                + "values(?,?,1)";
        try {
            con = new DBContext().connection;
            ps = con.prepareStatement(xSql);
            ps.setString(1, email);
            ps.setString(2, pass);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
    public User checkUserExist(String email){
        xSql = "select * from [user]\n"
                + "where account = ?";
        try{
            ps = con.prepareStatement(xSql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5));
            }
        }catch (Exception e){
        }
        return null;
    }
    
    public int getID(String email) {
        xSql = "select id from [user]\n"
                + "where account = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }
    
    public void registerProfile(int id, String name, int gender, String dob, String mobile) throws SQLException {
        xSql = "insert into [user_profile]\n"
                + "values(?,NULL,?,?,?,?,GETDATE(),NULL)";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, gender);
            ps.setString(4, dob);
            ps.setString(5, mobile);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
