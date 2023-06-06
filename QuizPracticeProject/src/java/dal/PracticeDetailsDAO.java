/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

/**
 *
 * @author dai
 */
public class PracticeDetailsDAO extends MyDAO {
    //get subject_category name by id
    public String getSubjectCategoryNameById(int id) {
        String sql = "SELECT subject_category_name FROM subject_category WHERE subject_category_id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("subject_category_name");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    //subject dimension name by id
    public String getSubjectDimensionNameById(int id) {
        String sql = "SELECT dimension_name FROM dimension WHERE dimension_id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("dimension_name");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
}
