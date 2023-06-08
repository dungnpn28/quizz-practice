/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import java.util.List;
import model.Role;
import model.User;
import model.UserProfile;

/**
 *
 * @author Acer
 */
public class RoleDAO extends MyDAO{
    
    public String getRoleNameByUserId(int id) {
        String roleName = null;
        String statement = "SELECT r.name FROM [User] u JOIN [Role] r ON u.role_id = r.id WHERE u.id = ?";
        try {
            ps = con.prepareStatement(statement);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                roleName = rs.getString("name");
            }
        } catch (Exception e) {
            System.out.println("Fail: " + e.getMessage());
        }
        return roleName;
    }
    public List<Role> getListRole(){
           List<Role> data = new ArrayList<>();
        try {
            String strSelect = "select [id], name from [role]";
            ps = con.prepareStatement(strSelect);
      
            rs = ps.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                Role r = new Role(id,name);
                data.add(r);
            }
        } catch (Exception e) {
            System.out.println("getListRole: " + e.getMessage());
        }
        return data;
    }
}
