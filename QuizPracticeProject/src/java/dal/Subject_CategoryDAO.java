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
public class Subject_CategoryDAO extends MyDAO{
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
}
