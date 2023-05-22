/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;
import java.util.ArrayList;
import java.util.List;
import model.User;
/**
 *
 * @author LENOVO
 */
public class UserDAO extends MyDAO{
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
}
