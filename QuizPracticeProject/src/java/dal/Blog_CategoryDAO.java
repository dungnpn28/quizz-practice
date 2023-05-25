/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Blog_Category;

/**
 *
 * @author ADMIN
 */
public class Blog_CategoryDAO extends MyDAO {

    public List<Blog_Category> getCategory() {
        List<Blog_Category> b = new ArrayList<>();
        try {
            xSql = "select * from blog_category";
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            int xId;
            String xName;
            Blog_Category x;
            while(rs.next()){
                xId = rs.getInt("id");
                xName = rs.getString("name");
                x = new Blog_Category(xId,xName);
                b.add(x);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Blog_CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (b);
    }
}
