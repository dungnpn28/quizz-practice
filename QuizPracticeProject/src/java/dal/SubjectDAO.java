/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import java.util.List;
import model.Subject;

/**
 *
 * @author LENOVO
 */
public class SubjectDAO extends MyDAO {

    public List<Subject> getSubjects() {
        List<Subject> t = new ArrayList<>();
        xSql = "select * from subject";
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            int xID;
            String xIllustratoin;
            int xDimesion_id;
            String xName;
            int xCategory;
            boolean xStatus;
            String xDescription;
            boolean xFeatured;
            Subject x;
            while (rs.next()) {
                xID = rs.getInt("id");
                xIllustratoin = rs.getString("illustration");
                xDimesion_id = rs.getInt("dimension_id");

                xName = rs.getString("name");
                xCategory = rs.getInt("category_id");
                xStatus = rs.getBoolean("status");
                xDescription = rs.getString("description");
                xFeatured = rs.getBoolean("featured");
                x = new Subject(xID, xIllustratoin, xDimesion_id, xName, xCategory, xStatus, xDescription, xFeatured);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public List<Subject> getSubjectsWithPaging(int page, int PAGE_SIZE) {
        List<Subject> t = new ArrayList<>();
        xSql = "select * from subject"
                + "							   order by subject.updated_date ASC\n"
                + "							   offset (?-1)*? row fetch next ? rows only";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, page);
            ps.setInt(2, PAGE_SIZE);
            ps.setInt(3, PAGE_SIZE);
            rs = ps.executeQuery();
            int xID;
            String xIllustratoin;
            int xDimesion_id;
            String xName;
            int xCategory;
            boolean xStatus;
            String xDescription;
            boolean xFeatured;
            Subject x;
            while (rs.next()) {
                xID = rs.getInt("id");
                xIllustratoin = rs.getString("illustration");
                xDimesion_id = rs.getInt("dimension_id");

                xName = rs.getString("name");
                xCategory = rs.getInt("category_id");
                xStatus = rs.getBoolean("status");
                xDescription = rs.getString("description");
                xFeatured = rs.getBoolean("featured");
                x = new Subject(xID, xIllustratoin, xDimesion_id, xName, xCategory, xStatus, xDescription, xFeatured);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public int getTotalSubject() {
        xSql = "select count(id)  from subject";
        int totalSubject = 0;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (totalSubject);
    }

    public List<Subject> getRegistedSubjectsWithPaging(int page, int PAGE_SIZE) {
        List<Subject> t = new ArrayList<>();
        xSql = "Select * from subject\n"
                + "where featured = 1\n"
                + "order by updated_date DESC\n"
                + "offset (?-1)*? row fetch next ? rows only";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, page);
            ps.setInt(2, PAGE_SIZE);
            ps.setInt(3, PAGE_SIZE);
            rs = ps.executeQuery();
            int xID;
            String xIllustratoin;
            int xDimesion_id;
            String xName;
            int xCategory;
            boolean xStatus;
            String xDescription;
            boolean xFeatured;
            Subject x;
            while (rs.next()) {
                xID = rs.getInt("id");
                xIllustratoin = rs.getString("illustration");
                xDimesion_id = rs.getInt("dimension_id");

                xName = rs.getString("name");
                xCategory = rs.getInt("category_id");
                xStatus = rs.getBoolean("status");
                xDescription = rs.getString("description");
                xFeatured = rs.getBoolean("featured");
                x = new Subject(xID, xIllustratoin, xDimesion_id, xName, xCategory, xStatus, xDescription, xFeatured);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }
    
    public int getTotalRegistedSubject() {
        xSql = "select count(id) from subject where featured = 1";
        int totalSubject = 0;
        try {
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (totalSubject);
    }

    public List<Subject> getSubjectsByID(int id) {
        List<Subject> t = new ArrayList<>();
        xSql = "select * from subject where id = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            String xIllustration;
            int xDimesion_id;
            String xName;
            int xCategory_id;
            boolean xStatus;
            String xDescription;
            Subject x;
            while (rs.next()) {
                xIllustration = rs.getString("illustration");
                xDimesion_id = rs.getInt("dimension_id");

                xName = rs.getString("name");
                xCategory_id = rs.getInt("xCategory_id");
                xStatus = rs.getBoolean("status");
                xDescription = rs.getString("description");

                x = new Subject(id, xIllustration, xDimesion_id, xName, xCategory_id, xStatus, xDescription);
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
