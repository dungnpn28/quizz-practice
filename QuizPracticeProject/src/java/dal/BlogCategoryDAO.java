/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class BlogCategoryDAO extends MyDAO {
    public String getCategory(int id){
        xSql = "select name from blog_category where id = ?";
        String x = null;
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            String xName;
            if(rs.next()){
                xName = rs.getString("name");
                x = xName;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (x);
    }
}
