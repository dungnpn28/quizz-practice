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

    public User getUsersByID(int xId) {
        xSql = "SELECT *\n"
                + "  FROM [dbo].[user]\n"
                + "  where id = ?";
        String xAccount;
        String xPassword;
        int xRole;
        User x = null;
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, xId);
            rs = ps.executeQuery();
            if (rs.next()) {
                xAccount = rs.getString("account");
                xPassword = rs.getString("password");
                xRole = rs.getInt("role_id");
                x = new User(xId, xAccount, xPassword, xRole);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (x);
    }

    public void updatePassword(User x, String newPassword) {
        xSql = "UPDATE [dbo].[user]\n"
                + "   SET [password] =?\n"
                + " WHERE id = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, newPassword);
            ps.setInt(2, x.getId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User checkAccount(String account) {
        try {
            String strSelect = "select * from [user] \n"
                    + "                     where account = ?";
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

    public User login(String account, String password) {
        try {
            String strSelect = "select * from [user] \n"
                    + "                     where account = ? and \n"
                    + "                     [password] = ?";
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

    public void updatePassword(String account, String password) {
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
