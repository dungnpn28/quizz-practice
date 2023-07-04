/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import java.util.List;
import model.Dimension;

/**
 *
 * @author Dell
 */
public class DimensionDAO extends MyDAO {

    public List<Dimension> getDimensionBySubjectId(int index, int subjectid) {
        List<Dimension> t = new ArrayList<>();
        xSql = "select id,name,type_id,description from dimension inner join subject_dimension on dimension.id = subject_dimension.dimension_id where subject_id = ? order by id offset ? rows fetch next 5 rows only";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, subjectid);
            ps.setInt(2, (index - 1) * 5);
            rs = ps.executeQuery();
            int xID;
            String xName;
            int xType_id;
            String xDescription;

            Dimension x;
            while (rs.next()) {
                xID = rs.getInt("id");
                xName = rs.getString("name");
                xType_id = rs.getInt("type_id");
                xDescription = rs.getString("description");

                x = new Dimension(xID, xName, xType_id, xDescription);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println("getDimensionBySubjectId:" + e.getMessage());
        }
        return (t);
    }

    public int countDimensionBySubjectIdWithPaging(int subjectid) {
        try {
            String strSelect = "select count(*) from dimension inner join subject_dimension on dimension.id = subject_dimension.subject_id where subject_dimension.subject_id =?";
            ps = con.prepareStatement(strSelect);
            ps.setInt(1, subjectid);
            rs = ps.executeQuery();

            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("countDimensionBySubjectIdWithPaging: " + e.getMessage());
        }

        return 0;
    }

    public void updateDimension(int id, String name, int type, String description) {
        xSql = "update dimension set name=?,type_id=?,description=? where id = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, name);
            ps.setInt(2, type);
            ps.setString(3, description);
            ps.setInt(4, id);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("updateDimension: " + e.getMessage());
        }
    }

    public void deleteSubjectDimension(int dimensionid, int subjectid) {
        xSql = "delete from subject_dimension where dimension_id = ? and subject_id = ?";
        try {
            ps = con.prepareStatement(xSql);

            ps.setInt(1, dimensionid);
            ps.setInt(2, subjectid);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("deleteSubjectDimension: " + e.getMessage());
        }
    }

    public void addDimension(String name, int type, String description) {
        xSql = "insert into dimension values(?,?,?)";
        try {
            ps = con.prepareStatement(xSql);

            ps.setString(1, name);
            ps.setInt(2, type);
            ps.setString(3, description);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("addDimension: " + e.getMessage());
        }
    }

    public int getLastId() {
        xSql = "select max(id) from dimension";
        try {
            ps = con.prepareStatement(xSql);

            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("getLastId(): " + e.getMessage());
        }
        return 0;
    }
     public void addSubjectDimension(int a, int subjectId) {
        xSql = "insert into subject_dimension values(?,?)";
        try {
            ps = con.prepareStatement(xSql);

            ps.setInt(1, subjectId);
            ps.setInt(2, a);
           
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("addSubjectDimension: " + e.getMessage());
        }
    }
     public void deleteDimension(int id) {
        xSql = "delete from dimension where id =?";
        try {
            ps = con.prepareStatement(xSql);
          
            ps.setInt(1,id);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("deleteDimension: " + e.getMessage());
        }
    }

}
