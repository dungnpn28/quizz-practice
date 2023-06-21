/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;
import model.User;

/**
 *
 * @author Dell
 */
public class UserDAO extends MyDAO {

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
                        rs.getInt(4),
                        rs.getInt(5));

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
                    + "                     [password] = ? and status =1";
            ps = con.prepareStatement(strSelect);
            ps.setString(1, account);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new User(rs.getInt(1),
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
     public User getUserById(int id) {
        try {
            String strSelect = "select id,account,[password],[role_id],[status] from [user] where id = ?";
            ps = con.prepareStatement(strSelect);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5));

            }
        } catch (Exception e) {
            System.out.println("getUserById: " + e.getMessage());
        }
        return null;

    }
      public void changeUser(int id,int role,int status) {
        try {
            String strAdd = "update [user] set role_id = ?,[status] = ? where id = ?";
            ps = con.prepareStatement(strAdd);
            
            ps.setInt(1, role);
            ps.setInt(2, status);
            ps.setInt(3, id);

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("changeUser: " + e.getMessage());
            
        }
    }
     
    

}
