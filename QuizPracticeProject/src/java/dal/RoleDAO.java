/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

/**
 *
 * @author Acer
 */
public class RoleDAO extends MyDAO{
    
    public String getRoleNameByUserId(int id) {
        String roleName = "";
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
}
