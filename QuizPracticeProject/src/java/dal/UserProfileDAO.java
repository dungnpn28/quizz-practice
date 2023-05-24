/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import model.UserProfile;
/**
 *
 * @author ADMIN
 */
public class UserProfileDAO extends MyDAO {

    public String getUserName(int id) {
        xSql = "select full_name \n"
                + "from user_profile where user_id = ?";
        String x = null;
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            String xFull_name;
            
            if (rs.next()) {
                xFull_name = rs.getString("full_name");

                x = xFull_name;
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (x);
    }
    
    public void update(UserProfile x) {
        xSql = "UPDATE [dbo].[user_profile]\n"
                + "   SET \n"
                + "      [avatar]= ?\n"
                + "      ,[full_name]= ?\n"
                + "      ,[gender] = ? \n"
                + "      ,[dob] = ? \n"
                + "      ,[phone_number] = ? \n"
                + "      ,[modified] = GETDATE()\n"
                + " WHERE [user_id] = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, x.getAvatar());
            ps.setString(2, x.getFull_name());
            ps.setInt(3, x.getGender());
            ps.setString(4, x.getDob());
            ps.setString(5, x.phone_number());
            ps.setInt(6, x.getUser_id());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("update: " + e.getMessage());
        }
    }

    public UserProfile getUserProfile(int userId) {
        UserProfile u = null;
        try {
            String strSelect = "select * from [user_profile] "
                    + "where user_id= ?";
            ps = con.prepareStatement(strSelect);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                int user_id = rs.getInt("user_id");
                String avatar = rs.getString("avatar");
                String full_name = rs.getString("full_name");
                int gender = rs.getInt("gender");
                String dob = rs.getString("dob");
                String phone_number = rs.getString("phone_number");
                u = new UserProfile(user_id,avatar, full_name, gender, dob, phone_number);
            }
        } catch (Exception e) {
            System.out.println("getUP:" + e.getMessage());
        }
        return u;
    }
}
