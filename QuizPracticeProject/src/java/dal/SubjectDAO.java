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
            int xDimesion_id;
            String xName;
            String xCategory;
            boolean xStatus;
            String xDescription;
            Subject x;
            while (rs.next()) {
                xID = rs.getInt("id");
                xDimesion_id = rs.getInt("dimension_id");

                xName = rs.getString("name");
                xCategory = rs.getString("category");
                xStatus = rs.getBoolean("status");
                xDescription = rs.getString("description");

                x = new Subject(xID, xDimesion_id, xName, xCategory, xStatus, xDescription);
                t.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (t);
    }

    public List<Subject> getSubjectsByID(int id) {
        List<Subject> t = new ArrayList<>();
        xSql = "select * from subject where id = ?";
        try {
            ps = con.prepareStatement(xSql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            int xDimesion_id;
            String xName;
            String xCategory;
            boolean xStatus;
            String xDescription;
            Subject x;
            while (rs.next()) {

                xDimesion_id = rs.getInt("dimension_id");

                xName = rs.getString("name");
                xCategory = rs.getString("category");
                xStatus = rs.getBoolean("status");
                xDescription = rs.getString("description");

                x = new Subject(id, xDimesion_id, xName, xCategory, xStatus, xDescription);
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

