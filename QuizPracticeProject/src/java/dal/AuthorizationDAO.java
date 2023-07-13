/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import model.Authorization;

/**
 *
 * @author Acer
 */
public class AuthorizationDAO extends MyDAO{
    
    public ArrayList<Authorization> getAllowedUrlByRoleId(int roleId) {
        ArrayList<Authorization> authorizationList = new ArrayList<>();
        try {
            String strSelect = "SELECT [url] from [authorization] where role_id=?";
            ps = con.prepareCall(strSelect);
            ps.setInt(1, roleId);
            rs = ps.executeQuery();
            while (rs.next()) {
                String url = rs.getString(1);
                authorizationList.add(new Authorization(url));
            }
        } catch (Exception e) {
            System.out.println("getAllowedUrlByRoleId: " + e.getMessage());
        }
        return authorizationList;
    }
}
