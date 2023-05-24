/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

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
}
