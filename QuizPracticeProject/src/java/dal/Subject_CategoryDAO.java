/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import java.util.List;
import model.Subject_Category;

/**
 *
 * @author LENOVO
 */
public class Subject_CategoryDAO extends MyDAO {

    public List<Subject_Category> getSubjectCategory() {
        List<Subject_Category> t = new ArrayList<>();
        xSql = "select * from subject_category";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            int xID;
            String xName;

            Subject_Category x;
            while (rs.next()) {
                xID = rs.getInt("id");
                xName = rs.getString("name");
                x = new Subject_Category(xID, xName);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public String getCategoryName(int categoryId) {
        xSql = "select name from subject_category where id = ?";
        String xName ="";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, categoryId);
            rs = ps.executeQuery();


            if (rs.next()) {
                xName = rs.getString("name");
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return xName;
    }
    
    public int getCategoryId(String subjectId) {
        xSql = "select category_id from subject where id = ?";
        int xCategoryId = 0;
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, subjectId);
            rs = ps.executeQuery();
            if (rs.next()) {
                xCategoryId = rs.getInt("category_id");
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return xCategoryId;
    }
}
