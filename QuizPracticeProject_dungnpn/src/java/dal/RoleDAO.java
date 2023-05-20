/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Acer
 */
public class RoleDAO {
    
    Connection cnn;
    Statement stm;
    PreparedStatement pstm;
    ResultSet rs;

    private void connect() {
        try {
            cnn = (new DBContext()).connection;
            if (cnn != null) {
                System.out.println("Connect success");
            }
        } catch (Exception e) {
            System.out.println("Fail: " + e.getMessage());
        }
    }

    //get roleName by user id
    public String getRoleNameByUserId(int id) {
        String roleName = "";
        String statement = "SELECT r.name FROM [User] u JOIN [Role] r ON u.role_id = r.id WHERE u.id = ?";
        try {
            connect();
            pstm = cnn.prepareStatement(statement);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            while (rs.next()) {
                roleName = rs.getString("name");
            }
        } catch (Exception e) {
            System.out.println("Fail: " + e.getMessage());
        }
        return roleName;
    }

}
