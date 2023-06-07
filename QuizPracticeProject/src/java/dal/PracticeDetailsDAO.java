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
        String sql = "SELECT subject_category.name FROM subject_category WHERE subject_category.id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("subject_category.name");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    //get subject dimension name by id
    public String getSubjectDimensionNameById(int id) {
        String sql = "SELECT dimension.name FROM dimension WHERE dimension.id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("dimension.name");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
}
