/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Slider;

/**
 *
 * @author ADMIN
 */
public class SliderDAO extends MyDAO {

    public List<Slider> getSlider() {
        List<Slider> s = new ArrayList<>();
        try {
            xSql = "select * from slider";
            ps = con.prepareStatement(xSql);
            rs = ps.executeQuery();
            int xID;
            String xTitle;
            String xImage;
            String xBacklink;
            boolean xStatus;
            Date xCreated;
            Date xModified;
            Slider x;
            while (rs.next()) {
                xID = rs.getInt("id");
                xTitle = rs.getString("title");
                xImage = rs.getString("image");
                xBacklink = rs.getString("backlink");
                xStatus = rs.getBoolean("status");
                xCreated = rs.getDate("created");
                xModified = rs.getDate("modified");
                x = new Slider(xID, xTitle, xImage, xBacklink, xStatus, xCreated, xModified);
                s.add(x);
            }
            rs.close();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(SliderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (s);
    }

    public List<Slider> getSliderByStatus(boolean status) {
        List<Slider> sliders = new ArrayList<>();
        try {
            String query = "SELECT * FROM slider WHERE status = ?";
            ps = con.prepareStatement(query);
            ps.setBoolean(1, status);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String image = rs.getString("image");
                String backlink = rs.getString("backlink");
                boolean xStatus = rs.getBoolean("status");
                Date created = rs.getDate("created");
                Date modified = rs.getDate("modified");
                Slider slider = new Slider(id, title, image, backlink, xStatus, created, modified);
                sliders.add(slider);
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(SliderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sliders;
    }

    public List<Slider> delete(int id) {
        String sql = "delete from slider where id = ?";
        List<Slider> sliders = new ArrayList<Slider>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            sliders = getSlider();
        } catch (Exception e) {
        }
        return sliders;
    }

    public Slider getOneSlider(int id) {
        String sql = "select id, title, image, backlink, status, created, modified from slider where id = ?";
        Slider s = new Slider();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int Id = rs.getInt(1);
                String title = rs.getString(2);
                String image = rs.getString(3);
                String backlink = rs.getString(4);
                boolean status = rs.getBoolean(5);
                Date created = rs.getDate(6);
                Date modified = rs.getDate(7);
                s = new Slider(Id, title, image, backlink, status, created, modified);
            }
        } catch (Exception e) {
        }
        return s;
    }

    public List<Slider> updateSlider(String title, String image, int id, String backlink) {
        String sql = "update Slider set title = ?, image = ?, backlink= ? where id = ?";
        List<Slider> us = new ArrayList<Slider>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, title);
            ps.setString(2, image);
            ps.setString(3, backlink);
            ps.setInt(4, id);
            ps.executeUpdate();
            us = getSlider();
        } catch (Exception e) {
        }
        return us;
    }

    public List<Slider> searchSlider(String keyword) {
        List<Slider> searchs = new ArrayList<>();
        xSql = "select * from [slider] where title like ? ";
        int xId;
        String xTitle;
        String xImage;
        String xBacklink;
        Slider x = null;
        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, "%" + keyword + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                xId = rs.getInt("id");
                xTitle = rs.getString("title");
                xImage = rs.getString("image");
                xBacklink = rs.getString("backlink");

                x = new Slider(xId, xTitle, xImage, xBacklink);
                searchs.add(x);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return searchs;
    }

}
